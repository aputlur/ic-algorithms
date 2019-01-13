package org.algos.ic.graph.algos;

import org.algos.ic.graph.AdjacencyMatrix;
import org.algos.ic.graph.Graph;
import org.algos.ic.graph.GraphType;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;

public class ShortestPathAlgorithm {

    public static void main(String[] args) {
        Graph graph1 = new AdjacencyMatrix(8, GraphType.DIRECTED);
        graph1.addEdge(2, 7);
        graph1.addEdge(3, 0);
        graph1.addEdge(0, 4);
        graph1.addEdge(0, 1);
        graph1.addEdge(2, 1);
        graph1.addEdge(1, 3);
        graph1.addEdge(3, 5);
        graph1.addEdge(6, 3);
        graph1.addEdge(4, 7);

        shortestPath(graph1, 6, 7);
    }

    private static void shortestPath(Graph graph, int source, int dest) {

        //build Table
        Map<Integer, DistanceInfoTable> distanceInfoTableMap = buildDistanceInfoTable(graph, source);

        //backtrack from destination using stack

        Stack<Integer> stack = new Stack<>();
        stack.push(dest);
        int previousVertex = distanceInfoTableMap.get(dest).getLastVertex();
        while(previousVertex != -1 && previousVertex != source){

            stack.push(previousVertex);
            previousVertex = distanceInfoTableMap.get(previousVertex).getLastVertex();

        }

        if(previousVertex == -1){
            System.out.println("no shortest-path found between source -> " + source + " dest -> "+ dest);
        }

        else {
            stack.push(source);
            while(!stack.isEmpty()){
                System.out.print(stack.pop() + " -> ");
            }
        }
    }

    private static Map<Integer,DistanceInfoTable> buildDistanceInfoTable(Graph graph, int source) {

        Map<Integer, DistanceInfoTable> distanceInfoTableMap = new HashMap<>();
        for(int vertex = 0; vertex < graph.getNumberOfVertices(); vertex++){

            distanceInfoTableMap.put(vertex, new DistanceInfoTable());
        }
        distanceInfoTableMap.get(source).setDistance(0);
        distanceInfoTableMap.get(source).setLastVertex(source);

        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(source);

        while(!queue.isEmpty()){

            int currentVertex = queue.pollFirst();

            for(int adjacentVertex : graph.getAdjacentVertices(currentVertex)){

                int currentDistance = distanceInfoTableMap.get(adjacentVertex).getDistance();

                if(currentDistance == -1){

                    currentDistance = distanceInfoTableMap.get(currentVertex).getDistance() + 1;
                    distanceInfoTableMap.get(adjacentVertex).setDistance(currentDistance);
                    distanceInfoTableMap.get(adjacentVertex).setLastVertex(currentVertex);

                    if(!graph.getAdjacentVertices(adjacentVertex).isEmpty()){
                        queue.add(adjacentVertex);
                    }
                }

            }

        }
        return distanceInfoTableMap;
    }

    static class DistanceInfoTable {

        private int distance;
        private int lastVertex;

        public DistanceInfoTable() {
            this.distance = -1;
            this.lastVertex = -1;
        }

        public int getDistance() {
            return distance;
        }

        public void setDistance(int distance) {
            this.distance = distance;
        }

        public int getLastVertex() {
            return lastVertex;
        }

        public void setLastVertex(int lastVertex) {
            this.lastVertex = lastVertex;
        }
    }

}
