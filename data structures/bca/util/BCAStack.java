package bca.util;

/**
 * Created by rebeccaxu on 2/22/18.
 */
public class BCAStack {
    private BCAArrayList list = new BCAArrayList();

    public void push(Object o) {
        list.add(o);
    }

    public Object pop() {
        if (list.isEmpty()) {
            throw new StackEmptyException();
        }

        return list.remove(list.size()-1);
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public void clear() {
        list.clear();
    }

    public int size() {
        return list.size();
    }

    public Object peek() {
        if (list.isEmpty()) {
            throw new StackEmptyException();
        }

        return list.get(list.size()-1);
    }


}
