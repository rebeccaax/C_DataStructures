package bca.util;

/**
 * Created by rebeccaxu on 4/9/18.
 */
public class BCAMappedByHashedLinkedList implements BCAMap {
    protected BCALinkedList[] buckets = null;

    public BCAMappedByHashedLinkedList(int numBuckets) {
        buckets = new BCALinkedList[numBuckets];

        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new BCALinkedList();
        }
    }


    public int size() {
        int size = 0;
        for (BCALinkedList list : buckets) {
            size += list.size();
        }
        return size;
    }


    public boolean isEmpty() {
        return size() == 0;
    }


    public boolean containsKey(String key) {
        return getOrDefault(key, null) != null;
    }


    public boolean containsValue(Object value) {
        if (value == null) {
            throw new NullPointerException();
        }

        for (int i = 0; i < buckets.length; i++) {
            BCALinkedList list = buckets[i];

            for (int j = 0; j < list.size(); j++) {
                if (((BCAEntry) list.get(j)).value.equals(value)) {
                    return true;
                }
            }
        }
        return false;
    }


    public Object get(String key) {
        return getOrDefault(key, null);
    }


    public Object getOrDefault(String key, Object defaultValue) {
        if (key == null) {
            throw new NullPointerException();
        }
        int bucket = Math.abs(key.hashCode()) % buckets.length;

        BCALinkedList list = buckets[bucket];
        for (int i = 0; i < list.size(); i++) {
            if (((BCAEntry) list.get(i)).key.equals(key)) {
                BCAEntry e = (BCAEntry) list.get(i);
                return e.value;
            }
        }
        return defaultValue;
    }


    public Object put(String key, Object value) {
        if ((key == null) || (value == null)) {
            throw new NullPointerException();
        }
        int bucket = Math.abs(key.hashCode()) % buckets.length;

        BCALinkedList list = buckets[bucket];
        for (int i = 0; i < list.size(); i++) {
            if (((BCAEntry) list.get(i)).key.equals(key)){
                BCAEntry e = (BCAEntry) list.get(i);
                Object o = e.value;
                e.value = value;
                return o;
            }
        }
        list.add(new BCAEntry(key, value));
        return null;
    }


    public Object remove(String key) {
        if (key == null) {
            throw new NullPointerException();
        }
        int bucket = Math.abs(key.hashCode()) % buckets.length;

        BCALinkedList list = buckets[bucket];
        for (int i = 0; i < list.size(); i++) {
            if (((BCAEntry) list.get(i)).key.equals(key)) {
                BCAEntry e = (BCAEntry) list.get(i);
                list.remove(i);
                return e.value;
            }
        }
        return null;
    }


    public void clear() {
        int clear = 0;
        for (BCALinkedList list : buckets) {
            list.clear();
        }
    }


    public BCAEntry[] toArray() {
        BCAEntry[] array = new BCAEntry[size()];
        int pos = 0;
        for (BCALinkedList list : buckets) {
            for (int i = 0; i < list.size(); i++) {
                BCAEntry e = (BCAEntry) list.get(i);
                array[pos++] = new BCAEntry(e.key, e.value);
            }
        }
        return array;
    }

    public String[] keys() {
        String[] array = new String[size()];
        int pos = 0;
        for (BCALinkedList list : buckets) {
            for (int i = 0; i < list.size(); i++) {
                BCAEntry e = (BCAEntry) list.get(i);
                array[pos++] = e.key;
            }
        }
        return array;

    }


    public Object[] values() {
        Object[] array = new Object[size()];
        int pos = 0;
        for (BCALinkedList list : buckets) {
            for (int i = 0; i < list.size(); i++) {
                BCAEntry e = (BCAEntry) list.get(i);
                array[pos++] = e.value;
            }
        }
        return array;
    }
}
