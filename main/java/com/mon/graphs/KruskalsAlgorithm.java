package com.mon.graphs;

import java.util.*;

/**
 * @link{https://leetcode.com/explore/featured/card/graph/621/algorithms-to-construct-minimum-spanning-tree/3857/}
 * You are given an array points representing integer coordinates of some points on a 2D-plane, where points[i] = [xi, yi].
 *
 * The cost of connecting two points [xi, yi] and [xj, yj] is the manhattan distance between them: |xi - xj| + |yi - yj|, where |val| denotes the absolute value of val.
 *
 * Return the minimum cost to make all points connected. All points are connected if there is exactly one simple path between any two points.
 *
 *
 *
 * Example 1:
 * Input: points = [[0,0],[2,2],[3,10],[5,2],[7,0]]
 * Output: 20
 * Explanation:
 *
 * We can connect the points as shown above to get the minimum cost of 20.
 * Notice that there is a unique path between every pair of points.
 *
 * Input: points = [[3,12],[-2,5],[-4,1]]
 * Output: 18
 *
 *
 * Constraints:
 *
 * 1 <= points.length <= 1000
 * -106 <= xi, yi <= 106
 * All pairs (xi, yi) are distinct.
 */
public class KruskalsAlgorithm {
    // build a union-find datastructure
    Map<int[], int[]> parent = new HashMap<>();

    public int minCostConnectPoints(int[][] points) {
        Queue<Edge> mst = new ArrayDeque<>();
        // create a collection of all edges
        List<Edge> edgeList = new ArrayList<>();
        for(int i=0; i<points.length; i++){
            for(int j=i+1; j<points.length; j++){
                edgeList.add(new Edge(points[i], points[j]));
            }
        }

        // sort the list of edges
        Collections.sort(edgeList);

        // implementation of union-find
        for(int i=0; i<points.length; i++){
            parent.put(points[i], points[i]);
        }

        // Kruskal's algorithm
        while(!edgeList.isEmpty() && mst.size()<points.length-1){
            Edge e = edgeList.remove(0); // remove the first element
            if(!isConnected(e.p1, e.p2)){
                mst.add(e);
                union(e.p1, e.p2);
            }
        }

        int minCost = 0;
        for(Edge e: mst){
            minCost += e.distance;
        }
        return minCost;
    }


    // implementation of union-find
    private int[] root(int[] p){
        while(parent.get(p) != p){
            p = parent.get(p);
        }
        return p;
    }

    private boolean isConnected(int[] p1, int[] p2){
        int[] parentp1 = root(p1);
        int[] parentp2 = root(p2);

        return parentp1 == parentp2;
    }

    private void union(int[] p1, int[] p2){
        int[] parentp1 = root(p1);
        int[] parentp2 = root(p2);

        parent.put(parentp1, parentp2);
    }

    class Edge implements Comparable<Edge>{
        final int[] p1, p2;
        final int distance;
        public Edge(int[] p1, int[] p2){
            this.p1 = p1;
            this.p2 = p2;
            this.distance = Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
        }

        public int compareTo(Edge other){
            return this.distance - other.distance;
        }

        public String toString(){
            return "p1: " + p1 + " p2: " + p2 + " distance: " + distance;
        }
    }

    public static void main(String[] args) {
        int[][] points = new int[][]{
                {0,0},
                {2,2},
                {3,10},
                {5,2},
                {7,0},
        };
        KruskalsAlgorithm kruskalsAlgorithm = new KruskalsAlgorithm();
        int minCost = kruskalsAlgorithm.minCostConnectPoints(points);
        System.out.println(minCost);
    }
}
