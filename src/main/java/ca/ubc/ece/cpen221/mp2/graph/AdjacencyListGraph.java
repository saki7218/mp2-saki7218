package ca.ubc.ece.cpen221.mp2.graph;

import ca.ubc.ece.cpen221.mp2.boggle.BoggleBoard;
import ca.ubc.ece.cpen221.mp2.core.Graph;
import ca.ubc.ece.cpen221.mp2.core.Vertex;

import java.util.*;

/******************************************************************************
 *  Dependencies: Graph.java Vertex.java
 *
 *  A data type that represents a Graph using Adjacency Lists.
 *
 ******************************************************************************/


public class AdjacencyListGraph implements Graph {
    // This class should implement the Graph interface
    @Override
    public void addVertex(Vertex v) {
        adjacencyMap.put(v,new ArrayList<Vertex>());
    }

    @Override
    public void addEdge(Vertex v1, Vertex v2) {
        if(adjacencyMap.containsKey(v1)&&adjacencyMap.containsKey(v2)){
            for(Map.Entry<Vertex, List<Vertex>> entry: adjacencyMap.entrySet())
            {
                if(entry.getKey().equals(v1)){
                    if(!entry.getValue().contains(v2)){
                        entry.getValue().add(v2);
                    }
                }
                if(entry.getKey().equals(v2)){
                    if(!entry.getValue().contains(v1)){
                        entry.getValue().add(v1);
                    }
                }
            }
        }
    }

    @Override
    public boolean edgeExists(Vertex v1, Vertex v2) {
        if(adjacencyMap.containsKey(v1)&&adjacencyMap.containsKey(v2)) {
            for(Map.Entry<Vertex, List<Vertex>> entry: adjacencyMap.entrySet())
            {
                if(entry.getKey().equals(v1)){
                    if(entry.getValue().contains(v2)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public List<Vertex> getNeighbors(Vertex v) {
        for(Map.Entry<Vertex, List<Vertex>> entry: adjacencyMap.entrySet())
        {
            if(entry.getKey().equals(v)){
                return entry.getValue();
            }
        }
        return new ArrayList<>();
    }

    @Override
    public List<Vertex> getVertices() {
        ArrayList<Vertex> vertexArrayList=new ArrayList<>();
        for(Map.Entry<Vertex, List<Vertex>> entry: adjacencyMap.entrySet())
        {
            vertexArrayList.add(entry.getKey());
        }
        return vertexArrayList;
    }

    private HashMap<Vertex,List<Vertex>> adjacencyMap;

    public void print(){
        for(Map.Entry<Vertex, List<Vertex>> entry: adjacencyMap.entrySet())
        {
            System.out.println("Key: "+ entry.getKey()+ " Value:"+entry.getValue());
        }
        System.out.println();
    }

    public AdjacencyListGraph(){
        adjacencyMap=new HashMap<>();
    }

    public AdjacencyListGraph(BoggleBoard boggleBoard){

        adjacencyMap=new HashMap<>();
        for (int m=0;m<boggleBoard.rows();m++){
            for(int n=0;n<boggleBoard.cols();n++){
                ArrayList<Vertex> adjList=new ArrayList<>();
                try{
                    int m1=m,n1=n-1;
                    String labelChar=String.valueOf(boggleBoard.getLetter(m1,n1));
                    String curLabel=labelChar.equals("Q")?"Qu":labelChar;
                    Vertex v=new Vertex(curLabel, String.format("%s%d%d",curLabel,m1,n1 ));
                    adjList.add(v);
                }catch (Exception e){}
                try{
                    int m1=m,n1=n+1;
                    String labelChar=String.valueOf(boggleBoard.getLetter(m1,n1));
                    String curLabel=labelChar.equals("Q")?"Qu":labelChar;
                    Vertex v=new Vertex(curLabel, String.format("%s%d%d",curLabel,m1,n1 ));
                    adjList.add(v);
                }catch (Exception e){}
                try{
                    int m1=m-1,n1=n;
                    String labelChar=String.valueOf(boggleBoard.getLetter(m1,n1));
                    String curLabel=labelChar.equals("Q")?"Qu":labelChar;
                    Vertex v=new Vertex(curLabel, String.format("%s%d%d",curLabel,m1,n1 ));
                    adjList.add(v);
                }catch (Exception e){}
                try{
                    int m1=m+1,n1=n;
                    String labelChar=String.valueOf(boggleBoard.getLetter(m1,n1));
                    String curLabel=labelChar.equals("Q")?"Qu":labelChar;
                    Vertex v=new Vertex(curLabel, String.format("%s%d%d",curLabel,m1,n1 ));
                    adjList.add(v);
                }catch (Exception e){}
                try{
                    int m1=m-1,n1=n-1;
                    String labelChar=String.valueOf(boggleBoard.getLetter(m1,n1));
                    String curLabel=labelChar.equals("Q")?"Qu":labelChar;
                    Vertex v=new Vertex(curLabel, String.format("%s%d%d",curLabel,m1,n1 ));
                    adjList.add(v);
                }catch (Exception e){}
                try{
                    int m1=m-1,n1=n+1;
                    String labelChar=String.valueOf(boggleBoard.getLetter(m1,n1));
                    String curLabel=labelChar.equals("Q")?"Qu":labelChar;
                    Vertex v=new Vertex(curLabel, String.format("%s%d%d",curLabel,m1,n1 ));
                    adjList.add(v);
                }catch (Exception e){}
                try{
                    int m1=m+1,n1=n-1;
                    String labelChar=String.valueOf(boggleBoard.getLetter(m1,n1));
                    String curLabel=labelChar.equals("Q")?"Qu":labelChar;
                    Vertex v=new Vertex(curLabel, String.format("%s%d%d",curLabel,m1,n1 ));
                    adjList.add(v);
                }catch (Exception e){}
                try{
                    int m1=m+1,n1=n+1;
                    String labelChar=String.valueOf(boggleBoard.getLetter(m1,n1));
                    String curLabel=labelChar.equals("Q")?"Qu":labelChar;
                    Vertex v=new Vertex(curLabel, String.format("%s%d%d",curLabel,m1,n1 ));
                    adjList.add(v);
                }catch (Exception e){}
                String curLabel=String.valueOf(boggleBoard.getLetter(m,n)).equals("Q")?"Qu":String.valueOf(boggleBoard.getLetter(m,n));
                Vertex currentVertex=new Vertex(curLabel, String.format("%s%d%d",curLabel,m,n ));
                adjacencyMap.put(currentVertex,adjList);
            }
        }
    }

    public static void main(String[] args){
        AdjacencyListGraph adjacencyListGraph=new AdjacencyListGraph();
        Vertex v1=new Vertex("1","a");
        adjacencyListGraph.addVertex(v1);
        adjacencyListGraph.print();

        System.out.println(adjacencyListGraph.toString());

        Vertex v1b=new Vertex("1","a");
        adjacencyListGraph.addVertex(v1b);
        adjacencyListGraph.print();

        Vertex v2=new Vertex("2","b");
        adjacencyListGraph.addVertex(v2);
        adjacencyListGraph.print();

        Vertex v3=new Vertex("3","b");
        Vertex v4=new Vertex("4","b");

        adjacencyListGraph.addEdge(v1,v2);
        adjacencyListGraph.print();

        adjacencyListGraph.addEdge(v1,v3);
        adjacencyListGraph.print();

        adjacencyListGraph.addEdge(v3,v4);
        adjacencyListGraph.print();

        adjacencyListGraph.addVertex(v3);
        adjacencyListGraph.addVertex(v4);
        adjacencyListGraph.print();

        adjacencyListGraph.addEdge(v1,v3);
        adjacencyListGraph.print();

        System.out.println(adjacencyListGraph.edgeExists(v1,v2));
        System.out.println(adjacencyListGraph.edgeExists(v1,v3));
        System.out.println(adjacencyListGraph.edgeExists(v1,v4));
        System.out.println();

        System.out.println(adjacencyListGraph.getNeighbors(v1));
        System.out.println(adjacencyListGraph.getNeighbors(v2));
        System.out.println();

        System.out.println(adjacencyListGraph.getVertices());

    }
}
