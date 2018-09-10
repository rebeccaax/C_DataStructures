package unit5.wc;
import bca.util.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by rebeccaxu on 3/15/18.
 */
public class WordCount {

    public static String cleanWord (String w) {
        char[] in = w.toLowerCase().toCharArray();
        StringBuffer buf = new StringBuffer(in.length);

        for (char c: in) {
            if (Character.isAlphabetic(c))
                buf.append(c);
        }

        return buf.toString();
    }


    public static BCAArrayList parseFile() throws FileNotFoundException{
        Scanner in = new Scanner(new FileReader("data/u5/TaleOfTwoCities.txt"));
        BCAArrayList a = new BCAArrayList();

        while (in.hasNext()) {
            String w = cleanWord(in.next());

            if (w.length() > 0) {
                a.add(w);
            }
        }
        in.close();
        return a;
    }


    public static void wordCount (BCAArrayList a, BCAMap map) throws FileNotFoundException{
        System.out.println(map.getClass() + ":");

        long start = System.currentTimeMillis();

        for (int i=0; i<a.size(); i++) {
            String w = (String)a.get(i);
            Integer count = (Integer) map.getOrDefault(w, 0);
            count += 1;
            map.put(w, count);
        }

        long end = System.currentTimeMillis();

        System.out.printf("Total seconds: %.3f\n", (end-start) / 1000.0);

        BCAEntry[] array = map.toArray();
        Arrays.sort (array, new CompareBCAEntryByValue());

        for (int i = 1; i <= 3; i++) {
            BCAEntry e = array[array.length - i];
            System.out.println(e.key + ": " + e.value + " times");
        }
    }

    public static void main(String[] args) throws Exception {
            BCAArrayList a = parseFile();

       //     wordCount(a, new BCAMapBaseline());

            wordCount(a, new BCAMappedByHashedArrayList(2000));
            System.out.println();
            wordCount(a, new BCAMappedByHashedLinkedList(2000));


    }
}
