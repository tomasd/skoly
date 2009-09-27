package sk.skoly.web.components.listaction;

import java.beans.PropertyDescriptor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.CompareToBuilder;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.PropertyColumn;
import org.apache.wicket.model.StringResourceModel;

import sk.skoly.model.ListDisplayed;

public final class ColumnsFactory {
	ColumnsFactory() {
	}

	@SuppressWarnings("unchecked")
	public static <T> IColumn<T>[] createColumnsFor(Class<T> beanClass) {
		List<IColumn<T>> columns = new ArrayList<IColumn<T>>();

		final Map<Object, Integer> orderMap = new HashMap<Object, Integer>();
		for (PropertyDescriptor descriptor : PropertyUtils.getPropertyDescriptors(beanClass)) {
			ListDisplayed listDisplayed = descriptor.getReadMethod().getAnnotation(ListDisplayed.class);
			if (listDisplayed != null) {
				String messageKey = StringUtils
						.defaultIfEmpty(listDisplayed.messageKey(), beanClass.getSimpleName().toLowerCase() + "." + descriptor.getName());

				PropertyColumn<T> column = new PropertyColumn<T>(new StringResourceModel(messageKey, null), descriptor.getName());
				columns.add(column);
				orderMap.put(column, listDisplayed.order());
			}

		}
		Collections.sort(columns, new Comparator<Object>() {

			@Override
			public int compare(Object o1, Object o2) {
				Integer l1 = orderMap.get(o1);
				Integer l2 = orderMap.get(o2);
				return new CompareToBuilder().append(l1, l2).toComparison();
			}

		});
		return columns.toArray(new IColumn[columns.size()]);
	}
}
