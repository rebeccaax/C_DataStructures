package bca.util;

/**
 * Created by rebeccaxu on 3/6/18.
 */
public class BCAMapByArrayList implements BCAMap {
    protected BCAArrayList list = new BCAArrayList();
    /**
     * Returns the number of key-value mappings in this map.
     *
     * @return the number of key-value mappings in this map
     */
    @Override
    public int size() {
        return list.size();
    }

    /**
     * Returns <tt>true</tt> if this map contains no key-value mappings.
     *
     * @return <tt>true</tt> if this map contains no key-value mappings
     */
    @Override
    public boolean isEmpty() {
        if (list.size() == 0) {
            return true;
        }
        return false;
    }

    /**
     * Returns <tt>true</tt> if this map contains a mapping for the specified
     * key.
     *
     * @param key key whose presence in this map is to be tested
     * @return <tt>true</tt> if this map contains a mapping for the specified
     * key
     * @throws NullPointerException if the specified key is null.
     */
    @Override
    public boolean containsKey(String key) {
        return (getOrDefault(key, null) != null);
    }

    /**
     * Returns <tt>true</tt> if this map maps one or more keys to the specified
     * value.
     *
     * @param value value whose presence in this map is to be tested
     * @return <tt>true</tt> if this map maps one or more keys to the specified
     * value
     * @throws NullPointerException if the specified value is null.
     */
    @Override
    public boolean containsValue(Object value) {
        if (value == null) {
            throw new NullPointerException();
        }

        for(int i = 0; i < list.size(); i++) {
            if (((BCAEntry) list.array[i]).value.equals(value)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns the value to which the specified key is mapped.
     *
     * @param key the key whose associated value is to be returned
     * @return the value to which the specified key is mapped or null if the key
     * is not in the map.
     * @throws NullPointerException if the specified key is null.
     */
    @Override
    public Object get(String key) {
        return getOrDefault(key, null);
    }

    /**
     * Returns the value to which the specified key is mapped. Or the
     * defaultValue if the key is not already in the map.
     *
     * @param key          the key whose associated value is to be returned
     * @param defaultValue the value to return if the key is not in the map.
     * @return the value to which the specified key is mapped or the
     * defaultValue
     * @throws NullPointerException if the specified key is null.
     */
    @Override
    public Object getOrDefault(String key, Object defaultValue) {
        if (key == null)
            throw new NullPointerException();

        for (int i = 0; i < list.size(); i++) {
            if (((BCAEntry) list.get(i)).key.equals(key)) {
                return ((BCAEntry) list.get(i)).value;
            }
        }
        return defaultValue;
    }

    /**
     * Associates the specified value with the specified key in this map. If the
     * map previously contained a mapping for the key, the old value is replaced
     * by the specified value.
     *
     * @param key   key with which the specified value is to be associated
     * @param value value to be associated with the specified key
     * @return the previous value associated with <tt>key</tt>, or <tt>null</tt>
     * if there was no mapping for <tt>key</tt>.
     * @throws NullPointerException if the specified key or value is null.
     */
    @Override
    public Object put(String key, Object value) {
        if ((key == null) || (value == null)) {
            throw new NullPointerException();
        }

        for (int i = 0; i < list.size(); i++) {
            BCAEntry e = (BCAEntry) list.get(i);

            if (e.key.equals(key)) {
                Object o = e.value;
                e.value = value;
                return o;
            }
        }
        list.add(new BCAEntry(key, value));
        return null;
    }

    /**
     * Removes the mapping for a key from this map if it is present.
     * <p>
     * <p>
     * Returns the value to which this map previously associated the key, or
     * <tt>null</tt> if the map contained no mapping for the key.
     *
     * @param key key whose mapping is to be removed from the map
     * @return the previous value associated with <tt>key</tt>, or <tt>null</tt>
     * if there was no mapping for <tt>key</tt>.
     * @throws NullPointerException if the specified key is null.
     */
    @Override
    public Object remove(String key) {
        if (key == null) {
            throw new NullPointerException();
        }

        for (int i = 0; i < list.size(); i++) {
            if (((BCAEntry)list.get(i)).key.equals(key)) {
                return ((BCAEntry) list.remove(i)).value;
            }
        }
        return null;

    }

    /**
     * Removes all of the mappings from this map.
     */

    @Override
    public void clear() {
        list.clear();
    }

    /**
     * Returns an array containing the current key,value pairs in the map.
     */
    @Override
    public BCAEntry[] toArray() {
        BCAEntry[] array = new BCAEntry[list.size()];

        for (int i = 0; i < list.size(); i++) {
            array[i] = (BCAEntry) list.get(i);
        }
        return array;
    }

    /**
     * Returns an array containing the keys in the map.
     */
    @Override
    public String[] keys() {
        String[] key = new String[list.size()];

        for (int i = 0; i < list.size(); i++) {
            key[i] = ((BCAEntry) list.get(i)).key;
        }
        return key;
    }

    /**
     * Returns an array containing the values in the map.
     */
    @Override
    public Object[] values() {
        Object[] value = new Object[list.size()];

        for (int i = 0; i < list.size(); i++) {
            value[i] = ((BCAEntry) list.get(i)).value;
        }
        return value;
    }
}
