package sk.skoly.web.components.genericform;

import java.beans.PropertyDescriptor;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;

import sk.skoly.model.Editable;
import sk.skoly.model.EditableType;

public final class FieldFactory {
	FieldFactory() {
	}

	public static <Property, MainObject> Field<Property, MainObject>[] createFieldsFor(Class<MainObject> beanClass) {
		List<Field<Property, MainObject>> fields = new ArrayList();
		for (PropertyDescriptor descriptor : PropertyUtils.getPropertyDescriptors(beanClass)) {
			Editable editable = (Editable) ObjectUtils.defaultIfNull(descriptor.getReadMethod().getAnnotation(Editable.class), descriptor.getWriteMethod()
					.getAnnotation(Editable.class));
			if (editable != null) {
				String messageKey = StringUtils.defaultIfEmpty(editable.messageKey(), beanClass.getSimpleName().toLowerCase() + "." + descriptor.getName());

				EditableType type = editable.type();
				if (type == EditableType.AUTO) {
					if (Date.class.isAssignableFrom(descriptor.getPropertyType())) {
						type = EditableType.DATE_FIELD;
					} else if (descriptor.getPropertyType().isPrimitive() || String.class.isAssignableFrom(descriptor.getPropertyType())) {
						type = EditableType.TEXT_FIELD;
					} else {
						type = EditableType.CODEBOOK_FIELD;
					}
				}
			}

			// TODO Do editable treba nazov spring beanu ktory bude
			// implementovat nejaky interface s getAll() metodou.
		}
		return null;
	}
}
