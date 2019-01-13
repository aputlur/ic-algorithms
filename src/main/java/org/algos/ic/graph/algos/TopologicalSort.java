package org.algos.ic.graph.algos;

import org.algos.ic.graph.AdjacencyMatrix;
import org.algos.ic.graph.Graph;
import org.algos.ic.graph.GraphType;

import java.util.*;

public class TopologicalSort {


    private static List<Integer> sort(Graph graph) {

        // find Indegree and add it to the Queue
        Map<Integer, Integer> integerIntegerMap = new HashMap<>();
        LinkedList<Integer> queue = new LinkedList<>();

        // iterate and find the Indegree
        for(int vertex=0; vertex< graph.getNumberOfVertices(); vertex++){

           int inDegree =  graph.findIndegree(vertex);
           if(inDegree == 0)
               queue.add(vertex);

           integerIntegerMap.put(vertex, inDegree);
        }

        List<Integer> sortedList = new ArrayList<>();
        while (!queue.isEmpty()){

            int inDegreeVertex = queue.pollLast();
            sortedList.add(inDegreeVertex);

            List<Integer> adjacentVertices = graph.getAdjacentVertices(inDegreeVertex);

            for(int adjacentVertex : adjacentVertices){
                 int updatedIndegree =   integerIntegerMap.get(adjacentVertex) - 1;
                 integerIntegerMap.remove(adjacentVertex);
                 integerIntegerMap.put(adjacentVertex, updatedIndegree);

                 if(updatedIndegree == 0)
                     queue.add(adjacentVertex);
               }
        }
        if(sortedList.size() != graph.getNumberOfVertices())
            throw new RuntimeException(" No topological Sort found..");

        return sortedList;
    }

    //helper methods



    public static void printList(List<Integer> list) {
        for (int v : list) {
            System.out.println(v + ", ");
        }
    }


    public static void main(String[] args) {
        Graph graph1 = new AdjacencyMatrix(8, GraphType.DIRECTED);
        graph1.addEdge(2, 7);
        graph1.addEdge(0, 3);
        graph1.addEdge(0, 4);
        graph1.addEdge(0, 1);
        graph1.addEdge(2, 1);
        graph1.addEdge(1, 3);
        graph1.addEdge(3, 5);
        graph1.addEdge(3, 6);
        graph1.addEdge(4, 7);

        printList(sort(graph1));
    }


}
