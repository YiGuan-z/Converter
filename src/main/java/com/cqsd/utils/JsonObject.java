package com.cqsd.utils;

import java.lang.reflect.Field;
import java.util.*;
import java.util.function.BiConsumer;

public final class JsonObject
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

    // 还差一个拼接数组类型的方法 这个方法还需要进一步拆分亦或是重载一个
    public <T> void toJSONString(String key, T obj) {
        StringBuilder sb = new StringBuilder("{");
        //获取class对象
        try {
            Class<?> clazz = obj.getClass();
            //获取所有属性
            Field[] fields = clazz.getDeclaredFields();
            //对属性进行迭代操作，如果匹配到注解就获取注解的值和被注解字段的值
//            int i = 0;
            bulidJSONString(obj, sb, fields);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e.getMessage());
        }
        map.put(key, sb);
    }

    /**
     * 这里是用于构建数组 例如<br/>
     * [{"user":"name","age":"32"},{"user":"name1","age":"11"}]
     *
     * @param key     key
     * @param objects objects
     * @param <T>     T
     */
    public <T> void toJSONString(String key, T[] objects) {
        StringBuilder sb = new StringBuilder("[");
        try {
            for (T object : objects) {
                Field[] declaredFields = object.getClass().getDeclaredFields();
//                int i = 0;
                sb.append("{");
                bulidJSONString(object, sb, declaredFields);
                sb.append(",");
            }
            sb.append("]");
            if (sb.charAt(sb.length() - 2) == ',')
                sb.deleteCharAt(sb.length() - 2);
            map.put(key, sb);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    private <T> void bulidJSONString(T obj, StringBuilder sb, Field[] fields) throws IllegalAccessException {
        int i = 0;
        for (Field field : fields) {
            field.setAccessible(true);
            JsonEntry entry = field.getAnnotation(JsonEntry.class);
            String propName = entry.value();
            Object propValue = field.get(obj);
            //System.out.printf("propName:%-2s\t propsValue:%-2s\t\n", propName, propValue);
            sb
                    .append("\"")
                    .append(propName)
                    .append("\"")
                    .append(":")
                    .append("\"")
                    .append(propValue)
                    .append("\"");
            if (i != fields.length - 1) {
                sb.append(",");
            }
            i++;
        }
        sb.append("}");
    }

    /**
     * 返回json字符串支持包装类数组，不支对象持嵌套。
     *
     * @return json
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        //json头
        sb.append("{");
        //循环map里面的内容
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            //添加 "对象名":
            sb.append("\"");
            sb.append(entry.getKey());
            sb.append("\"");
            sb.append(":");
            //如果是数组
            if (isArray(entry.getValue())) {
                //添加[" "," "," "]
                //这里是数组里的元素
                sb.append("[");
                int i = 0;
                for (Object o : (Object[]) entry.getValue()) {
                    i++;
                    sb.append("\"");
                    sb.append(o.toString());
                    sb.append("\"");
                    sb.append(",");
                    // 干掉最后一个逗号
                    if (i == ((Object[]) entry.getValue()).length) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                }
                sb.append("]");
            } else if (entry.getValue() instanceof StringBuilder) {
                sb.append(entry.getValue());
            } else if (entry.getValue() instanceof String || entry.getValue() != null) {
                sb
                        .append("\"")
                        .append(entry.getValue())
                        .append("\"");
            }
            //加逗号
            sb.append(",");
        }
        //加}
        sb.append("}");
        //干掉最后一个,
        if (sb.charAt(sb.length() - 2) == ',')
            sb.deleteCharAt(sb.length() - 2);
        return sb.toString();
    }

    boolean isArray(Object value) {
        return value.getClass().isArray();
    }

}
