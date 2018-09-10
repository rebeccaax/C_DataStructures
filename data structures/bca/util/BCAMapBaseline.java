package bca.util;

import java.util.HashMap;
import java.util.Map;

public class BCAMapBaseline implements BCAMap {
    protected Map m = new HashMap<String, Object>();

    @Override
    public int size() {
        return m.size();
    }

    @Override
    public boolean isEmpty() {
        return m.isEmpty();
    }

    @Override
    public boolean containsKey(String key) {
        return m.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return m.containsValue(value);
    }

    @Override
    public Object get(String key) {
        return m.get(key);
    }

    @Override
    public Object getOrDefault(String key, Object defaultValue) {
        return m.getOrDefault(key, defaultValue);
    }

    @Override
    public Object put(String key, Object value) {
        if (key == null || value == null)
            throw new NullPointerException();
        return m.put(key, value);
    }

    @Override
    public Object remove(String key) {
        return m.remove(key);
    }

    @Override
    public void clear() {
        m.clear();
    }

    @Override
    public BCAEntry[] toArray() {
        String[] keys = keys();
        Object[] values = values();
        BCAEntry[] entries = new BCAEntry[keys.length];

        for (int i=0; i<keys.length; i++) {
            entries[i] = new BCAEntry(keys[i], values[i]);
        }
        return entries;
    }

    /**
     * Returns an array containing the keys in the map.
     */
    @Override
    public String[] keys() {
        String[] array = new String[m.size()];
        m.keySet().toArray(array);
        return array;
    }

    /**
     * Returns an array containing the values in the map.
     */
    @Override
    public Object[] values() {
        return m.values().toArray();
    }
}
