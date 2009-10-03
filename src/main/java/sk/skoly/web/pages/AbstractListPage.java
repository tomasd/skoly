package sk.skoly.web.pages;

import java.io.Serializable;
import java.util.List;

import net.databinder.models.hib.OrderingCriteriaBuilder;
import net.databinder.models.hib.SortableHibernateProvider;

import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;

import sk.skoly.web.components.listaction.EditPageFactory;
import sk.skoly.web.components.listaction.ListActionFormPanel;
import sk.skoly.web.components.listaction.ListActionFormPanel.IAction;

public abstract class AbstractListPage<T extends Serializable> extends AbstractWebPage implements OrderingCriteriaBuilder {
	@SuppressWarnings("unchecked")
	public AbstractListPage(IColumn<T>[] columns, EditPageFactory<T> editPageFactory) {
		super();

		add(new BookmarkablePageLink<T>("create", editPageFactory.getPageClass()));
		add(new ListActionFormPanel("action_table", columns, new SortableHibernateProvider<T>(editPageFactory.getType(), this), 10, getActions(),
				editPageFactory));
		add(new Label("page_title", getLabel()));
	}

	protected abstract List<? extends IAction<T>> getActions();

}
