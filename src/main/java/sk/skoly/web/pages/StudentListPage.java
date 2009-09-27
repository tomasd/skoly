package sk.skoly.web.pages;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Criteria;

import sk.skoly.model.Student;
import sk.skoly.web.components.listaction.ColumnsFactory;
import sk.skoly.web.components.listaction.ListActionFormPanel.DeleteAction;
import sk.skoly.web.components.listaction.ListActionFormPanel.IAction;

public class StudentListPage extends AbstractListPage<Student> {
	

	public StudentListPage() {
		super(ColumnsFactory.createColumnsFor(Student.class), StudentPage.EDIT_PAGE_FACTORY);

	}

	@SuppressWarnings("unchecked")
	@Override
	protected List<? extends IAction<Student>> getActions() {
		return Arrays.<IAction<Student>> asList(new DeleteAction());
	}

	@Override
	public void buildOrdered(Criteria criteria) {

	}

	@Override
	public void buildUnordered(Criteria criteria) {

	}

}
