package ca.ubc.ece.cpen221.mp2.graph;

import ca.ubc.ece.cpen221.mp2.core.Graph;
import ca.ubc.ece.cpen221.mp2.core.Vertex;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/******************************************************************************
 *  Dependencies: Graph.java Vertex.java
 *
 *  A data type that represents a Graph using Adjacency Matrices.
 *
 ******************************************************************************/

public class AdjacencyMatrixGraph implements Graph {
    // This class should implement the Graph interface

    @Override
    public void addVertex(Vertex v) {
        if(!vertexArrayList.contains(v)){
            vertexArrayList.add(v);
            for(int i=0;i<vertexArrayList.size()-adjacencyMatrixList.size();i++){
                adjacencyMatrixList.add(new ArrayList<>());
            }
            for(int i=0;i<adjacencyMatrixList.size();i++){
                int colsize=adjacencyMatrixList.get(i).size();
                for(int j=0;j<vertexArrayList.size()-colsize;j++){
                    adjacencyMatrixList.get(i).add(0);
                }
            }
        }
    }

    @Override
    public void addEdge(Vertex v1, Vertex v2) {
        if(vertexArrayList.contains(v1)&&vertexArrayList.contains(v2)){

            int row=vertexArrayList.indexOf(v1);
            int col=vertexArrayList.indexOf(v2);

            adjacencyMatrixList.get(row).set(col,1);
            adjacencyMatrixList.get(col).set(row,1);
        }
    }

    @Override
    public boolean edgeExists(Vertex v1, Vertex v2) {
        if(vertexArrayList.contains(v1)&&vertexArrayList.contains(v2)){

            int row=vertexArrayList.indexOf(v1);
            int col=vertexArrayList.indexOf(v2);

            return adjacencyMatrixList.get(row).get(col)==1;
        }
        return false;
    }

    @Override
    public List<Vertex> getNeighbors(Vertex v) {
        ArrayList<Vertex> neighborArrayList=new ArrayList<>();
        int row=vertexArrayList.indexOf(v);
        for(Vertex v1 : vertexArrayList){
            if(adjacencyMatrixList.get(row).get(vertexArrayList.indexOf(v1))==1){
                neighborArrayList.add(v1);
            }
        }
        return neighborArrayList;
    }

    @Override
    public List<Vertex> getVertices() {
        return vertexArrayList;
    }

    private void print(){
        System.out.println("Vector list: "+vertexArrayList);
        System.out.println("Matrix: ");
        for(ArrayList<Integer> l :adjacencyMatrixList ){
            System.out.println(l);
        }
        System.out.println();
    }

    private ArrayList<ArrayList<Integer>> adjacencyMatrixList;
    private ArrayList<Vertex> vertexArrayList;

    public AdjacencyMatrixGraph(){
        vertexArrayList=new ArrayList<>();
        adjacencyMatrixList=new ArrayList<>();

    }

    public static void main(String[] args){
        AdjacencyMatrixGraph adjacencyMatrixGraph=new AdjacencyMatrixGraph();
        Vertex v1=new Vertex("1","a");
        adjacencyMatrixGraph.addVertex(v1);
        adjacencyMatrixGraph.print();

        Vertex v1b=new Vertex("1","a");
        adjacencyMatrixGraph.addVertex(v1b);
        adjacencyMatrixGraph.print();

        Vertex v2=new Vertex("2","b");
        adjacencyMatrixGraph.addVertex(v2);
        adjacencyMatrixGraph.print();

        Vertex v3=new Vertex("3","b");
        adjacencyMatrixGraph.addVertex(v3);
        adjacencyMatrixGraph.print();

        Vertex v4=new Vertex("4","b");
        adjacencyMatrixGraph.addVertex(v4);
        adjacencyMatrixGraph.print();

        adjacencyMatrixGraph.addEdge(v2,v1);
        adjacencyMatrixGraph.print();

        adjacencyMatrixGraph.addEdge(v1,v3);
        adjacencyMatrixGraph.print();

        adjacencyMatrixGraph.addEdge(v3,v4);
        adjacencyMatrixGraph.print();

        adjacencyMatrixGraph.addEdge(v1,v3);
        adjacencyMatrixGraph.print();

        System.out.println(adjacencyMatrixGraph.edgeExists(v1,v2));
        System.out.println(adjacencyMatrixGraph.edgeExists(v1,v3));
        System.out.println(adjacencyMatrixGraph.edgeExists(v1,v4));
        System.out.println();

        System.out.println(adjacencyMatrixGraph.getNeighbors(v1));
        System.out.println(adjacencyMatrixGraph.getNeighbors(v2));

        System.out.println();
        System.out.println(adjacencyMatrixGraph.getVertices());

    }
}
