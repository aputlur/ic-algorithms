package org.algos.ic.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AdjacencyMatrix implements Graph {

    private int[][]   adjacencyMatrix;
    private int       vertices = 0;
    private GraphType graphType;

    public AdjacencyMatrix(int vertices, GraphType graphType) {
        this.vertices = vertices;
        this.graphType = graphType;
        adjacencyMatrix = new int[vertices][vertices];
    }

    public AdjacencyMatrix(int[][] adjacencyMatrix, int vertices) {
        this.adjacencyMatrix = adjacencyMatrix;
        this.vertices = vertices;

        for (int row = 0; row < vertices; row++) {

            for (int col = 0; col < vertices; col++) {

                adjacencyMatrix[row][col] = 0;
            }
        }
    }

    @Override
    public void addEdge(Integer v1, Integer v2) {

        if (v1 >= vertices || v1 <0 || v2 >= vertices || v2 <0)
            throw new IllegalArgumentException("vertices must be in a range");

        adjacencyMatrix[v1][v2] = 1;
        if (graphType == GraphType.UNDIRECTED)
            adjacencyMatrix[v2][v1] = 1;
    }

    @Override
    public List<Integer> getAdjacentVertices(int vertex) {

        if (vertex > vertices || vertex < 0)
            throw new IllegalArgumentException("vertex number is not valid");

        List<Integer> adjacentVerticesList = new ArrayList<>();

        for (int col = 0; col < vertices; col++) {
            if (adjacencyMatrix[vertex][col] == 1)
                adjacentVerticesList.add(col);
        }

        Collections.sort(adjacentVerticesList);
        return adjacentVerticesList;
    }

    @Override
    public int getNumberOfVertices() {
        return vertices;
    }

    @Override
    public int findIndegree(int vertex) {

        if (vertex < 0 || vertex >= getNumberOfVertices())
            throw new IllegalArgumentException("vertex is is in-valid");

        int indegree = 0;
        for (int i = 0; i < getNumberOfVertices(); i++) {

            if (adjacencyMatrix[i][vertex] != 0)

                indegree++;

        }
        return indegree;

    }
}
