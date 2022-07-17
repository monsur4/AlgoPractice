package com.mon.graphs.shortestPath;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

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
 * ========================================
 * This approach exceeded the time limit
 * Idea: go through all the edges E-1 times
 */
public class BellmanFordAlgorithmQueue1 {
    public int minimumEffortPath(int[][] heights) {
        List<Edge> edges = new ArrayList<>();

        // add all possible edges to the list of edges
        IntStream.range(0, heights.length)
                .forEach(i->{
                    int[] localHeight = heights[i];
                    IntStream.range(0, localHeight.length)
                            .forEach(j->{
                                // process top - add to list
                                if(i>0){
                                    edges.add(new Edge(i, j, i-1, j,
                                            Math.abs(heights[i][j] - heights[i-1][j])));
                                }
                                // process left
                                if(j>0){
                                    edges.add(new Edge(i, j, i, j-1,
                                            Math.abs(heights[i][j] - heights[i][j-1])));
                                }
                                // process bottom
                                if(i<heights.length-1){
                                    edges.add(new Edge(i, j, i+1, j,
                                            Math.abs(heights[i][j] - heights[i+1][j])));
                                }
                                // process right
                                if(j<heights[0].length-1){
                                    edges.add(new Edge(i, j, i, j+1,
                                            Math.abs(heights[i][j] - heights[i][j+1])));
                                }
                            });
                });

        // initialize a maxCostDP with Integer.MAX_VALUE - wait
        int[][] minCost = new int[heights.length][heights[0].length];
        for(int i=0; i<heights.length; i++){
            for(int j=0; j<heights[0].length; j++){
                minCost[i][j] = 10000000; // Integer.MAX_VALUE
            }
        }
        minCost[0][0] = 0;

        int rows = heights.length;
        int cols = heights[0].length;

        for(int i=1; i<rows*cols; i++){
            for(Edge edge: edges){
                minCost[edge.qr][edge.qc] =
                        Math.min(minCost[edge.qr][edge.qc], Math.max(minCost[edge.pr][edge.pc], edge.cost));
            }
        }

        return minCost[rows-1][cols-1];
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
    }
}
