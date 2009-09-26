package sk.skoly.web.pages;

import org.apache.wicket.IPageMap;
import org.apache.wicket.PageParameters;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.ILabelProvider;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.StringResourceModel;

public class AbstractPage extends WebPage implements ILabelProvider<String> {

	public AbstractPage() {
		super();
		init();
	}

	public AbstractPage(IModel<?> model) {
		super(model);
		init();
	}

	public AbstractPage(IPageMap pageMap, IModel<?> model) {
		super(pageMap, model);
		init();
	}

	public AbstractPage(IPageMap pageMap, PageParameters parameters) {
		super(pageMap, parameters);
		init();
	}

	public AbstractPage(IPageMap pageMap) {
		super(pageMap);
		init();
	}

	public AbstractPage(PageParameters parameters) {
		super(parameters);
		init();
	}

	private void init() {
		add(new Label("pageTitle", getLabel()).setRenderBodyOnly(true));
	}

	@Override
	public IModel<String> getLabel() {
		return new StringResourceModel("page." + getClass().getSimpleName() + ".title", null);
	}

}
