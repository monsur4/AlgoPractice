package com.mon.graphs.shortestPath;

import java.util.LinkedList;
import java.util.Queue;

/**
 * You are a hiker preparing for an upcoming hike. You are given heights, a 2D array of size rows x columns,
 * where heights[row][col] represents the height of cell (row, col). You are situated in the top-left cell,
 * (0, 0), and you hope to travel to the bottom-right cell, (rows-1, columns-1) (i.e., 0-indexed).
 * You can move up, down, left, or right, and you wish to find a route that requires the minimum effort.
 *
 * A route's effort is the maximum absolute difference in heights between two consecutive cells of the route.
 *
 * Return the minimum effort required to travel from the top-left cell to the bottom-right cell.
 *
 *
 *
 * Example 1:
 *
 *
 *
 * Input: heights = [[1,2,2],[3,8,2],[5,3,5]]
 * Output: 2
 * Explanation: The route of [1,3,5,3,5] has a maximum absolute difference of 2 in consecutive cells.
 * This is better than the route of [1,2,2,2,5], where the maximum absolute difference is 3.
 * Example 2:
 *
 *
 *
 * Input: heights = [[1,2,3],[3,8,4],[5,3,5]]
 * Output: 1
 * Explanation: The route of [1,2,3,4,5] has a maximum absolute difference of 1 in consecutive cells,
 * which is better than route [1,3,5,3,5].
 * Example 3:
 *
 *
 * Input: heights = [[1,2,1,1,1],[1,2,1,2,1],[1,2,1,2,1],[1,2,1,2,1],[1,1,1,2,1]]
 * Output: 0
 * Explanation: This route does not require any effort.
 *
 *
 * Constraints:
 *
 * rows == heights.length
 * columns == heights[i].length
 * 1 <= rows, columns <= 100
 * 1 <= heights[i][j] <= 106
 *
 * ======================================
 * This approach exceeded the time limit
 * Idea: maintain a queue of edges that change and iterate through
 * Problem: I think the queue implementation blows  up, needs a review => BellmanFordAlgorithmQueue4
 */
public class BellmanFordAlgorithmQueue3 {

    public int minimumEffortPath(int[][] heights) {
        // initialize a minCost arr with a significantly high value
        int[][] minCost = new int[heights.length][heights[0].length];
        for(int i=0; i<heights.length; i++){
            for(int j=0; j<heights[0].length; j++){
                minCost[i][j] = 10000000;
            }
        }
        minCost[0][0] = 0;

        Queue<Edge> queue = new LinkedList<>();
        // from point(0,0)
        // add first edge -> right
        if(heights[0].length>1){
            queue.add(new Edge(0, 0, 0, 1, Math.abs(heights[0][0] - heights[0][1])));
        }
        // add second edge -> bottom
        if(heights.length>1){
            queue.add(new Edge(0, 0, 1, 0, Math.abs(heights[0][0] - heights[1][0])));
        }

        int rows = heights.length;
        int cols = heights[0].length;

        while(!queue.isEmpty()){
            Edge edge = queue.remove();
            if(Math.max(minCost[edge.pr][edge.pc], edge.cost) < minCost[edge.qr][edge.qc]){
                minCost[edge.qr][edge.qc] = Math.max(minCost[edge.pr][edge.pc], edge.cost);
                // add all edges from here
                addEdges(edge.qr, edge.qc, heights, queue);
            }
        }

        return minCost[rows-1][cols-1];
    }

    private void addEdges(int i, int j, int[][] heights, Queue<Edge> q){
        // process top - add to list
        if(i>0){
            Edge e = new Edge(i, j, i-1, j,
                    Math.abs(heights[i][j] - heights[i-1][j]));
            if(!q.contains(e)){
                q.add(e);
            }

        }
        // process left
        if(j>0){
            Edge e = new Edge(i, j, i, j-1,
                    Math.abs(heights[i][j] - heights[i][j-1]));
            if(!q.contains(e)){
                q.add(e);
            }
        }
        // process bottom
        if(i<heights.length-1){
            Edge e = new Edge(i, j, i+1, j,
                    Math.abs(heights[i][j] - heights[i+1][j]));
            if(!q.contains(e)){
                q.add(e);
            }
        }
        // process right
        if(j<heights[0].length-1){
            Edge e = new Edge(i, j, i, j+1,
                    Math.abs(heights[i][j] - heights[i][j+1]));
            if(!q.contains(e)){
                q.add(e);
            }
        }
    }

    class Edge{
        int pr;
        int pc;
        int qr;
        int qc;
        int cost;

        public Edge(int pr, int pc, int qr, int qc, int cost){
            this.pr = pr;
            this.pc = pc;
            this.qr = qr;
            this.qc = qc;
            this.cost = cost;
        }

        @Override
        public boolean equals(Object obj) {
            Edge edge = (Edge) obj;
            return this.pr == ((Edge) obj).pr
                    && this.pc == ((Edge) obj).pc
                    && this.qr == ((Edge) obj).qr
                    && this.qc == ((Edge) obj).qc;
        }
    }
}