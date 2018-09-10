package bca.util;

/**
 * Created by rebeccaxu on 3/6/18.
 */
public class BCAEntry implements Comparable{
    public String key = null;
    public Object value = null;

    public BCAEntry(String key, Object value) {
        this.key = key;
        this.value = value;
    }

    public int compareTo(Object o) {
        if (o instanceof BCAEntry) {
            return key.compareTo(((BCAEntry)o).key);
        }
        else if (o instanceof String) {
            return key.compareTo((String)o);
        }
        else {
            throw new RuntimeException("Undefined");
        }
    }


    public String toString() {
        return key + ": " + value;
    }



}
