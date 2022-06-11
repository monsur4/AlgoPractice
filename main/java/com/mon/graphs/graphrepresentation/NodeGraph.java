package com.mon.graphs.graphrepresentation;

import java.util.*;

/**
 * NB: Untested graph node representation
 * Please see and consider using the GenericGraph representation till this class is tested
 *
 * Representation: adjacency list of nodes, where each Node<K> in the map serves as a key to a set of values of type K
 * @param <K>
 */
public class NodeGraph<K> {
    Map<Node<K>, Set<K>> adjacencyList;

    public NodeGraph() {
        this.adjacencyList = new HashMap<>();
    }

    public void insert(K pointA, K pointB){
        Node<K> nodeA = new Node<>(pointA);
        Node<K> nodeB = new Node<>(pointB);

        // add B to A's list
        // create a nodeA and add pointB to its list
        if(adjacencyList.containsKey(nodeA)){
            adjacencyList.get(nodeA).add(pointB);
        }else{
            Set<K> neighbours = new HashSet<>();
            neighbours.add(pointB);
            adjacencyList.put(nodeA, neighbours);
        }

        // add A to B's list
        // create a nodeB and add pointA to its list
        if(adjacencyList.containsKey(nodeB)){
            adjacencyList.get(nodeB).add(pointA);
        }else{
            Set<K> neighbours = new HashSet<>();
            neighbours.add(pointA);
            adjacencyList.put(nodeB, neighbours);
        }
    }

    static class Node<T>{
        T val;
        public Node(T val) {
            this.val = val;
        }
    }
}
