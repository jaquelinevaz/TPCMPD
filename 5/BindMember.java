package TPC_corrigido;

import java.lang.reflect.InvocationTargetException;

public interface BindMember {


	public <T> boolean bindMember(T target, String key, Object value)throws InstantiationException, IllegalAccessException,
	IllegalArgumentException, InvocationTargetException;	
	
}
