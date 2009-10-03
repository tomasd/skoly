package sk.skoly.web.components.listaction;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.databinder.hib.Databinder;

import org.apache.wicket.PageParameters;
import org.apache.wicket.extensions.markup.html.repeater.data.grid.ICellPopulator;
import org.apache.wicket.extensions.markup.html.repeater.data.table.DefaultDataTable;
import org.apache.wicket.extensions.markup.html.repeater.data.table.HeaderlessColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.ISortableDataProvider;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.MarkupStream;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Check;
import org.apache.wicket.markup.html.form.CheckGroup;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.FormComponentLabel;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.panel.Fragment;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.model.StringResourceModel;
import org.apache.wicket.util.lang.PropertyResolver;
import org.hibernate.Session;

@SuppressWarnings("serial")
public class ListActionFormPanel<T extends Serializable> extends Panel {
	public interface IAction<T> extends Serializable {
		@Override
		String toString();

		void doAction(List<T> selected);
	}

	public static class DeleteAction<T> implements IAction<T> {

		@Override
		public void doAction(List<T> selected) {
			Session session = Databinder.getHibernateSession();
			for (T object : selected) {
				if (session.contains(object)) {
					session.delete(object);
					session.getTransaction().commit();
				}
			}
		}

		@Override
		public String toString() {
			return "Delete";
		}

	}

	public static class SimplePageFactory<T> implements EditPageFactory<T> {
		private Class<? extends WebPage> pageClass;
		private String parameterKey;
		private String objectProperty;
		private Class<T> type;

		public SimplePageFactory(Class<T> type, Class<? extends WebPage> pageClass, String parameterKey, String objectProperty) {
			super();
			this.type = type;
			this.pageClass = pageClass;
			this.parameterKey = parameterKey;
			this.objectProperty = objectProperty;
		}

		@Override
		public PageParameters createPageParameters(T object) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put(parameterKey, PropertyResolver.getValue(objectProperty, object));
			return new PageParameters(map);
		}

		@Override
		public Class<T> getType() {
			return type;
		}

		@Override
		public Class<? extends WebPage> getPageClass() {
			return pageClass;
		}

	}

	private List<T> selectedObjects = new ArrayList<T>();
	public IAction<T> action;
	private final EditPageFactory<T> editPageFactory;

	private final class CheckColumn extends HeaderlessColumn<T> {

		@Override
		public void populateItem(Item<ICellPopulator<T>> cellItem, String componentId, IModel<T> rowModel) {
			Check<T> check = new Check<T>(componentId, rowModel) {

				@Override
				protected void onComponentTag(ComponentTag tag) {
					tag.setName("input");
					tag.getAttributes().put("type", "checkbox");
					super.onComponentTag(tag);
				}

				@Override
				protected void onComponentTagBody(MarkupStream markupStream, ComponentTag openTag) {
					markupStream.next();
				}
			};
			cellItem.add(check);
		}

	}

	private final class EditColumn extends HeaderlessColumn<T> {

		@Override
		public void populateItem(Item<ICellPopulator<T>> cellItem, String componentId, IModel<T> rowModel) {
			Fragment fragment = new Fragment(componentId, "editfragment", ListActionFormPanel.this);
			cellItem.add(fragment);

			BookmarkablePageLink<T> link = new BookmarkablePageLink<T>("link", editPageFactory.getPageClass(), editPageFactory.createPageParameters(rowModel
					.getObject()));
			link.add(new Label("label", new StringResourceModel("edit", null)));
			fragment.add(link);
		}
	}

	@SuppressWarnings("unchecked")
	public ListActionFormPanel(String id, IColumn<T>[] columns, ISortableDataProvider<T> dataProvider, int rowsPerPage, List<IAction> actions,
			EditPageFactory<T> editPageFactory) {
		super(id);
		this.editPageFactory = editPageFactory;
		List<IColumn<T>> columnsList = new ArrayList<IColumn<T>>(Arrays.asList(columns));
		columnsList.add(0, new CheckColumn());
		columnsList.add(new EditColumn());

		Form<T> form = new Form<T>("action_form") {
			@Override
			protected void onSubmit() {
				action.doAction(selectedObjects);
			}
		};
		add(form);
		CheckGroup<T> checkGroup = new CheckGroup<T>("selected_rows", new Model((Serializable) selectedObjects));
		checkGroup.setRenderBodyOnly(true);
		form.add(checkGroup);
		form.add(new org.apache.wicket.markup.html.form.Button("do", new StringResourceModel("do", null)));
		DropDownChoice<IAction> actionDropdown = new DropDownChoice<IAction>("action", new PropertyModel<IAction>(this, "action"), actions);
		form.add(actionDropdown.setRequired(true).setLabel(new StringResourceModel("label.action", null)));
		form.add(new FormComponentLabel("action_label", actionDropdown));

		checkGroup.add(new DefaultDataTable<T>("table", columnsList, dataProvider, rowsPerPage));
	}

}
