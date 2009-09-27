package sk.skoly.web.pages;

import java.util.Collections;
import java.util.List;

import org.hibernate.Criteria;

import sk.skoly.model.SkupinaVyucovacichMiest;
import sk.skoly.web.components.listaction.ColumnsFactory;
import sk.skoly.web.components.listaction.ListActionFormPanel.DeleteAction;
import sk.skoly.web.components.listaction.ListActionFormPanel.IAction;

@SuppressWarnings("serial")
public class SkupinaVyucovacichMiestListPage extends AbstractListPage<SkupinaVyucovacichMiest> {

	public SkupinaVyucovacichMiestListPage() {
		super(ColumnsFactory.createColumnsFor(SkupinaVyucovacichMiest.class), SkupinaVyucovacichMiestPage.EDIT_PAGE_FACTORY);
	}

	@Override
	protected List<? extends IAction<SkupinaVyucovacichMiest>> getActions() {
		return Collections.singletonList(new DeleteAction<SkupinaVyucovacichMiest>());
	}

	@Override
	public void buildOrdered(Criteria criteria) {

	}

	@Override
	public void buildUnordered(Criteria criteria) {

	}

}
