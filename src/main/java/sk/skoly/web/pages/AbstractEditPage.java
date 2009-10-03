package sk.skoly.web.pages;

import net.databinder.hib.Databinder;

import org.apache.wicket.IPageMap;
import org.apache.wicket.PageParameters;
import org.apache.wicket.feedback.FeedbackMessages;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.model.StringResourceModel;
import org.apache.wicket.protocol.http.WebSession;
import org.hibernate.Session;

import sk.skoly.web.SchoolsApplication;

public abstract class AbstractEditPage<T> extends AbstractWebPage {
	private IModel<T> object;

	protected class DeleteButton extends Button {

		private final Class<? extends WebPage> nextPage;

		public DeleteButton(String id, IModel<String> model, Class<? extends WebPage> nextPage) {
			super(id, model);
			this.nextPage = nextPage;
			setDefaultFormProcessing(false);
		}

		@Override
		public void onSubmit() {
			delete();
			setResponsePage(nextPage);
			WebSession.get().info(String.format("Deleted: %s", AbstractEditPage.this.getObject().getObject().toString()));
		}

	}

	protected class SaveContinueButton extends Button {

		public SaveContinueButton(String id, IModel<String> model) {
			super(id, model);
		}

		@Override
		public void onSubmit() {
			WebSession.get().info(String.format("Saved: %s", AbstractEditPage.this.getObject().getObject().toString()));
		}
	}

	protected class SaveButton extends Button {

		private final Class<? extends WebPage> nextPage;

		public SaveButton(String id, IModel<String> model, Class<? extends WebPage> nextPage) {
			super(id, model);
			this.nextPage = nextPage;
		}

		@Override
		public void onSubmit() {
			setResponsePage(nextPage);
			WebSession.get().info(String.format("Saved: %s", AbstractEditPage.this.getObject().getObject().toString()));
		}

	}

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

	protected void delete() {
		Session session = Databinder.getHibernateSession();
		T entity = object.getObject();
		if (session.contains(entity)) {
			session.delete(entity);
			session.getTransaction().commit();
		}
	}
}
