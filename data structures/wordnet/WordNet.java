package wordnet;

import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;


public class WordNet {
    /* Maps each id in the synset file to the synset string. */
    private final HashMap<Integer, String> mapIdToSynset = new HashMap<>();

    /* Maps a single word to the set of ids of synsets that it appears in. */
    private final HashMap<String, Set<Integer>> mapNounToIdSet = new HashMap<>();

    private final SAP sapObject;

    private boolean[] visitedGlobal;
    private boolean[] visitedLocal;

    // constructor takes the name of the two input files
    public WordNet(String synsets, String hypernyms) {
        if (synsets == null || hypernyms == null) throw new IllegalArgumentException("Synset or hypernyms is null");

        int maxId = readSynSets(synsets);
        Digraph hyp = createDigraphFromHypernyms(hypernyms, maxId + 1);

        visitedGlobal = new boolean[hyp.V()];

        int numRoots = 0;
        for (int s = 0; s < hyp.V(); s++) {
            visitedLocal = new boolean[hyp.V()];
            if (hasCycle(hyp, s)) throw new IllegalArgumentException();

            if (hyp.outdegree(s) == 0) {
                numRoots++;
            }
        }
        if (numRoots != 1) throw new IllegalArgumentException();

        sapObject = new SAP(hyp);

    }


    private boolean hasCycle(Digraph graph, int cur) {
        if (visitedGlobal[cur]) return false;
        else if (visitedLocal[cur]) return true;
        else {
            visitedGlobal[cur] = true;
            visitedLocal[cur] = true;
            boolean cycle = false;
            for (int adj : graph.adj(cur)) {
                cycle = cycle || hasCycle(graph, adj);
            }
            return cycle;
        }
    }


    /* Reads the synset file into mapIdToSynset and mapNounToIdSet.
        Returns the last id in the file, which should be the largest number as well.
            */
    private int readSynSets(String synsets) {
        In in = new In(synsets);
        int id = 0;
        while (in.hasNextLine()) {
            String[] syns = (in.readLine()).split(",");
            id = Integer.parseInt(syns[0]);
            String[] words = syns[1].split(" ");
            for (int i = 0; i < words.length; i++) {
                Set<Integer> set = mapNounToIdSet.get(words[i]);
                if (set == null) {
                    set = new HashSet<Integer>();
                    mapNounToIdSet.put(words[i], set);
                }
                set.add(id);
            }
            mapIdToSynset.put(id, syns[1]);
        }

        return id;
    }

    /**
     * This method reads the hypernyms file and creates a new digraph that
     * represents the contents of the file.  Each line in the file adds an
     * edge to the digraph.
     */
    private Digraph createDigraphFromHypernyms(String hypernyms, int maxV) {
        In in = new In(hypernyms);
        Digraph G = new Digraph(maxV);

        while (in.hasNextLine()) {
            String[] hnyms = (in.readLine()).split(",");
            for (int i = 1; i < hnyms.length; i++) {
                G.addEdge(Integer.parseInt(hnyms[0]), Integer.parseInt(hnyms[i]));
            }
        }

        return G;
    }

    // returns all WordNet nouns
    public Iterable<String> nouns() {
        return mapNounToIdSet.keySet();
    }

    // is the word a WordNet noun?
    public boolean isNoun(String word) {
        if (word == null) throw new IllegalArgumentException();
        if (mapNounToIdSet.containsKey(word)) {
            return true;
        }
        return false;
    }

    // distance between nounA and nounB (defined below)
    public int distance(String nounA, String nounB) {
        if (!isNoun(nounA) || !isNoun(nounB)) throw new IllegalArgumentException();

        return sapObject.length(mapNounToIdSet.get(nounA), mapNounToIdSet.get(nounB));
    }

    // a synset (second field of synsets.txt) that is the common ancestor of nounA and nounB
    // in a shortest ancestral path (defined below)
    public String sap(String nounA, String nounB) {

        if (!isNoun(nounA) || !isNoun(nounB)) throw new IllegalArgumentException();

        int ancestor = sapObject.ancestor(mapNounToIdSet.get(nounA), mapNounToIdSet.get(nounB));
        return mapIdToSynset.get(ancestor);
    }

    // do unit testing of this class
    public static void main(String[] args) {
        WordNet wn = new WordNet(args[0], args[1]);

        while (!StdIn.isEmpty()) {
            String from = StdIn.readLine();
            String to = StdIn.readLine();

            System.out.println(from + " is noun: " + wn.isNoun(from));
            System.out.println(to + " is noun: " + wn.isNoun(to));
            if (wn.isNoun(from) && wn.isNoun(to)) {
                int length = wn.distance(from, to);
                String ancestor = wn.sap(from, to);
                StdOut.printf("length = %d, ancestor = %s\n", length, ancestor);
            }
        }
    }
}