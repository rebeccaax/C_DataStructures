package bca.util;

/**
 * Created by rebeccaxu on 3/19/18.
 */
public class BCAMappedByHashedArrayList implements BCAMap {
    protected BCAArrayList[] buckets = null;

    public BCAMappedByHashedArrayList(int numBuckets) {
        buckets = new BCAArrayList[numBuckets];

        for (int i=0; i<buckets.length; i++) {
            buckets[i] = new BCAArrayList();
        }
    }

    @Override
    public int size() {
        int size = 0;
        for (BCAArrayList list : buckets) {
            size += list.size();
        }
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean containsKey(String key) {
        return getOrDefault(key, null) != null;
    }

    @Override
    public boolean containsValue(Object value) {
        if (value == null) {
            throw new NullPointerException();
        }

        for (int i = 0; i < buckets.length; i++) {
            BCAArrayList list = buckets[i];

            for (int j = 0; j < list.size(); j++) {
                if (((BCAEntry) list.array[j]).value.equals(value)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public Object get(String key) {
        return getOrDefault(key, null);
    }

    @Override
    public Object getOrDefault(String key, Object defaultValue) {
        if (key == null) {
            throw new NullPointerException();
        }
        int bucket = Math.abs(key.hashCode()) % buckets.length;

        BCAArrayList list = buckets[bucket];

        for (int i=0; i<list.size(); i++) {
            if (((BCAEntry)list.array[i]).key.equals(key)) {
                BCAEntry e = (BCAEntry)list.array[i];
                return e.value;
            }
        }
        return defaultValue;
    }

    @Override
    public Object put(String key, Object value) {
        if ((key == null) || (value == null)) {
            throw new NullPointerException();
        }
        int bucket = Math.abs(key.hashCode()) % buckets.length;

        BCAArrayList list = buckets[bucket];
        for (int i=0; i<list.size(); i++) {
            if (((BCAEntry)list.array[i]).key.equals(key)) {
                BCAEntry e = (BCAEntry)list.array[i];
                Object o = e.value;
                e.value = value;
                return o;
            }
        }
        list.add (new BCAEntry(key, value));
        return null;
    }

    @Override
    public Object remove(String key) {
        if (key == null) {
            throw new NullPointerException();
        }
        int bucket = Math.abs(key.hashCode()) % buckets.length;

        BCAArrayList list = buckets[bucket];

        for (int i=0; i<list.size(); i++) {
            if (((BCAEntry)list.array[i]).key.equals(key)) {
                BCAEntry e = (BCAEntry)list.array[i];

                list.remove(i);
                return e.value;
            }
        }
        return null;
    }

    @Override
    public void clear() {
        for (BCAArrayList list : buckets) {
            list.clear();
        }
    }

    @Override
    public BCAEntry[] toArray() {
        BCAEntry[] array = new BCAEntry[size()];
        int pos = 0;

        for (BCAArrayList list : buckets) {
            for (int i=0; i<list.size(); i++) {
                BCAEntry e = (BCAEntry)list.get(i);
                array[pos++] = new BCAEntry(e.key, e.value);
            }
        }
        return array;
    }

    @Override
    public String[] keys() {
        String[] array = new String[size()];
        int pos = 0;

        for (BCAArrayList list : buckets) {
            for (int i=0; i<list.size(); i++) {
                BCAEntry e = (BCAEntry)list.get(i);
                array[pos++] = e.key;
            }
        }
        return array;
    }

    @Override
    public Object[] values() {
        Object[] array = new Object[size()];
        int pos = 0;

        for (BCAArrayList list : buckets) {
            for (int i=0; i<list.size(); i++) {
                BCAEntry e = (BCAEntry)list.get(i);
                array[pos++] = e.value;
            }
        }
        return array;
    }
}
