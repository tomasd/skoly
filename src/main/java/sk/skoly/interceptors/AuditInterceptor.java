package sk.skoly.interceptors;

import java.io.Serializable;
import java.util.Date;

import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;

public class AuditInterceptor extends EmptyInterceptor {
	@Override
	public boolean onFlushDirty(Object entity, Serializable id, Object[] currentState, Object[] previousState, String[] propertyNames, Type[] types) {
		for (int i = 0; i < propertyNames.length; i++) {
			if (propertyNames[i] == "updated") {
				currentState[i] = new Date();
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean onSave(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
		boolean changed = false;
		for (int i = 0; i < propertyNames.length; i++) {
			if (propertyNames[i] == "created") {
				state[i] = new Date();
				return true;
			}
			if (propertyNames[i] == "updated") {
				state[i] = new Date();
			}
		}
		return changed;
	}

}
