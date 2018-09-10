package wordnet;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class Outcast {
    private final WordNet wordNet;

    public Outcast(WordNet wordnet)         // constructor takes a WordNet object
    {
        this.wordNet = wordnet;
    }
    public String outcast(String[] nouns)   // given an array of WordNet nouns, return an outcast
    {
        int[] distances = new int[nouns.length];
        int maxIndex = 0;

        for (int i = 0; i < nouns.length; i++) {
            for (String wNoun : nouns) {
                distances[i] += wordNet.distance(wNoun, nouns[i]);
            }
            if (distances[i] > distances[maxIndex]) {
                maxIndex = i;
            }
        }

        return nouns[maxIndex];
    }
    public static void main(String[] args) // see test client below
    {
        WordNet wordnet = new WordNet(args[0], args[1]);
        Outcast outcast = new Outcast(wordnet);
        for (int t = 2; t < args.length; t++) {
            In in = new In(args[t]);
            String[] nouns = in.readAllStrings();
            StdOut.println(args[t] + ": " + outcast.outcast(nouns));
        }
    }
}