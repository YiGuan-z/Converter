package com.cqsd.utils;

import java.lang.reflect.Field;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;

public class JsonObject
        extends AbstractMap<String, Object>
        implements Map<String, Object> {
    private final Map<String, Object> map;
    public JsonObject(Map<String, Object> map) {
        this.map = map;
    }

    public JsonObject() {
        this(new HashMap<>());
    }

    public Object get(String key) {
        return map.get(key);
    }

    public Object put(String key, Object value) {
        map.put(key, value);
        return value;
    }

    public void forEach(BiConsumer<? super String, ? super Object> consumer) {
        map.forEach(consumer);
    }

    public void remove(String key) {
        map.remove(key);
    }

    public void clear() {
        map.clear();
    }

    public Set<Entry<String, Object>> entrySet() {
        return map.entrySet();
    }

    public boolean containsKey(String key) {
        return map.containsKey(key);
    }

    public boolean containsValue(Object value) {
        return map.containsValue(value);
    }

    public int size() {
        return map.size();
    }

    public boolean isEmpty() {
        return map.isEmpty();
    }

    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (o instanceof Map) {
            Map<?, ?> m = (Map<?, ?>) o;
            return map.equals(m);
        }
        return false;
    }

    public int hashCode() {
        return map.hashCode();
    }

    /**
     * 返回json字符串支持包装类数组，不支对象持嵌套。
     *
     * @return json
     */
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("{");
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            sb.append("\"");
            sb.append(entry.getKey());
            sb.append("\"");
            sb.append(":");
            if (isArray(entry.getValue())) {
                sb.append("[");
                int i = 0;
                for (Object o : (Object[]) entry.getValue()) {
                    i++;
                    sb.append("\"");
                    sb.append(o.toString());
                    sb.append("\"");
                    sb.append(",");

                    if (i == ((Object[]) entry.getValue()).length) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                }
                sb.append("]");
            } else {
                sb.append("\"");
                sb.append(entry.getValue());
                sb.append("\"");
            }
            sb.append(",");
        }
        sb.append("}");
        if (sb.charAt(sb.length() - 2) == ',')
            sb.deleteCharAt(sb.length() - 2);
        return sb.toString();
    }

    boolean isArray(Object value) {
        return value.getClass().isArray();
    }

    //获取被注解的类
    int argsCount(Object value) {
        Field[] fields = value.getClass().getDeclaredFields();
        return fields.length;
    }

    //通过注解里的字段获取属性
    String getFieldName(String fileName,Object obj) {
        try {
            Field field = obj.getClass().getField(fileName);
            return (String) field.get(obj);
        } catch (IllegalAccessException | NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
    }
}
