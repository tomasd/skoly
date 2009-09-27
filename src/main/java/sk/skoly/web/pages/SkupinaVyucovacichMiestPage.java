package sk.skoly.web.pages;

import java.util.ArrayList;
import java.util.List;

import net.databinder.components.hib.DataForm;
import net.databinder.models.hib.HibernateObjectModel;

import org.apache.wicket.PageParameters;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.StringResourceModel;

import sk.skoly.model.SkupinaVyucovacichMiest;
import sk.skoly.web.components.genericform.Field;
import sk.skoly.web.components.genericform.FieldFactory;
import sk.skoly.web.components.genericform.GenericFormPanel;
import sk.skoly.web.components.listaction.EditPageFactory;
import sk.skoly.web.components.listaction.ListActionFormPanel;

public class SkupinaVyucovacichMiestPage extends AbstractEditPage<SkupinaVyucovacichMiest> {
	public static EditPageFactory<SkupinaVyucovacichMiest> EDIT_PAGE_FACTORY = new ListActionFormPanel.SimplePageFactory<SkupinaVyucovacichMiest>(SkupinaVyucovacichMiest.class, SkupinaVyucovacichMiestPage.class, "id", "id");

	@SuppressWarnings("unchecked")
	public SkupinaVyucovacichMiestPage(PageParameters parameters) {
		super(parameters);
		DataForm<SkupinaVyucovacichMiest> form = new DataForm<SkupinaVyucovacichMiest>("form", (HibernateObjectModel<SkupinaVyucovacichMiest>) getObject());
		List list = new ArrayList();
		
		list.add(new Field.StringField("skupinavyucovacichmiest.nazov", "nazov"));
		list.add(new Field.StringField("skupinavyucovacichmiest.ulica", "ulica"));
		list.add(new Field.StringField("skupinavyucovacichmiest.psc", "psc"));
		list.add(new Field.StringField("skupinavyucovacichmiest.mesto", "mesto"));
		
		form.add(new GenericFormPanel<SkupinaVyucovacichMiest>("data", getObject(), list));
		form.add(new Button("save", new StringResourceModel("button.save", null)));
		add(form);

	}

	@Override
	protected IModel<SkupinaVyucovacichMiest> getObjectModel() {
		Integer id = getPageParameters().getAsInteger("id");
		return new HibernateObjectModel<SkupinaVyucovacichMiest>(SkupinaVyucovacichMiest.class, id);
	}

}
