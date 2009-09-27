package sk.skoly.web.pages;

import java.util.ArrayList;
import java.util.List;

import net.databinder.components.hib.DataForm;
import net.databinder.models.hib.HibernateObjectModel;

import org.apache.wicket.PageParameters;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.StringResourceModel;

import sk.skoly.model.Platca;
import sk.skoly.web.components.genericform.Field;
import sk.skoly.web.components.genericform.GenericFormPanel;
import sk.skoly.web.components.listaction.EditPageFactory;
import sk.skoly.web.components.listaction.ListActionFormPanel;

public class PlatcaPage extends AbstractEditPage<Platca> {
	public static EditPageFactory<Platca> EDIT_PAGE_FACTORY = new ListActionFormPanel.SimplePageFactory<Platca>(Platca.class, PlatcaPage.class, "id", "id");

	@SuppressWarnings("unchecked")
	public PlatcaPage(PageParameters parameters) {
		super(parameters);
		DataForm<Platca> form = new DataForm<Platca>("form", (HibernateObjectModel<Platca>) getObject());
		List list = new ArrayList();
		
		list.add(new Field.StringField<Platca>("platca.nazov", "nazov"));
		list.add(new Field.StringField<Platca>("platca.ico", "ico"));
		list.add(new Field.StringField<Platca>("platca.dic", "dic"));
		list.add(new Field.StringField<Platca>("platca.icDph", "icDph"));
		list.add(new Field.StringField<Platca>("platca.ulica", "ulica"));
		list.add(new Field.StringField<Platca>("platca.psc", "psc"));
		list.add(new Field.StringField<Platca>("platca.mesto", "mesto"));
		list.add(new Field.StringField<Platca>("platca.telefon", "telefon"));
		list.add(new Field.StringField<Platca>("platca.mobil", "mobil"));
		list.add(new Field.StringField<Platca>("platca.fax", "fax"));
		list.add(new Field.StringField<Platca>("platca.www", "www"));
		list.add(new Field.StringField<Platca>("platca.email", "email"));
		
		form.add(new GenericFormPanel<Platca>("data", getObject(), list));
		form.add(new Button("save", new StringResourceModel("button.save", null)));
		add(form);

	}

	@Override
	protected IModel<Platca> getObjectModel() {
		Integer id = getPageParameters().getAsInteger("id");
		return new HibernateObjectModel<Platca>(Platca.class, id);
	}

}
