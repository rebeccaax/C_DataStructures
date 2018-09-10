package bca.util;

import java.util.NoSuchElementException;

/**
 * Created by rebeccaxu on 3/5/18.
 */
public class BCAQueue {
    private BCALinkedList list = new BCALinkedList();

    public void enqueue (Object o) {
        list.add(o);
    }

    public Object dequeue() {
        if (list.size() == 0) {
            throw new NoSuchElementException();
        }
        return list.remove(0);
    }

    public Object peek() {
        if (list.size() == 0) {
            throw new NoSuchElementException();
        }
        return list.get(0);
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public int size() {
        return list.size();
    }

    public void clear() {
        list.clear();
    }
}
