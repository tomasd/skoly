package sk.skoly.web.components.genericform;

import static java.util.Arrays.asList;

import java.util.List;

import org.apache.wicket.markup.html.form.FormComponent;
import org.apache.wicket.markup.html.form.SimpleFormComponentLabel;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;

public class GenericFormPanel<T> extends Panel {
	public GenericFormPanel(String id, IModel<T> model, Field<?, T>... properties) {
		super(id);
		init(model, properties);
	}
	@SuppressWarnings("unchecked")
	public GenericFormPanel(String id, IModel<T> model, List<Field<?, T>> properties) {
		super(id);
		init(model, properties.toArray(new Field[properties.size()]));
	}

	private void init(IModel<T> model, Field<?, T>... properties) {
		setRenderBodyOnly(true);
		for (Field<?, T> property : properties) {
			property.setObjectModel(model);
		}
		add(new ListView<Field<?, T>>("list", asList(properties)) {

			@Override
			protected void populateItem(ListItem<Field<?, T>> item) {
				Field<?, T> field = item.getModelObject();

				FormComponent<?> formComponent = field.createComponent("form_component");
				formComponent.setLabel(field.getLabel());
				item.add(formComponent);
				item.add(new SimpleFormComponentLabel("label", formComponent));
			}

		});
	}
}
