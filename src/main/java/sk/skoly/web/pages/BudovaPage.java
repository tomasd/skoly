package sk.skoly.web.pages;

import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.PageParameters;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.model.StringResourceModel;

import sk.skoly.model.SkupinaVyucovacichMiest;
import sk.skoly.web.components.genericform.Field;
import sk.skoly.web.components.genericform.GenericFormPanel;
import sk.skoly.web.components.genericform.Field.DateField;
import sk.skoly.web.components.genericform.Field.StringField;
import sk.skoly.web.components.listaction.EditPageFactory;
import sk.skoly.web.components.listaction.ListActionFormPanel.SimplePageFactory;

public class BudovaPage extends AbstractEditPage<SkupinaVyucovacichMiest> {
	public static final EditPageFactory<SkupinaVyucovacichMiest> EDIT_PAGE_FACTORY = new SimplePageFactory<SkupinaVyucovacichMiest>(
			SkupinaVyucovacichMiest.class, BudovaPage.class, "id", "id");

	@Override
	protected IModel<SkupinaVyucovacichMiest> getObjectModel() {
		// return new
		// Model<SkupinaVyucovacichMiest>(SkupinaVyucovacichMiest.getById(getPageParameters().getInt("id")));
		return null;
	}

	public BudovaPage(PageParameters parameters) {
		super(parameters);

		PropertyModel<SkupinaVyucovacichMiest> model = new PropertyModel<SkupinaVyucovacichMiest>(this, "object");
		Form<SkupinaVyucovacichMiest> form = new Form<SkupinaVyucovacichMiest>("edit_form", model);
		add(form);

		List<Field<?, SkupinaVyucovacichMiest>> fields = new ArrayList<Field<?, SkupinaVyucovacichMiest>>();
		fields.add(new StringField<SkupinaVyucovacichMiest>("building.name", "name"));
		fields.add(new DateField<SkupinaVyucovacichMiest>("building.created", "created"));

		form.add(new GenericFormPanel<SkupinaVyucovacichMiest>("generic", model, fields));
		form.add(new Button("save_button", new StringResourceModel("button.save", null)));
	}
}
