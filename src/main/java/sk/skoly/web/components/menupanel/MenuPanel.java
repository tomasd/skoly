package sk.skoly.web.components.menupanel;

import java.util.List;

import org.apache.wicket.behavior.AttributeAppender;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.Model;

public class MenuPanel extends Panel {

	public MenuPanel(String id, List<Class<? extends WebPage>> pages) {
		super(id);
		add(new ListView<Class<? extends WebPage>>("list", pages) {
			@Override
			protected void populateItem(ListItem<Class<? extends WebPage>> item) {
				BookmarkablePageLink link = new BookmarkablePageLink("link", item.getModelObject());

				if (getPage().getClass().equals(item.getModelObject())) {
					item.add(new AttributeAppender("class", new Model("active"), " "));
				}

				link.add(new Label("label", getString("menu." + item.getModelObject().getSimpleName())).setRenderBodyOnly(true));
				item.add(link);
			}
		});
	}

}
