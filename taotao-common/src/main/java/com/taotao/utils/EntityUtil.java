package com.taotao.utils;

import org.apache.log4j.Logger;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EntityUtil {

    private static Logger logger = Logger.getLogger(EntityUtil.class);

    public static <K, V> Map<K, V> makeEntityMap(List<V> list, String fieldName) {
        Map<K, V> map = new HashMap<K, V>(list.size());
        if (list == null || list.size() == 0) {
            return map;
        }
        try {
            Method getter = getMethod(list.get(0).getClass(), fieldName, "get");
            for (V item : list) {
                map.put((K) getter.invoke(item), item);
            }
        } catch (Exception e) {
            logger.error("makeEntityMap error:"+list,e);
            return map;
        }
        return map;
    }

    public static Method getMethod(Class clazz, String fieldName, String methodPrefix) throws NoSuchMethodException {
        String first = fieldName.substring(0, 1);
        String getterName = methodPrefix + fieldName.replaceFirst(first, fieldName);
        return clazz.getMethod(getterName);
    }

}
