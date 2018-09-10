package unit5.day3;

/**
 * Created by rebeccaxu on 2/13/18.
 */
public class Autoboxing {

    public static Integer add(Integer arg1, Integer arg2) {
        return arg1 + arg2;
    }

    public static void increment(Integer a) {
        a++;
        System.out.println("a=" + a);
    }

    public static void main(String[] args) {
        Integer c = 14;
        int d = 15;
        int e = add(c, d);
        System.out.println(e);

        increment(c);
        System.out.println(c);

        /*
        Object array[] = new Object[4];
        array[0] = new Integer(4);
        array[1] = new Double(3.14);
        array[2] = new Boolean(false);
        array[3] = new Character('s');

        for (int i = 0; i < 4; i++) {
            System.out.println(array[i]);
        }
        */
    }
}
