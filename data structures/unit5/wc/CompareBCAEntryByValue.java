package unit5.wc;

import bca.util.BCAEntry;

import java.util.Comparator;

/**
 * Created by rebeccaxu on 3/15/18.
 */
public class CompareBCAEntryByValue implements Comparator <BCAEntry>{
    public int compare(BCAEntry o1, BCAEntry o2) {
        return ((Comparable)o1.value).compareTo(o2.value);
    }

}
