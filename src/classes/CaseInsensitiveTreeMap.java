package classes;

import comparators.CaseInsensitiveComparator;
import types.CaseInsensitiveString;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Created by simon.calabrese on 07/04/2017.
 */
public class CaseInsensitiveTreeMap<K, V> implements Map<K, V> {
    private CITreeMap<CaseInsensitiveString<K>, V> map;
    private final Map<K, V> mapOriginal = new TreeMap<>();

    public CaseInsensitiveTreeMap() {
        map = new CITreeMap<>();
    }

    private class CITreeMap<K extends CaseInsensitiveString, V> extends TreeMap<K, V> {

        public CITreeMap() {
            super(new CaseInsensitiveComparator<K>());
        }

        public boolean containsAndIsNotnull(final K key) {
            return this.containsKey(key) && this.get(key) != null;
        }

        public <G> Object safeGetByMap(final K key, final G defaultValue) {
            return containsAndIsNotnull(key) ? get(key) : (defaultValue != null ? defaultValue : null);
        }

        public Object safeGetByMap(final K key) {
            return safeGetByMap(key, null);
        }

        public V put(K key, V value) {
            return super.put(key, value);
        }

        public Set<Map.Entry<K, V>> entrySet() {
            return super.entrySet();
        }

    }

    public V put(K key, V value) {
        return map.put(new CaseInsensitiveString<>(key), value);
    }

    public int size() {
        return map.size();
    }

    public boolean containsKey(Object key) {
        return map.containsKey(key);
    }

    public boolean containsValue(Object value) {
        return map.containsValue(value);
    }

    public V get(Object key) {
        return map.get(key);
    }

    public <G> Object safeGetByMap(final K key, final G defaultValue) {
        return map.safeGetByMap(new CaseInsensitiveString<>(key), defaultValue);
    }

    public <G> Object safeGetByMap(final K key) {
        return map.safeGetByMap(new CaseInsensitiveString<>(key), null);
    }

    public boolean containsAndIsNotnull(final K key) {
        return map.containsKey(new CaseInsensitiveString<>(key)) && map.get(new CaseInsensitiveString<>(key)) != null;
    }

    public Set<Map.Entry<K, V>> entrySet() {
        for (Map.Entry<CaseInsensitiveString<K>, V> entry : map.entrySet()) {
            mapOriginal.put(entry.getKey().getOriginalValue(), entry.getValue());
        }
        return mapOriginal.entrySet();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public V remove(Object key) {
        return map.remove(key);
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        for (Map.Entry<? extends K, ? extends V> entry : m.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public Set<K> keySet() {
        Set<K> set = new TreeSet<>();
        for (CaseInsensitiveString<K> key : map.keySet()) {
            set.add(key.getOriginalValue());
        }
        return set;
    }

    @Override
    public Collection<V> values() {
        return map.values();
    }
}
