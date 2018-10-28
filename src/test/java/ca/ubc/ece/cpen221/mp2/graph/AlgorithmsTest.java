package ca.ubc.ece.cpen221.mp2.graph;

import ca.ubc.ece.cpen221.mp2.core.Vertex;
import org.junit.jupiter.api.Test;

import java.util.*;

import static ca.ubc.ece.cpen221.mp2.graph.Algorithms.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AlgorithmsTest {
    @Test
    public void testBreadthFirstSearch(){
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
        Set<List<Vertex>> bfsAdjacencyListGraph=breadthFirstSearch(adjacencyListGraph);
        Set<List<Vertex>> bfs=new HashSet<>();
        bfs.add(new ArrayList<>(Arrays.asList(f,a,g,c,d,e,b)));
        bfs.add(new ArrayList<>(Arrays.asList(a,c,d,f,b,g,e)));
        bfs.add(new ArrayList<>(Arrays.asList(e,g,f,a,c,d,b)));
        bfs.add(new ArrayList<>(Arrays.asList(b,c,a,d,f,g,e)));
        bfs.add(new ArrayList<>(Arrays.asList(d,a,c,f,b,g,e)));
        bfs.add(new ArrayList<>(Arrays.asList(g,f,e,a,c,d,b)));
        bfs.add(new ArrayList<>(Arrays.asList(c,a,d,b,f,g,e)));
        assertEquals(bfs,bfsAdjacencyListGraph);

    }

    @Test
    public void testDepthFirstSearch(){
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
        Set<List<Vertex>> dfsAdjacencyListGraph=depthFirstSearch(adjacencyListGraph);
        Set<List<Vertex>> dfs=new HashSet<>();
        dfs.add(new ArrayList<>(Arrays.asList(e,g,f,a,c,d,b)));
        dfs.add(new ArrayList<>(Arrays.asList(f,a,c,d,b,g,e)));
        dfs.add(new ArrayList<>(Arrays.asList(d,a,c,b,f,g,e)));
        dfs.add(new ArrayList<>(Arrays.asList(g,f,a,c,d,b,e)));
        dfs.add(new ArrayList<>(Arrays.asList(b,c,a,d,f,g,e)));
        dfs.add(new ArrayList<>(Arrays.asList(a,c,d,b,f,g,e)));
        dfs.add(new ArrayList<>(Arrays.asList(c,a,d,f,g,e,b)));
        assertEquals(dfs,dfsAdjacencyListGraph);
    }

    @Test
    public void testShortestDistance(){
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
        int distance=shortestDistance(adjacencyListGraph,a,b);
        assertEquals(2,distance);
        distance=shortestDistance(adjacencyListGraph,a,a);
        assertEquals(0,distance);
        distance=shortestDistance(adjacencyListGraph,a,new Vertex("H"));
        assertEquals(-1,distance);
    }

    @Test
    public void testDiameter(){
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

        assertEquals(2,diameter(adjacencyListGraph));
    }

    @Test
    public void testCenter(){
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

        assertEquals(a,center(adjacencyListGraph));
    }
}
