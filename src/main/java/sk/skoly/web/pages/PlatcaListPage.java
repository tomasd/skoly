package sk.skoly.web.pages;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Criteria;

import sk.skoly.model.Platca;
import sk.skoly.web.components.listaction.ColumnsFactory;
import sk.skoly.web.components.listaction.ListActionFormPanel.DeleteAction;
import sk.skoly.web.components.listaction.ListActionFormPanel.IAction;

public class PlatcaListPage extends AbstractListPage<Platca> {

	public PlatcaListPage() {
		super(ColumnsFactory.createColumnsFor(Platca.class), PlatcaPage.EDIT_PAGE_FACTORY);
	}

	@SuppressWarnings("unchecked")
	@Override
	protected List<? extends IAction<Platca>> getActions() {
		return Arrays.<IAction<Platca>> asList(new DeleteAction());
	}

	@Override
	public void buildOrdered(Criteria criteria) {
		// TODO Auto-generated method stub

	}

	@Override
	public void buildUnordered(Criteria criteria) {
		// TODO Auto-generated method stub

	}

}