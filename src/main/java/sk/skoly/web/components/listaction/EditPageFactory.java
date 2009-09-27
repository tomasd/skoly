/**
 * 
 */
package sk.skoly.web.components.listaction;

import java.io.Serializable;

import org.apache.wicket.PageParameters;
import org.apache.wicket.markup.html.WebPage;

public interface EditPageFactory<T> extends Serializable {
	Class<? extends WebPage> getPageClass();
	
	Class<T> getType();

	PageParameters createPageParameters(T object);
}