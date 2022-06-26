package com.mon.graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class PrimsAlgorithm {

    public int minCostConnectPoints(int[][] points) {
        // mst
        List<Edge> mst = new ArrayList<>();

        // priority queue of edges
        PriorityQueue<Edge> pq = new PriorityQueue<>();

        // Union find
        UF uf = new UF(points);

        // add all the edges from point 0 to the other points
        for(int i = 1; i<points.length; i++){
            int distance = Math.abs(points[0][0] - points[i][0]) +
                    Math.abs(points[0][1] - points[i][1]);
            pq.add(new Edge(0, i, distance));
        }

        // Prims Algorithm
        while((mst.size() < points.length - 1) && !pq.isEmpty()){

            // remove the lowest
            Edge e = pq.remove();// definitely on mst
            // System.out.println(e.distance + " p1=" + e.p1 + " p2=" + e.p2);
            if(!uf.isConnected(e.p1, e.p2)){
                mst.add(e);
                uf.union(e.p1, e.p2);
            }

            // add all the edges pointing from e.p2 to a non-tree vertex
            for(int i = 0; i<points.length; i++){
                if(!uf.isConnected(e.p2, i)){
                    int distance = Math.abs(points[e.p2][0] - points[i][0]) +
                            Math.abs(points[e.p2][1] - points[i][1]);
                    pq.add(new Edge(e.p2, i, distance));

                    // System.out.println("points");
                    // System.out.println(" p2=" + e.p2 + " i=" + i);
                }
            }
        }

        int sol = 0;
        for(Edge e: mst){
            sol += e.distance;
        }

        return sol;
    }

    public class Edge implements Comparable<Edge>{
        int p1;
        int p2;
        int distance;

        public Edge(int pointA, int pointB, int distance){
            this.p1 = pointA;
            this.p2 = pointB;
            this.distance = distance;
        }

        public int compareTo(Edge other){
            return this.distance - other.distance;
        }
    }

    public class UF{

        int[] id;
        int[] rank;

        public UF(int[][] points){
            // initialize every point to point to itself
            id = new int[points.length];
            for(int i = 0; i < points.length; i++){
                id[i] = i;
            }

            // implement rank
            rank = new int[points.length];
        }

        public int root(int p){
            while(p != id[p]){
                p = id[p];
            }
            return p;
        }

        public boolean isConnected(int p1, int p2){
            return root(p1) == root(p2);
        }

        public void union(int p1, int p2){
            int parentP1 = root(p1);
            int parentP2 = root(p2);
            if(rank[parentP1] > rank[parentP2]){
                id[parentP2] = parentP1;
            }else if(rank[parentP2] > rank[parentP1]){
                id[parentP1] = parentP2;
            }else{
                id[parentP1] = parentP2;
                rank[parentP2]++;
            }
        }
    }
}
