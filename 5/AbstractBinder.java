package TPC_corrigido;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public abstract class  AbstractBinder implements BindMember{
	
	public <T> T bindTo(Class<T> klass, Map<String, Object> vals)throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		if (klass == null || vals == null) {
			throw new IllegalArgumentException();
		}
		T target = klass.newInstance();
		for (Map.Entry<String, Object> e : vals.entrySet()) {
			bindMember(target, e.getKey(), e.getValue());
		}
		return target;
	}

	
	public abstract <T> boolean bindMember(T target, String key, Object v) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	
	}


