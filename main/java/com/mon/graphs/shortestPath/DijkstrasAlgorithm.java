package com.mon.graphs.shortestPath;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * You are given a network of n nodes, labeled from 1 to n. You are also given times,
 * a list of travel times as directed edges times[i] = (ui, vi, wi), where ui is the source node,
 * vi is the target node, and wi is the time it takes for a signal to travel from source to target.
 *
 * We will send a signal from a given node k. Return the minimum time it takes for all the n nodes to
 * receive the signal. If it is impossible for all the n nodes to receive the signal, return -1.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
 * Output: 2
 * Example 2:
 *
 * Input: times = [[1,2,1]], n = 2, k = 1
 * Output: 1
 * Example 3:
 *
 * Input: times = [[1,2,1]], n = 2, k = 2
 * Output: -1
 */
public class DijkstrasAlgorithm {

    public int networkDelayTime(int[][] times, int n, int k) {
        int[] edgeTo = new int[n+1];
        int[] distTo = new int[n+1];
        boolean[] visited = new boolean[n+1];

        // initialize distTo
//        for (int i=1; i<=n; i++){
//            distTo[i] = Integer.MAX_VALUE;
//        }
        Arrays.fill(distTo, Integer.MAX_VALUE);

        PriorityQueue<Point> pq = new PriorityQueue<>((p, q) -> p.distTo - q.distTo);
        distTo[k] = 0; // dist to source
        pq.add(new Point(k, 0));

        ////// Dijkstra's algorithm //////

        while(!pq.isEmpty()){
            // remove next closest point on graph
            Point p = pq.remove();
            int currPoint = p.point;

            if(!visited[currPoint]){ //  because I do not have a decreaseKey operation, there could potentially exist
                // multiple similar Points on the priority queue (but the one with the lesser distTo will always be
                // removed first). Therefore, if the point removed has already been seen then move on
                // Add all it's adj edges to the pq ONLY if this distTo is lesser
                for(int i = 0; i<times.length; i++){
                    int[] node = times[i];
                    if(node[0] == currPoint){
                        // add all points emanating from currPoint to the pq if the distTo nextPoint is lesser
                        int nextPoint = node[1];
                        int distToNextPoint = distTo[currPoint] + node[2];
                        if(!visited[nextPoint] && distToNextPoint < distTo[nextPoint]){
                            // !visited[nextPoint] checks for an undirected edge and excludes it;
                            distTo[nextPoint] = distToNextPoint;
                            // re-add the point p to the priority queue
                            Point point = new Point(nextPoint, distToNextPoint);
                            pq.add(point);
                        }
                    }
                }
                // mark this point as visited, as all it's adjvertices have been visited
                visited[currPoint] = true;
            }
        }

        int sol = 0;
        for(int i = 1; i<=n; i++){
            if(!visited[i]) return -1;
            sol = distTo[i] > sol? distTo[i] : sol;
        }
        return sol;

    }

    class Point {
        int point;
        int distTo;

        public Point(int point, int distTo){
            this.point = point;
            this.distTo = distTo;
        }
    }
}

/*
 * Complexity
 * pq.remove() => O(logE) Total number of elements that can be on the queue is equal to total Edges on the network
 * But E = N(N-1) => O(logN^2) => O(2logN) => O(logN)
 * pq.add() => O(logV**) I could potentially add a vertex multiple times if distTo keeps decreasing
 * Although there could theoretically be any number of elements on the priority queue, once the node removed has been visited we simply continue.
 * Therefore, we can only visit a node to view its adj nodes only once.
 * Therefore, E edges could be traversed and for each edge, there could be one priority queue insertion operation
 * ==> O(E.logN)
 * x
 * finding the next point => O(T) length of times[][] array
 * x
 * finding the max time => O(N)
 *
 * Final Complexity = O((E.logN x T) + N)
 * NB: by using a hash map, I can remove the T in the time complexity above
 */
