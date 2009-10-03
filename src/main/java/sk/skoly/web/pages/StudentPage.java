package sk.skoly.web.pages;

import java.util.ArrayList;

import net.databinder.components.hib.DataForm;
import net.databinder.models.hib.HibernateListModel;
import net.databinder.models.hib.HibernateObjectModel;

import org.apache.wicket.PageParameters;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.StringResourceModel;

import sk.skoly.model.Platca;
import sk.skoly.model.Student;
import sk.skoly.web.components.genericform.Field;
import sk.skoly.web.components.genericform.GenericFormPanel;
import sk.skoly.web.components.listaction.EditPageFactory;
import sk.skoly.web.components.listaction.ListActionFormPanel;

public class StudentPage extends AbstractEditPage<Student> {

	public static EditPageFactory<Student> EDIT_PAGE_FACTORY = new ListActionFormPanel.SimplePageFactory<Student>(Student.class, StudentPage.class, "id", "id");

	@SuppressWarnings("unchecked")
	public StudentPage(PageParameters parameters) {
		super(parameters);
		DataForm<Student> form = new DataForm<Student>("form", (HibernateObjectModel<Student>) getObject());
		ArrayList list = new ArrayList();
		list.add(new Field.StringField<Student>("student.priezvisko", "priezvisko"));
		list.add(new Field.StringField<Student>("student.meno", "meno"));
		list.add(new Field.StringField<Student>("student.titul", "titul"));
		list.add(new Field.CodebookField<Platca, Student>("student.platca", "platca", new HibernateListModel<Platca>(Platca.class)));

		list.add(new Field.StringField<Student>("student.email", "email"));
		list.add(new Field.StringField<Student>("student.telefon", "telefon"));
		list.add(new Field.StringField<Student>("student.mobil", "mobil"));
		list.add(new Field.StringField<Student>("student.fax", "fax"));
		list.add(new Field.StringField<Student>("student.www", "www"));

		list.add(new Field.StringField<Student>("student.ulica", "ulica"));
		list.add(new Field.StringField<Student>("student.mesto", "mesto"));
		list.add(new Field.StringField<Student>("student.psc", "psc"));
		form.add(new GenericFormPanel<Student>("data", getObject(), list));
		form.add(new SaveButton("save_list", new StringResourceModel("button.save_list", null), StudentListPage.class));
		form.add(new SaveContinueButton("save", new StringResourceModel("button.save_continue", null)));
		form.add(new DeleteButton("delete", new StringResourceModel("button.delete", null), StudentListPage.class));
		add(form);
	}

	@Override
	protected IModel<Student> getObjectModel() {
		Integer id = getPageParameters().getAsInteger("id");
		return new HibernateObjectModel<Student>(Student.class, id);
	}

}
