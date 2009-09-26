package sk.skoly.web.pages;

import org.apache.wicket.IPageMap;
import org.apache.wicket.PageParameters;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.model.StringResourceModel;

public abstract class AbstractEditPage<T> extends AbstractWebPage {
	private IModel<T> object;

	protected abstract IModel<T> getObjectModel();

	public final IModel<T> getObject() {
		if (object == null) {
			object = getObjectModel();

		}
		return object;
	}

	public AbstractEditPage() {
		super();
		init();
	}

	public AbstractEditPage(IModel<?> model) {
		super(model);
		init();

	}

	public AbstractEditPage(IPageMap pageMap, IModel<?> model) {
		super(pageMap, model);
		init();

	}

	public AbstractEditPage(IPageMap pageMap, PageParameters parameters) {
		super(pageMap, parameters);
		init();

	}

	public AbstractEditPage(IPageMap pageMap) {
		super(pageMap);
		init();

	}

	public AbstractEditPage(PageParameters parameters) {
		super(parameters);
		init();

	}
	
	private void init() {
		
	}

	@Override
	public IModel<String> getLabel() {
		return new StringResourceModel("page." + getClass().getSimpleName() + ".title", null, new Object[] { new PropertyModel<String>(getObject(), "") });
	}
}
