package sk.skoly.interceptors;

import java.io.Serializable;
import java.util.Date;

import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;

import sk.skoly.model.Entita;

public class AuditInterceptor extends EmptyInterceptor {
@Override
public boolean onFlushDirty(Object entity, Serializable id, Object[] currentState, Object[] previousState, String[] propertyNames, Type[] types) {
	Entita entita = (Entita) entity;
	for (int i = 0; i < propertyNames.length; i++) {
		if (propertyNames[i] == "updated" && entita.getId() != null) {
			currentState[i] = new Date();
			return true;
		}
	}
	return false;
}
	@Override
	public boolean onSave(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
		Entita entita = (Entita) entity;
		for (int i = 0; i < propertyNames.length; i++) {
			if (propertyNames[i] == "created" && entita.getId() == null) {
				state[i] = new Date();
				return true;
			}
		}
		return false;
	}

}
