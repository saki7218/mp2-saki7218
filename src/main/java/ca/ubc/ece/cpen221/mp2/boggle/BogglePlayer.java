package ca.ubc.ece.cpen221.mp2.boggle;

import ca.ubc.ece.cpen221.mp2.core.Vertex;
import ca.ubc.ece.cpen221.mp2.graph.AdjacencyListGraph;
import ca.ubc.ece.cpen221.mp2.graph.Algorithms;
import ca.ubc.ece.cpen221.utils.In;

import java.io.File;
import java.util.List;
import java.util.TreeSet;
import java.util.Set;

public class BogglePlayer {

    // Some empty methods provided to ensure that the
    // build succeeds. You should implement these methods
    // and the others that are required.
    private String[] dictionary;

    public BogglePlayer(String[] dictionary) {
        this.dictionary=dictionary;
    }

    public Set<String> getAllValidWords(BoggleBoard board) {
        Set<String> validWords=new TreeSet<>();
        AdjacencyListGraph adjacencyListGraph=new AdjacencyListGraph(board);
        Set<List<Vertex>> allWords= Algorithms.breadthFirstSearch(adjacencyListGraph);

        for(List<Vertex> lv:allWords){
            StringBuilder wordsbuild=new StringBuilder();
            for(Vertex v:lv){
                wordsbuild.append(v.toString());
            }
            String words=wordsbuild.toString();
            for(int i=0;i<dictionary.length;i++){
                if(words.contains(dictionary[i])){
                    validWords.add(dictionary[i]);
                }
            }
        }
        return validWords;
    }

    public static void main(String[] args){
        In in = new In(new File("datasets/dictionary-yawl.txt"));
        String[] dictionary = in.readAllStrings();
        System.out.println(dictionary.length);

        // create the Boggle solver with the given dictionary
        BogglePlayer solver = new BogglePlayer(dictionary);
        char[][] b={{'T','R','N','J'},{'X','P','H','W'},{'S','Y','U','A'},{'C','L','N','F'}};
        BoggleBoard board = new BoggleBoard(b);
        Iterable<String> words = solver.getAllValidWords(board);
        System.out.println(words);
    }

}
