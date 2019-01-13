package org.algos.ic.graph;

import java.util.List;

public interface Graph {

    void addEdge(Integer v1, Integer v2);
    List<Integer> getAdjacentVertices(int vertex);

    int getNumberOfVertices();

    int findIndegree(int vertex);

}
