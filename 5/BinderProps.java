package TPC_corrigido;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BinderProps extends AbstractBinder {


	@Override
	public	<T> boolean bindMember(T target, String key, Object v) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {

		Method[] ms = target.getClass().getMethods();

		for (Method m : ms) {
			String mName = m.getName();
			if (!mName.equalsIgnoreCase("set" + key)) {
				continue;
			}
			Class<?>[] paramsKlasses = m.getParameterTypes();
			if (paramsKlasses.length != 1) {
				continue;
			}
			Class<?> propType = WrapperUtilites.toWrapper(paramsKlasses[0]);
			if (propType.isAssignableFrom(v.getClass())) {
				m.setAccessible(true);
				m.invoke(target, v);
				return true;
			}
		}
		return false;
	}

}
