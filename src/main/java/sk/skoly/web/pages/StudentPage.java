package sk.skoly.web.pages;

import java.util.ArrayList;

import net.databinder.components.hib.DataForm;
import net.databinder.models.hib.HibernateObjectModel;

import org.apache.wicket.PageParameters;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.StringResourceModel;

import sk.skoly.model.Student;
import sk.skoly.web.components.genericform.Field;
import sk.skoly.web.components.genericform.GenericFormPanel;
import sk.skoly.web.components.listaction.EditPageFactory;
import sk.skoly.web.components.listaction.ListActionFormPanel;

public class StudentPage extends AbstractEditPage<Student> {

	public static EditPageFactory<Student> EDIT_PAGE_FACTORY = new ListActionFormPanel.SimplePageFactory<Student>(StudentPage.class, "id", "id");

	
	@SuppressWarnings("unchecked")
	public StudentPage(PageParameters parameters) {
		super(parameters);
		DataForm<Student> form = new DataForm<Student>("form", (HibernateObjectModel<Student>) getObject()){
			
		};
		ArrayList list = new ArrayList();
		list.add(new Field.StringField<Student>("priezvisko", "priezvisko"));
		list.add(new Field.StringField<Student>("meno", "meno"));
		form.add(new GenericFormPanel<Student>("data", getObject(), list));
		form.add(new Button("save", new StringResourceModel("button.save", null)));
		add(form);
	}

	@Override
	protected IModel<Student> getObjectModel() {
		Integer id = getPageParameters().getAsInteger("id");
		return new HibernateObjectModel<Student>(Student.class, id);
	}

}
