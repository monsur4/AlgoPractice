package com.mon.graphs.graphrepresentation;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Generic implementation of a graph representation as an adjacency list
 * "A HashMap of HashSets"
 */
public class GenericGraph<T> {
    private final Map<T, Set<T>> adjacencyList;

    public GenericGraph(){
        adjacencyList = new HashMap<>();
    }

    public void insert(T pointA, T pointB){
        // add B to A's list
        if(adjacencyList.containsKey(pointA)){
            adjacencyList.get(pointA).add(pointB);
        }else{
            Set<T> neighbours = new HashSet<>();
            neighbours.add(pointB);
            adjacencyList.put(pointA, neighbours);
        }

        // add A to B's list
        if(adjacencyList.containsKey(pointB)){
            adjacencyList.get(pointB).add(pointA);
        }else{
            Set<T> neighbours = new HashSet<>();
            neighbours.add(pointA);
            adjacencyList.put(pointB, neighbours);
        }
    }

    public Map<T, Set<T>> getGraph() {
        return adjacencyList;
    }
}
