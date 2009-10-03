/**
 * 
 */
package sk.skoly.web.components.genericform;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.apache.wicket.extensions.markup.html.form.DateTextField;
import org.apache.wicket.extensions.yui.calendar.DatePicker;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.FormComponent;
import org.apache.wicket.markup.html.form.IChoiceRenderer;
import org.apache.wicket.markup.html.form.TextArea;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.model.StringResourceModel;

public interface Field<Property, MainObject> extends Serializable {
	IModel<String> getLabel();

	IModel<Property> getPropertyModel();

	void setObjectModel(IModel<MainObject> model);

	FormComponent<Property> createComponent(String componentId);
	
	

	abstract class AbstractField<Property, MainObject> implements Field<Property, MainObject> {

		private String labelResourceKey;
		private String objectProperty;
		private IModel<MainObject> model;

		public AbstractField(String labelResourceKey, String objectProperty) {
			super();
			this.labelResourceKey = labelResourceKey;
			this.objectProperty = objectProperty;
		}

		@Override
		public void setObjectModel(IModel<MainObject> model) {
			this.model = model;
		}

		@Override
		public IModel<String> getLabel() {
			return new StringResourceModel(labelResourceKey, null);
		}

		@Override
		public IModel<Property> getPropertyModel() {
			return new PropertyModel<Property>(model, objectProperty);
		}

	}

	public class StringField<MainObject> extends AbstractField<String, MainObject> {

		public StringField(String labelResourceKey, String objectProperty) {
			super(labelResourceKey, objectProperty);
		}

		@Override
		public FormComponent<String> createComponent(String componentId) {
			return new TextField<String>(componentId, getPropertyModel());
		}

	}

	public class BigStringField<MainObject> extends AbstractField<String, MainObject> {

		public BigStringField(String labelResourceKey, String objectProperty) {
			super(labelResourceKey, objectProperty);
		}

		@Override
		public FormComponent<String> createComponent(String componentId) {
			return new TextArea<String>(componentId, getPropertyModel());
		}

	}

	public class DateField<MainObject> extends AbstractField<Date, MainObject> {

		public DateField(String labelResourceKey, String objectProperty) {
			super(labelResourceKey, objectProperty);
		}

		@Override
		public FormComponent<Date> createComponent(String componentId) {
			DateTextField dateTextField = new DateTextField(componentId, getPropertyModel());
			dateTextField.add(new DatePicker());
			return dateTextField;
		}

	}

	public class CodebookField<Property, MainObject> extends AbstractField<Property, MainObject> {

		public final class SelectDropdownChoice extends DropDownChoice<Property> {
			private SelectDropdownChoice(String id, IModel<Property> model, IModel<? extends List<? extends Property>> choices) {
				super(id, model, choices);
			}

			public SelectDropdownChoice(String id, IModel<Property> model, IModel<? extends List<? extends Property>> choices,
					IChoiceRenderer<? super Property> renderer) {
				super(id, model, choices, renderer);
			}

			public SelectDropdownChoice(String id, IModel<Property> model, List<? extends Property> data, IChoiceRenderer<? super Property> renderer) {
				super(id, model, data, renderer);
			}

			public SelectDropdownChoice(String id, IModel<Property> model, List<? extends Property> choices) {
				super(id, model, choices);
			}

			@Override
			protected void onComponentTag(ComponentTag tag) {
				tag.setName("select");
				super.onComponentTag(tag);
			}

		}

		private IModel<List<Property>> choicesModel;
		private List<Property> choices;
		private IChoiceRenderer<Property> choiceRenderer;
		private boolean nullValid;
		
		public CodebookField(String labelResourceKey, String objectProperty, IModel<List<Property>> choices) {
			super(labelResourceKey, objectProperty);
			this.choicesModel = choices;
		}
		public CodebookField(String labelResourceKey, String objectProperty, IModel<List<Property>> choices, boolean nullValid) {
			super(labelResourceKey, objectProperty);
			this.choicesModel = choices;
			this.nullValid = nullValid;
		}

		public CodebookField(String labelResourceKey, String objectProperty, List<Property> choices) {
			super(labelResourceKey, objectProperty);
			this.choices = choices;
		}

		public CodebookField(String labelResourceKey, String objectProperty, IModel<List<Property>> choices, IChoiceRenderer<Property> choiceRenderer) {
			this(labelResourceKey, objectProperty, choices);
			this.choiceRenderer = choiceRenderer;
		}

		public CodebookField(String labelResourceKey, String objectProperty, List<Property> choices, IChoiceRenderer<Property> choiceRenderer) {
			this(labelResourceKey, objectProperty, choices);
			this.choiceRenderer = choiceRenderer;
		}

		@Override
		public FormComponent<Property> createComponent(String componentId) {
			SelectDropdownChoice select;
			if (choicesModel != null) {
				select = new SelectDropdownChoice(componentId, getPropertyModel(), choicesModel);
				select.setChoiceRenderer(choiceRenderer);
			} else {
				select = new SelectDropdownChoice(componentId, getPropertyModel(), choices);
				select.setChoiceRenderer(choiceRenderer);
			}
			if (nullValid) {
				select.setNullValid(true);
			}
			return select;
		}
	}
}