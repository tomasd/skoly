package sk.skoly.web.pages;

import java.util.Arrays;
import java.util.List;

import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.extensions.markup.html.repeater.util.SortableDataProvider;

import sk.skoly.model.SkupinaVyucovacichMiest;
import sk.skoly.web.components.listaction.ColumnsFactory;
import sk.skoly.web.components.listaction.ListActionFormPanel;
import sk.skoly.web.components.listaction.ListActionFormPanel.IAction;

@SuppressWarnings("serial")
public class BudovaListPage extends AbstractWebPage {
	class DeleteAction implements IAction<SkupinaVyucovacichMiest> {
		
		@Override
		public void doAction(List<SkupinaVyucovacichMiest> selected) {
		}

		@Override
		public String toString() {
			return getString("delete");
		}
	}


	@SuppressWarnings("unchecked")
	public BudovaListPage() {
		super();
//		IColumn[] columns = new IColumn[] {new PropertyColumn<SkupinaVyucovacichMiest>(new Model("name"), "name") };
		IColumn[] columns = ColumnsFactory.createColumnsFor(SkupinaVyucovacichMiest.class);


		SortableDataProvider<SkupinaVyucovacichMiest> dataProvider = null;
		add(new ListActionFormPanel<SkupinaVyucovacichMiest>("action_table", columns, dataProvider, 10, Arrays.<IAction>asList(new DeleteAction()), BudovaPage.EDIT_PAGE_FACTORY));
	}

}
