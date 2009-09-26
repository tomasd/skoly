package sk.skoly.web.pages;

import java.util.Arrays;
import java.util.List;

import net.databinder.models.hib.OrderingCriteriaBuilder;
import net.databinder.models.hib.SortableHibernateProvider;

import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.ISortableDataProvider;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.hibernate.Criteria;

import sk.skoly.model.Student;
import sk.skoly.web.components.listaction.ColumnsFactory;
import sk.skoly.web.components.listaction.ListActionFormPanel;
import sk.skoly.web.components.listaction.ListActionFormPanel.IAction;

public class StudentListPage extends AbstractWebPage {
	private class DeleteAction implements IAction<Student> {

		@Override
		public void doAction(List<Student> selected) {

		}

	}


	public StudentListPage() {
		super();
		IColumn[] columns = ColumnsFactory.createColumnsFor(Student.class);

		ISortableDataProvider<Student> dataProvider = new SortableHibernateProvider<Student>(Student.class, new OrderingCriteriaBuilder() {

			@Override
			public void buildUnordered(Criteria criteria) {

			}

			@Override
			public void buildOrdered(Criteria criteria) {

			}
		});
		add(new BookmarkablePageLink<Student>("create", StudentPage.class));
		add(new ListActionFormPanel<Student>("action_table", columns, dataProvider, 10, Arrays.<IAction> asList(new DeleteAction()),
				StudentPage.EDIT_PAGE_FACTORY));
	}
}
