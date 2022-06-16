package com.mon.graphs;

import java.io.*;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class DepthFirstSearch {
    Map<Integer, Set<Integer>> graphMap;

    public DepthFirstSearch() {
        this.graphMap = new HashMap<>();
    }

    public void insert(int pointA, int pointB){
        if(graphMap.containsKey(pointA)){
            graphMap.get(pointA).add(pointB);
        }else{
            Set<Integer> adj = new HashSet<>();
            adj.add(pointB);
            graphMap.put(pointA, adj);
        }

        if(graphMap.containsKey(pointB)){
            graphMap.get(pointB).add(pointA);
        }else{
            Set<Integer> adj = new HashSet<>();
            adj.add(pointA);
            graphMap.put(pointB, adj);
        }
    }
    /**
     * My recursive implementation of a DFS that also implements constructing its graph
     * And it is supported by Robert Sedgewick's implementation except for the check of source == target.
     * Compare this with the isFound method below
     * */
    public boolean isReachable(int source, int target, Set<Integer> visited){
        if(source == target){
            return true;
        }
        visited.add(source); // goes into the point then marks it;this also ensures that the first source node is not
        // visited twice unlike is found below
        Set<Integer> adj = graphMap.get(source);
        for(Integer point: adj){
            if(!visited.contains(point)){
                boolean isReachable = isReachable(point, target, visited);
                if(isReachable) return true;
            }
        }
        return false;
    }

   /* public boolean isFound(Node node, int target, Set<Node> visited){
        if(node == null) return false;
        if(node.val == target) return true;

        for(Node neighbour: node.getNeighbours()){
            if(visited.contains(neighbour)) continue;
            visited.add(neighbour); // I think this skips the source node the first time, causing it to be visited again
            boolean isFound = isFound(neighbour, target, visited);
            if(isFound) return true;
        }
        return false;
    }

    class Node{
        int val;
        final Set<Node> neighbours;
        public Node(int val){
            this.val = val;
            neighbours = new HashSet<>();
        }

        public Set<Node> getNeighbours(){
            return neighbours;
        }
    }*/

    public static void main(String[] args) {
        DepthFirstSearch dfs = new DepthFirstSearch();
        //System.out.println(System.getProperty("user.dir")); /Users/my.name/Desktop/AlgoPractice
        //System.out.println(Paths.get("").toAbsolutePath().toString()); /Users/my.name/Desktop/AlgoPractice
        //System.out.println(FileSystems.getDefault().getPath("").toAbsolutePath()); /Users/my.name/Desktop/AlgoPractice
        //System.out.println(dfs.getClass().getClassLoader().getResource("").getPath()); /Users/my.name/Desktop/AlgoPractice/target/classes/

        //
        FileInputStream fileInputStream = null;
        try {
            // using intelliJ you have to state the absolute file path from the root of the folder - AlgoPractice
             fileInputStream = new FileInputStream("src/main/java/com/mon/graphs/graph.txt");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
            String line = bufferedReader.readLine();
            while(line != null){
                String[] elArr = line.split(" ");
                dfs.insert(Integer.parseInt(elArr[0]), Integer.parseInt(elArr[1]));
                line = bufferedReader.readLine();
            }

            System.out.println(dfs.isReachable(2, 8, new HashSet<>()) ? "2 and 8 are connected": "2 and 8 are not connected");
            System.out.println(dfs.isReachable(9, 9, new HashSet<>()) ? "9 and 9 are connected": "9 and 9 are not connected");
            System.out.println(dfs.isReachable(4, 25, new HashSet<>()) ? "4 and 25 are connected": "4 and 25 are not connected");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
