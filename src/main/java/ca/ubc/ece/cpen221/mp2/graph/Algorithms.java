package ca.ubc.ece.cpen221.mp2.graph;

import ca.ubc.ece.cpen221.mp2.core.Graph;
import ca.ubc.ece.cpen221.mp2.core.Vertex;

import java.util.*;

public class Algorithms {

    /**
     * *********************** Algorithms ****************************
     *
     * Please see the README for this machine problem for a more detailed
     * specification of the behavior of each method that one should
     * implement.
     */

    /**
     * Get shortest distance from breadthFirstSearch method
     *
     * @param graph Graph to calculate
     * @param a one vertex
     * @param b another vertex
     * @return distance
     */
    public static int shortestDistance(Graph graph, Vertex a, Vertex b) {
        Set<List<Vertex>> listSetVertex=breadthFirstSearch(graph);
        int distance=graph.getVertices().size();
        for(List<Vertex> lv: listSetVertex){
            int aindex=lv.indexOf(a);
            int bindex=lv.indexOf(b);
            if(aindex>=0&&bindex>=0){
                distance=distance>Math.abs(aindex-bindex)?Math.abs(aindex-bindex):distance;
            }
        }
        return distance==graph.getVertices().size()?-1:distance;
    }

    /**
     * Perform a complete depth first search of the given
     * graph. Start with the search at each vertex of the
     * graph and create a list of the vertices visited.
     * Return a set where each element of the set is a list
     * of elements seen by starting a DFS at a specific
     * vertex of the graph (the number of elements in the
     * returned set should correspond to the number of graph
     * vertices).
     *
     * @param graph Graph to calculate
     * @return arrayListHashSet
     */
    public static Set<List<Vertex>> depthFirstSearch(Graph graph) {
        Set<List<Vertex>> arrayListHashSet=new HashSet<>();

        for(int i=0;i<graph.getVertices().size();i++){
            ArrayList<Vertex> visitedArrayList=new ArrayList<>();
            for(int j=0;j<graph.getVertices().size();j++){
                if(visitedArrayList.size()==0){
                    if(!visitedArrayList.contains(graph.getVertices().get(i))){
                        depthFirstSearch(graph.getVertices().get(i),visitedArrayList,graph);
                    }
                }
                else{
                    if(!visitedArrayList.contains(graph.getVertices().get(j))){
                        depthFirstSearch(graph.getVertices().get(j),visitedArrayList,graph);
                    }
                }
            }
            arrayListHashSet.add(visitedArrayList);
        }
        return arrayListHashSet; // this should be changed
    }

    /**
     * Perform a complete depth first search of the given
     * graph by Recursive implementation.
     *
     * @param v Vertex to start
     * @param visitedArrayList Vertex visited
     * @param graph Graph to calculate
     * @return arrayListHashSet
     */
    private static void depthFirstSearch(Vertex v, ArrayList<Vertex> visitedArrayList, Graph graph){
        visitedArrayList.add(v);
        Iterator<Vertex> iter=graph.getNeighbors(v).iterator();
        while (iter.hasNext()){
            Vertex v1=iter.next();
            if(!visitedArrayList.contains(v1)){
                depthFirstSearch(v1,visitedArrayList,graph);
            }
        }
        for(Vertex v1 : graph.getNeighbors(v)){
            if(!visitedArrayList.contains(v1)){
                depthFirstSearch(v1,visitedArrayList,graph);
            }
        }
    }

    /**
     * Perform a complete breadth first search of the given
     * graph. Start with the search at each vertex of the
     * graph and create a list of the vertices visited.
     * Return a set where each element of the set is a list
     * of elements seen by starting a BFS at a specific
     * vertex of the graph (the number of elements in the
     * returned set should correspond to the number of graph
     * vertices).
     *
     * @param graph Graph to calculate
     * @return arrayListHashSet
     */
    public static Set<List<Vertex>> breadthFirstSearch(Graph graph) {

        Set<List<Vertex>> arrayListHashSet=new HashSet<>();

        for(Vertex v : graph.getVertices()){
            ArrayList<Vertex> visitedArrayList=new ArrayList<>();
            Queue<Vertex> vertexQueue=new ArrayDeque<>();
            visitedArrayList.add(v);
            vertexQueue.offer(v);
            while (!vertexQueue.isEmpty()){
                for(Vertex v1:graph.getNeighbors(vertexQueue.poll())){
                    if(!visitedArrayList.contains(v1)){
                        visitedArrayList.add(v1);
                        vertexQueue.offer(v1);
                    }
                }
            }
            arrayListHashSet.add(visitedArrayList);
        }
        return arrayListHashSet; // this should be changed
    }

    /**
     *
     *
     * @param graph Graph to calculate
     * @return vertex
     */
    public static Vertex center(Graph graph) {
        // TODO: Implement this method
        Vertex vertex=null;
        int center=graph.getVertices().size()+1;
       for(int i=0;i<graph.getVertices().size();i++){
           int longpath=longestPath(i,graph);
           if(center>longpath){
               center=longpath;
               vertex=graph.getVertices().get(i);
           }
       }
        return vertex; // this should be changed
    }

    private static int longestPath(int s,Graph graph)
    {
        Queue<Integer> vertexQueue=new ArrayDeque<>();
        int[] dist=new int[graph.getVertices().size()];

        ArrayList<Integer> visitedArrayList=new ArrayList<>();

        for (int i = 0; i < graph.getVertices().size(); i++){
            if(!visitedArrayList.contains(i)){
                topologicalSortUtil(i, visitedArrayList, vertexQueue,graph);
            }
        }

        for (int i = 0; i < graph.getVertices().size(); i++)
            dist[i] = -1;
        dist[s] = 0;

        while (!vertexQueue.isEmpty())
        {
            int v=vertexQueue.poll();

            Iterator<Vertex> it = graph.getNeighbors(graph.getVertices().get(v)).iterator();
            if (dist[v] != -1)
            {
                while (it.hasNext()){
                    Vertex vertex=it.next();
                    if(dist[graph.getVertices().indexOf(vertex)]<dist[v]+1){
                        dist[graph.getVertices().indexOf(vertex)]=dist[v]+1;
                    }
                }
            }
        }

        Arrays.sort(dist);
        return dist[dist.length-1];

    }

    private static  void topologicalSortUtil(int v, ArrayList<Integer> visitedArrayList, Queue<Integer> vertexQueue,Graph graph)
    {
        visitedArrayList.add(v);

        // Recur for all the vertices adjacent to this vertex
        Iterator<Vertex> it = graph.getNeighbors(graph.getVertices().get(v)).iterator();
        while (it.hasNext())
        {
            Vertex node =it.next();
            if (!visitedArrayList.contains(graph.getVertices().indexOf(node)))
                topologicalSortUtil(graph.getVertices().indexOf(node), visitedArrayList, vertexQueue,graph);
        }
        // Push current vertex to stack which stores result
        vertexQueue.offer(v);
    }

    /**
     * The diameter of a graph is the maximum distance
     * among the distances between all pairs of vertices
     * in the graph. If it is not possible to get to
     * vertex t from vertex s then the distance between
     * those two vertices, and consequently the graph
     * diameter, is infinity. We will, however, adopt
     * a more relaxed definition where we will specify
     * the diameter as being the maximum finite distance
     * among pairs of vertices except in the case when
     * all distances are infinite (when we will treat
     * the diameter as infinite). Implement a method
     * to determine the diameter of a graph.
     *
     * @param graph Graph to calculate
     * @return List
     */
    public static int diameter(Graph graph) {
        Set<List<Vertex>> listSetVertex=breadthFirstSearch(graph);
        int distance=0;
        for(List<Vertex> lv: listSetVertex){
            for(Vertex va:lv){
                for(Vertex vb:lv){
                    if(va.equals(vb)){
                        continue;
                    }
                    int shortDistance=shortestDistance(graph, va, vb);
                    distance=distance<shortDistance?shortDistance:distance;
                }
            }

        }
        return distance; // this should be changed
    }

    public static void main(String[] args){

        AdjacencyListGraph adjacencyListGraph=new AdjacencyListGraph();

        Vertex a=new Vertex("A","a");
        Vertex b=new Vertex("B","b");
        Vertex c=new Vertex("C","c");
        Vertex d=new Vertex("D","d");
        Vertex e=new Vertex("E","e");
        Vertex f=new Vertex("F","f");
        Vertex g=new Vertex("G","g");

        adjacencyListGraph.addVertex(a);
        adjacencyListGraph.addVertex(b);
        adjacencyListGraph.addVertex(c);
        adjacencyListGraph.addVertex(d);
        adjacencyListGraph.addVertex(e);
        adjacencyListGraph.addVertex(f);
        adjacencyListGraph.addVertex(g);

        adjacencyListGraph.addEdge(a,c);
        adjacencyListGraph.addEdge(a,d);
        adjacencyListGraph.addEdge(a,f);
        adjacencyListGraph.addEdge(c,d);
        adjacencyListGraph.addEdge(c,b);
        adjacencyListGraph.addEdge(f,g);
        adjacencyListGraph.addEdge(g,e);

        adjacencyListGraph.print();

        Set<List<Vertex>> bfsAdjacencyListGraph=breadthFirstSearch(adjacencyListGraph);
        System.out.println(bfsAdjacencyListGraph);

        Set<List<Vertex>> dfsAdjacencyListGraph=depthFirstSearch(adjacencyListGraph);
        System.out.println(dfsAdjacencyListGraph);

        System.out.println(diameter(adjacencyListGraph));

        System.out.println(center(adjacencyListGraph));

    }
}
