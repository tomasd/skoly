package sk.skoly.web.components.listaction;

import java.beans.PropertyDescriptor;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.PropertyColumn;
import org.apache.wicket.model.StringResourceModel;

import sk.skoly.model.ListDisplayed;

public final class ColumnsFactory {
	ColumnsFactory() {
	}

	@SuppressWarnings("unchecked")
	public  static <T> IColumn<T>[]  createColumnsFor(Class<T> beanClass) {
		List<IColumn<T>> columns = new ArrayList<IColumn<T>>();

		for (PropertyDescriptor descriptor : PropertyUtils.getPropertyDescriptors(beanClass)) {
			ListDisplayed listDisplayed = descriptor.getReadMethod().getAnnotation(ListDisplayed.class);
			if (listDisplayed != null) {
				String messageKey = StringUtils.defaultIfEmpty(listDisplayed.messageKey(), beanClass.getSimpleName().toLowerCase() + "." + descriptor.getName());

				PropertyColumn<T> column = new PropertyColumn<T>(new StringResourceModel(messageKey, null), descriptor.getName());
				columns.add(column);
			}

		}
		return columns.toArray(new IColumn[columns.size()]);
	}
}
