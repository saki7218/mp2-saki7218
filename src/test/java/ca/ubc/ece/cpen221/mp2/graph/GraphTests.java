package ca.ubc.ece.cpen221.mp2.graph;
import static org.junit.jupiter.api.Assertions.*;

import ca.ubc.ece.cpen221.mp2.core.Vertex;
import org.junit.jupiter.api.Test;

import java.util.*;

public class GraphTests {
    // possible location for tests
    @Test
    public void testAdjacencyListGraph() throws Exception {
        AdjacencyListGraph adjacencyListGraph = new AdjacencyListGraph();
        Vertex v1=new Vertex("1","a");
        Vertex v2=new Vertex("2","b");
        Vertex v3=new Vertex("3","b");
        Vertex v4=new Vertex("4","b");
        adjacencyListGraph.addVertex(v1);
        adjacencyListGraph.addVertex(v2);
        adjacencyListGraph.addVertex(v3);
        adjacencyListGraph.addVertex(v4);
        adjacencyListGraph.addEdge(v1,v2);
        adjacencyListGraph.addEdge(v1,v3);
        adjacencyListGraph.addEdge(v2,v3);
        assertEquals(4,adjacencyListGraph.getVertices().size());
        assertTrue(adjacencyListGraph.edgeExists(v1,v2));
        assertFalse(adjacencyListGraph.edgeExists(v1,v4));
        ArrayList<Vertex> neighborVertex=new ArrayList<>();
        neighborVertex.add(v2);
        neighborVertex.add(v3);
        assertEquals(neighborVertex,adjacencyListGraph.getNeighbors(v1));
        assertEquals(new ArrayList<Vertex>(),adjacencyListGraph.getNeighbors(v4));
    }

    @Test
    public void testAdjacencyMatrixGraph() throws Exception {
        AdjacencyMatrixGraph adjacencyMatrixGraph = new AdjacencyMatrixGraph();
        Vertex v1=new Vertex("1","a");
        Vertex v2=new Vertex("2","b");
        Vertex v3=new Vertex("3","b");
        Vertex v4=new Vertex("4","b");
        adjacencyMatrixGraph.addVertex(v1);
        adjacencyMatrixGraph.addVertex(v2);
        adjacencyMatrixGraph.addVertex(v3);
        adjacencyMatrixGraph.addVertex(v4);
        adjacencyMatrixGraph.addEdge(v1,v2);
        adjacencyMatrixGraph.addEdge(v1,v3);
        adjacencyMatrixGraph.addEdge(v2,v3);
        assertEquals(4,adjacencyMatrixGraph.getVertices().size());
        assertTrue(adjacencyMatrixGraph.edgeExists(v1,v2));
        assertFalse(adjacencyMatrixGraph.edgeExists(v1,v4));
        ArrayList<Vertex> neighborVertex=new ArrayList<>();
        neighborVertex.add(v2);
        neighborVertex.add(v3);
        assertEquals(neighborVertex,adjacencyMatrixGraph.getNeighbors(v1));
        assertEquals(new ArrayList<Vertex>(),adjacencyMatrixGraph.getNeighbors(v4));
    }


}
