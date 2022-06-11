package com.mon.graphs.graphrepresentation;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Implementing the representation of a graph as an adjacency list
 * "A HashMap of HashSets"
 */
public class Graph {
    private final Map<Integer, Set<Integer>> adjacencyList;
//    Map<String, Set<String>>
//    Map<Node, Set<Node>>

    public Graph(){
        adjacencyList = new HashMap<>();
    }

    public void insert(int pointA, int pointB){
        // add B to A's list
        if(adjacencyList.containsKey(pointA)){
            adjacencyList.get(pointA).add(pointB);
        }else{
            Set<Integer> neighbours = new HashSet<>();
            neighbours.add(pointB);
            adjacencyList.put(pointA, neighbours);
        }

        // add A to B's list
        if(adjacencyList.containsKey(pointB)){
            adjacencyList.get(pointB).add(pointA);
        }else{
            Set<Integer> neighbours = new HashSet<>();
            neighbours.add(pointA);
            adjacencyList.put(pointB, neighbours);
        }
    }

    public Map<Integer, Set<Integer>> getGraph() {
        return adjacencyList;
    }
}
