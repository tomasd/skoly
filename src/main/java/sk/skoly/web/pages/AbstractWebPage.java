package sk.skoly.web.pages;

import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.IPageMap;
import org.apache.wicket.PageParameters;
import org.apache.wicket.feedback.IFeedbackMessageFilter;
import org.apache.wicket.markup.html.CSSPackageResource;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.IModel;

import sk.skoly.web.components.menupanel.MenuPanel;


public class AbstractWebPage extends AbstractPage {

	public AbstractWebPage() {
		super();
		init();
	}

	public AbstractWebPage(IModel<?> model) {
		super(model);
		init();
	}

	public AbstractWebPage(IPageMap pageMap, IModel<?> model) {
		super(pageMap, model);
		init();
	}

	public AbstractWebPage(IPageMap pageMap, PageParameters parameters) {
		super(pageMap, parameters);
		init();
	}

	public AbstractWebPage(IPageMap pageMap) {
		super(pageMap);
		init();
	}

	public AbstractWebPage(PageParameters parameters) {
		super(parameters);
		init();
	}

	private void init() {
		add(CSSPackageResource.getHeaderContribution("/css/base.css"));
		add(CSSPackageResource.getHeaderContribution("/css/all.css"));
		add(new MenuPanel("menu", getMenuPages()));
//		add(new Label("pageMainTitle", getLabel()));
		add(new FeedbackPanel("feedback", IFeedbackMessageFilter.ALL));
	}
	
	protected List<Class<? extends WebPage>> getMenuPages() {
		List<Class<? extends WebPage>> list = new ArrayList<Class<? extends WebPage>>();
		list.add(MainPage.class);
		list.add(SkupinaVyucovacichMiestListPage.class);
		list.add(PlatcaListPage.class);
		list.add(KurzListPage.class);
		list.add(LektorListPage.class);
		list.add(StudentListPage.class);
		list.add(TestListPage.class);
		return list;
	}
}
