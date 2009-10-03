package sk.skoly.web.pages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import net.databinder.models.hib.HibernateListModel;

import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.StringResourceModel;
import org.hibernate.Criteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.MatchMode;

import sk.skoly.model.Platca;
import sk.skoly.model.Student;
import sk.skoly.web.components.genericform.Field;
import sk.skoly.web.components.genericform.GenericFormPanel;
import sk.skoly.web.components.listaction.ColumnsFactory;
import sk.skoly.web.components.listaction.ListActionFormPanel.DeleteAction;
import sk.skoly.web.components.listaction.ListActionFormPanel.IAction;

public class StudentListPage extends AbstractListPage<Student> {
	public String priezvisko;
	public String meno;
	public Platca platca;

	@SuppressWarnings("unchecked")
	public StudentListPage() {
		super(ColumnsFactory.createColumnsFor(Student.class), StudentPage.EDIT_PAGE_FACTORY);
		Form form = new Form("filter_form");
		
		List list = new ArrayList();
		list.add(new Field.StringField<Student>("student.meno", "meno"));
		list.add(new Field.StringField<Student>("student.priezvisko", "priezvisko"));
		list.add(new Field.CodebookField("student.platca", "platca", new HibernateListModel<Platca>(Platca.class), true));
		form.add(new GenericFormPanel("data", new Model(this), list));
		form.add(new Button("filter", new StringResourceModel("button.filter", null)));
		add(form);
	}

	@SuppressWarnings("unchecked")
	@Override
	protected List<? extends IAction<Student>> getActions() {
		return Arrays.<IAction<Student>> asList(new DeleteAction());
	}

	@Override
	public void buildOrdered(Criteria criteria) {
		buildUnordered(criteria);
	}

	@Override
	public void buildUnordered(Criteria criteria) {
		if (priezvisko!=null) {
			criteria.add(Expression.ilike("priezvisko", priezvisko, MatchMode.START));
		}
		if (meno!=null) {
			criteria.add(Expression.ilike("meno", meno, MatchMode.START));
		}
		if (platca!=null) {
			criteria.add(Expression.eq("platca", platca));
		}
	}

}
