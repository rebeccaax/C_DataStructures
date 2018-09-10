package wordnet;

import edu.princeton.cs.algs4.*;

import edu.princeton.cs.algs4.BreadthFirstDirectedPaths;
import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;


public class SAP {

    private final Digraph graph;

    public SAP(Digraph G) {
        this.graph = new Digraph(G);
    }

    public int length(int v, int w) {
        if (v < 0 || v >= graph.V()) {
            throw new java.lang.IllegalArgumentException("");
        }
        if (w < 0 || w >= graph.V()) {
            throw new java.lang.IllegalArgumentException("");
        }
        BreadthFirstDirectedPaths bfsV = new BreadthFirstDirectedPaths(graph, v);
        BreadthFirstDirectedPaths bfsW = new BreadthFirstDirectedPaths(graph, w);

        int minLen = -1;
        for (int i = 0; i < graph.V(); i++) {
            if (bfsV.hasPathTo(i) && bfsW.hasPathTo(i)) {
                int len = bfsV.distTo(i) + bfsW.distTo(i);
                if (minLen == -1 || len < minLen) {
                    minLen = len;
                }
            }
        }
        return minLen;
    }

    public int ancestor(int v, int w) {
        if (v < 0 || v >= graph.V()){
            throw new java.lang.IndexOutOfBoundsException("");
        }
        if (w < 0 || w >= graph.V()){
            throw new java.lang.IndexOutOfBoundsException("");
        }
        BreadthFirstDirectedPaths bfsV = new BreadthFirstDirectedPaths(graph, v);
        BreadthFirstDirectedPaths bfsW = new BreadthFirstDirectedPaths(graph, w);

        int minLen = Integer.MAX_VALUE;
        int ancestor = -1;
        for (int i = 0; i < graph.V(); i++) {
            if (bfsV.hasPathTo(i) && bfsW.hasPathTo(i)) {
                int len = bfsV.distTo(i) + bfsW.distTo(i);
                if (len < minLen) {
                    minLen = len;
                    ancestor = i;
                }
            }
        }
        return ancestor;
    }

    public int length(Iterable<Integer> v, Iterable<Integer> w) {
        BreadthFirstDirectedPaths bfsV = new BreadthFirstDirectedPaths(graph, v);
        BreadthFirstDirectedPaths bfsW = new BreadthFirstDirectedPaths(graph, w);

        int minLen = -1;
        for (int i = 0; i < graph.V(); i++) {
            if (bfsV.hasPathTo(i) && bfsW.hasPathTo(i)) {
                int len = bfsV.distTo(i) + bfsW.distTo(i);
                if (minLen == -1 || len < minLen) {
                    minLen = len;
                }
            }
        }
        return minLen;
    }

    public int ancestor(Iterable<Integer> v, Iterable<Integer> w){
        BreadthFirstDirectedPaths bfsV = new BreadthFirstDirectedPaths(graph, v);
        BreadthFirstDirectedPaths bfsW = new BreadthFirstDirectedPaths(graph, w);
        int minLen = Integer.MAX_VALUE;
        int ancestor = -1;
        for (int i = 0; i < graph.V(); i++) {
            if (bfsV.hasPathTo(i) && bfsW.hasPathTo(i)) {
                int len = bfsV.distTo(i) + bfsW.distTo(i);
                if (len < minLen) {
                    minLen = len;
                    ancestor = i;
                }
            }
        }
        return ancestor;
    }

    public static void main(String[] args) {
        In in = new In(args[0]);
        Digraph G = new Digraph(in);
        SAP sap = new SAP(G);
        while (!StdIn.isEmpty()) {
            int v = StdIn.readInt();
            int w = StdIn.readInt();
            int length = sap.length(v, w);
            int ancestor = sap.ancestor(v, w);
            StdOut.printf("length = %d, ancestor = %d\n", length, ancestor);
        }
    }
}