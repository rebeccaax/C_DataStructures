package bca.util;

/**
 * Created by rebeccaxu on 2/13/18.
 */
public class BCALinkedList implements BCAList {
    protected Node head = null;
    protected Node tail = null;
    protected int listSize = 0;

    @Override
    public void add(Object o) {
        Node n = new Node(o);
        if (listSize == 0) {
            head = n;
            tail = n;
        }
        else {
            tail.next = n;
            tail = n;
        }
        listSize++;
    }

    @Override
    public void add(int index, Object o) {
        Node n = new Node(o);
        Node prior = head;

        if ((index < 0) || (index > listSize)) {
            throw new IndexOutOfBoundsException("Index of " + index + " is out of bounds.");
        }

        if (index == 0) {
            n.next = head;
            head = n;
            listSize++;
        }
        else if (index == listSize) {
            add(o);
        }
        else {
            for (int i = 0 ; i < index-1; i++) {
                prior = prior.next;
            }
            n.next = prior.next;
            prior.next = n;
            listSize++;
        }
    }

    @Override
    public void clear() {
        listSize = 0;
        head = null;
        tail = null;

    }

    @Override
    public boolean contains(Object o) {
        Node n;
        n = head;
        while (n != null) {
            if (n.data.equals(o)) {
                return true;
            }
            n = n.next;
        }
        return false;
    }

    @Override
    public Object get(int index) {
        Node n;

        if ((index < 0) || (index >= listSize)) {
            throw new IndexOutOfBoundsException("Index of " + index + " is out of bounds.");
        }

        n = head;
        for (int i = 0; i < index; i++) {
            n = n.next;
        }
        return n.data;
    }

    @Override
    public int indexOf(Object o) {
        int i = 0;
        Node n;
        n = head;

        while (n != null) {
            if (n.data.equals(o)) {
                return i;
            }
            i++;
            n = n.next;
        }
        return -1;
    }

    @Override
    public boolean isEmpty() {
        if (listSize == 0){
            return true;
        }
        return false;
    }

    @Override
    public int lastIndexOf(Object o) {
        Node n;
        n = head;
        int index = -1;
        int i = 0;

        while (n != null) {
            if (n.data.equals(o)) {
                index = i;
            }
            i++;
            n = n.next;
        }
        return index;
    }

    @Override
    public Object remove(int index) {
        Node n;
        Node del;

        if ((index < 0) || (index >= listSize)) {
            throw new IndexOutOfBoundsException("Index of " + index + " is out of bounds.");
        }

        if (listSize == 1) {
            del = head;
            head = null;
            tail = null;
            listSize--;
        }

        else if (index == 0) {
            del = head;
            head = head.next;
            listSize--;
        }

        else {
            n = head;
            for (int i = 0; i < index - 1; i++) {
                n = n.next;
            }
            del = n.next;
            n.next = del.next;
            listSize--;

            if (del == tail) {
                tail = n;
            }
        }
        return del.data;
    }

    @Override
    public boolean remove(Object o) {
        Node n;
        n = head;
        int i = 0;
        while (n != null) {
            if (n.data.equals(o)) {
                remove(i);
                return true;
            }
            i++;
            n = n.next;
        }
        return false;
    }


    @Override
    public int size() {
        return listSize;
    }

    public String toString() {
        int i = 0;
        Node n = head;
        String result = "";

        while (n != null) {
            result += i + ": " + n.data + "; ";
            n = n.next;
            i++;
        }
        return result;
    }

}

class Node {
    Object data = null;
    Node next = null;

    public Node (Object o) {
        this.data = o;
    }

}

