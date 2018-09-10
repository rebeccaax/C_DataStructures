package bca.util;


/**
 * Created by rebeccaxu on 2/6/18.
 */
public class BCAArrayList implements BCAList {
    protected Object[] array = new Object[5];
    protected int listSize = 0;

    @Override
    public void add(Object o) {
        if (listSize == array.length)
            expand();

        array[listSize++] = o;
    }

    private void expand() {
        int newSize = array.length * 2;
        Object[] newArray = new Object[newSize];

        for (int i= 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
    }

    @Override
    public void add(int index, Object o) {
        if ((index > listSize) || (index < 0))
            throw new IndexOutOfBoundsException("Index of " + index + " is out of bounds.");

        if (listSize == array.length)
            expand();
/**/
        for (int i =listSize-1; i >= index; i++) {
            array[i+1] = array[i];
        }
        array[index] = 0;
        listSize++;
    }

    @Override
    public void clear() {
        array = new Object[5];
        listSize = 0;
    }

    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < listSize; i++) {
            if (array[i] == o) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object get(int index) {
        if ((index < 0 ) || index >= listSize) {
            throw new IndexOutOfBoundsException("Index of " + index + " is out of bounds.");
        }
        return array[index];
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < listSize; i++) {
            if (array[i].equals(o)) {
                return i;
            }
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
        for (int i=listSize-1; i>=0; i--) {
            if (array[i].equals(o))
                return i;
        }
        return -1;
    }

    @Override
    public Object remove(int index) {
        Object remove = array[index];

        if ((index < 0) || (index >= listSize)) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds.");
        }

        for (int i = index; i < listSize; i++) {
            array[i] = array[i+1];
        }
        listSize--;

        return remove;
    }

    @Override
    public boolean remove(Object o) {
        int pos = -1;
        for (int i = 0; i < listSize; i++) {
            if (array[i].equals(o)) {
               pos = i;
            }
        }

        if (pos == -1) {
            return false;
        }

        for (int i = pos; i < listSize; i++) {
            array[i] = array[i+1];
        }
        listSize--;
        return true;

    }

    @Override
    public int size() {
        return listSize;
    }

    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i < listSize; i++) {
            result += i + ": " + array[i] + "; ";
        }
        return result;
    }

}


