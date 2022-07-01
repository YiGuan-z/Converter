package com.cqsd.utils;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.*;
import java.util.function.BiConsumer;

public class LinkedList<K, V>
        extends AbstractMap<K, V> implements Map<K, V> {

    /*--------------------Static Class--------------------*/
    static class Node<K, V>
            implements Map.Entry<K, V> {
        final int hash;
        final K key;
        V value;
        Node<K, V> next;
        Node<K, V> prev;

        public Node(int hash, K key, V value, Node<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public Node(int hash, K key, V value, Node<K, V> next, Node<K, V> prev) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
            this.prev = prev;
        }

        public final K getKey() {
            return key;
        }

        public final V getValue() {
            return value;
        }

        public final String toString() {
            return key + "=" + value;
        }

        public final int hashCode() {
            return Objects.hashCode(key) ^ Objects.hashCode(value);
        }

        public final V setValue(V newValue) {
            V oldValue = this.value;
            this.value = newValue;
            return oldValue;
        }

        public final boolean equals(Object o) {
            if (o == this)
                return true;
            if (o instanceof Map.Entry) {
                Map.Entry<?, ?> e = (Map.Entry<?, ?>) o;
                if (Objects.equals(key, e.getKey()) &&
                        Objects.equals(value, e.getValue()))
                    return true;
            }
            return false;
        }


    }

    Node<K, V> newNode(int hash, K key, V value, Node<K, V> next) {
        return new Node<>(hash, key, value, next);
    }

    Node<K, V> newNode(int hash, K key, V value, Node<K, V> next, Node<K, V> prev) {
        return new Node<>(hash, key, value, next, prev);
    }


    Node<K, V> replacementNode(Node<K, V> p, Node<K, V> next) {
        return new Node<>(p.hash, p.key, p.value, next);
    }
    /*------------------------Class------------------------*/
//    final class ValueIterator extends HashIterator
//    final class Values extends AbstractCollection<V>{
//       public final int size(){return size;}
//        public final void clear(){
//           table=null;
//           size=0;
//        }
//        public final Iterator<V> iterator(){
//           return new
//        }
//    }

    /*--------------------Abstract Class------------------------*/

    /*--------------------Static utilities--------------------*/
    final static int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) | (h ^ (h >>> 16));
    }

    static Class<?> comparableClassFor(Object x) {
        if (x instanceof Comparable) {
            Class<?> c;
            Type[] ts, as;
            ParameterizedType ptype;
            if ((c = x.getClass()) == String.class)
                return c;
            if ((ts = c.getGenericInterfaces()) != null) {
                for (Type t : ts) {
                    if ((ptype = (ParameterizedType) t) != null &&
                            ptype.getRawType() == Comparable.class &&
                            (as = ptype.getActualTypeArguments()) != null &&
                            as.length == 1 && as[0] == c)
                        return c;
                }
            }
        }
        return null;
    }

    /*------------------------Fields------------------------*/
    transient Node<K, V> table;
    transient Node<K, V> tail;
    transient int size;
    transient Set<K> keySet;
    transient Collection<V> values;
    transient Set<Entry<K, V>> entrySet;
    /*------------------------Constructor------------------------*/

    public LinkedList() {
        this.table = new Node<>(0, null, null, null);
        this.keySet = new HashSet<>();
        this.values = new ArrayList<>();
    }

    /* ---------------- Public operations -------------- */
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean containsKey(Object key) {
        return getNode(key) != null;
    }

    public boolean containsValue(Object value) {
        if (value != null) {
            for (Node<K, V> n = table.next; n != null; n = n.next) {
                if (value.equals(n.value))
                    return true;
            }
        }
        return false;
    }

    public V get(Object key) {
        Node<K, V> e;
        return (e = getNode(key)) == null ? null : e.value;
    }

    final Node<K, V> getNode(Object key) {
        Node<K, V> e = table.next;
        while (e != null) {
            if (e.key.equals(key))
                return e;
            e = e.next;
        }
        return null;
    }

    public V put(K key, V value) {
        return putVal(hash(key), key, value);
    }

    final V putVal(int hash, K key, V value) {
        Node<K, V> e = getNode(key);
        if (e == null) {
            e = newNode(hash, key, value, table.next);
            keySet.add(key);
            values.add(value);
            table.next = e;
            e.prev = table;
            size++;
            return null;
        } else {
            V oldValue = e.value;
            e.value = value;
            return oldValue;
        }
    }

    /**
     * 发现Bug，为5和为2的都不能删除
     * bug 已修复，原因是习惯性跳到下一个节点去了
     *
     * @param key key whose mapping is to be removed from the map
     */
    public V remove(Object key) {
        Node<K, V> e = table.next;
        V oldValue = null;
        while (e != null) {
            if (e.hash == hash(key)) {
                oldValue = e.next.value;
                e.next = e.next.next;
                keySet.remove(e.key);
                values.remove(e.value);
                size--;
            }
            e = e.next;
        }
        return oldValue;
    }


    public void putAll(Map<? extends K, ? extends V> m) {
        this.table = null;
        this.table = new Node<>(0, null, null, null);
        for (Map.Entry<? extends K, ? extends V> e : m.entrySet())
            putVal(hash(e.getKey()), e.getKey(), e.getValue());

    }

    public void clear() {
        table.next = null;
        size = 0;
    }

    public Set<K> keySet() {
        Set<K> ks = keySet;
        if (ks == null) {
            ks = new HashSet<>();
            keySet = ks;
        }
        return ks;
    }

    public Collection<V> values() {
        Collection<V> vs = values;
        if (vs == null) {
            vs = new ArrayList<>();
            values = vs;
        }
        return vs;
    }

    public Set<Entry<K, V>> entrySet() {
        Set<Entry<K, V>> es = entrySet;
        if (es == null) {
            es = new HashSet<>();
            entrySet = es;
        }
        return es;
    }

    public void forEach(BiConsumer<? super K, ? super V> action) {
        Node<K, V> e = table.next;
        while (e != null) {
            action.accept(e.key, e.value);
            e = e.next;
        }
    }

    public V replace(K key, V value) {
        Node<K, V> e = getNode(key);
        if (e == null)
            return null;
        V oldValue = e.value;
        e.value = value;
        return oldValue;
    }
}
