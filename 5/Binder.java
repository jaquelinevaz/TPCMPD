package TPC_corrigido;


import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class Binder {


//	private static BinderFields binderF = new BinderFields();
//	private static BinderProps binderP = new BinderProps();
	private  AbstractBinder binder;
	
	public Binder(AbstractBinder binder){
		this.binder=binder;
		
	}
	public static Map<String, Object> getFieldsValues(Object o)throws IllegalArgumentException, IllegalAccessException {
		
		Map<String, Object> res = new HashMap<String, Object>();
		Field[] fs = o.getClass().getDeclaredFields();
		for (Field f : fs) {
			f.setAccessible(true);
			res.put(f.getName(), f.get(o));
		}
		return res;
	}

	
	public  <T> T bindTo(Class<T> klass, Map<String, Object> vals)throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
	
		return binder.bindTo(klass, vals);

	}


//	public static <T> T bindToFields(Class<T> klass, Map<String, Object> vals)throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException
//	{
//		return binderF.bindTo(klass, vals);
//	}

//	public static <T> T bindToFieldsAndProperties(Class<T> klass, Map<String, Object> vals)throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
//
//
//		// ?????????? A classe BinderPropsAndFields dava jeito que extendesse das
//				// duas classes BinderFields and BinderProps
//
//				return new BinderPropsAndFields().bindTo(klass, vals);
//
//	}


// class WrapperUtilites {
//
//	final static Map<Class<?>, Class<?>> wrappers = new HashMap<Class<?>, Class<?>>();
//
//	static {
//		wrappers.put(boolean.class, Boolean.class);
//		wrappers.put(short.class, Short.class);
//		wrappers.put(boolean.class, Boolean.class);
//		wrappers.put(int.class, Integer.class);
//
//	}
//
//	public static Class<?> toWrapper(Class<?> c) {
//		return c.isPrimitive() ? wrappers.get(c) : c;
//	}
//
//}
}

