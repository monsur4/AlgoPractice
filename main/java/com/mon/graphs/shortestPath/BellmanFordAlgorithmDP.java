package com.mon.graphs.shortestPath;

import java.util.*;
import java.util.stream.IntStream;

/**
 * Problem Statement:
 * There are n cities connected by some number of flights. You are given an array flights where
 * flights[i] = [fromi, toi, pricei] indicates that there is a flight from city fromi to city toi with cost pricei.
 * <p>
 * You are also given three integers src, dst, and k, return the cheapest price from src to dst with at most k stops.
 * If there is no such route, return -1
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: n = 4, flights = [[0,1,100],[1,2,100],[2,0,100],[1,3,600],[2,3,200]], src = 0, dst = 3, k = 1
 * Output: 700
 * <p>
 * Explanation:
 * <p>The graph is shown above.</p>
 * <p>The optimal path with at most 1 stop from city 0 to 3 is marked in red and has cost 100 + 600 = 700.</p>
 * <p>Note that the path through cities [0,1,2,3] is cheaper but is invalid because it uses 2 stops.</p>
 * </p>
 * <p>
 * /////////////////////////////////////////////////////////////////////////////////////////////
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: n = 3, flights = [[0,1,100],[1,2,100],[0,2,500]], src = 0, dst = 2, k = 1
 * Output: 200
 * <p>
 * Explanation:
 * <p>The graph is shown above.</p>
 * <p>The optimal path with at most 1 stop from city 0 to 2 is marked in red and has cost 100 + 100 = 200.</p>
 * </p>
 * <p>
 * </p>
 * /////////////////////////////////////////////////////////////////////////////////////////////
 * <p>
 * Example 3:
 * <p>
 * <p>
 * Input: n = 3, flights = [[0,1,100],[1,2,100],[0,2,500]], src = 0, dst = 2, k = 0
 * Output: 500
 * <p>
 * Explanation:
 * <p>The graph is shown above.</p>
 * <p>The optimal path with no stops from city 0 to 2 is marked in red and has cost 500.</p>
 * </p>
 * <p>
 * </p>
 * /////////////////////////////////////////////////////////////////////////////////////////////
 * Constraints:
 * <p>
 * <p>1 <= n <= 100</p>
 * <p>0 <= flights.length <= (n * (n - 1) / 2)</p>
 * <p>flights[i].length == 3</p>
 * <p>0 <= fromi, toi < n</p>
 * <p>fromi != toi</p>
 * <p>1 <= pricei <= 104</p>
 * <p>There will not be any multiple flights between two cities.</p>
 * <p>0 <= src, dst, k < n</p>
 * <p>src != dst</p>
 *
 * @link{https://leetcode.com/explore/featured/card/graph/622/single-source-shortest-path-algorithm/3866/}
 */
public class BellmanFordAlgorithmDP {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<int[]>> edgesIntoAdjList = new HashMap<>();
        IntStream.range(0, n).forEach(i -> edgesIntoAdjList.put(i, new ArrayList<>()));
        for (int[] flight : flights) {
            int srcFlight = flight[0];
            int destFlight = flight[1];
            int costFlight = flight[2];

            edgesIntoAdjList.get(destFlight).add(new int[]{srcFlight, costFlight});
        }

        int maxEdgesToUse = k + 1;

        double[][] bellmanFordDp = new double[maxEdgesToUse + 1][n];
        Arrays.fill(bellmanFordDp[0], Double.POSITIVE_INFINITY);

        bellmanFordDp[0][src] = 0;

        // i=1 => no stop, i.e a direct flight
        for (int i = 1; i <= maxEdgesToUse; i++) {
            for (int j = 0; j < n; j++) {
                bellmanFordDp[i][j] = bellmanFordDp[i - 1][j];
                // for all the edges(k) entering into j
                for (int[] u : edgesIntoAdjList.get(j)) {
                    // if([cost of getting to u using i-1 edges + cost from k to j] is < current cost of reaching j
                    int e = u[0];
                    if (bellmanFordDp[i - 1][e] + u[1] < bellmanFordDp[i][j]) {
                        bellmanFordDp[i][j] = bellmanFordDp[i - 1][e] + u[1];
                    }
                }
            }
        }
        return (int) bellmanFordDp[maxEdgesToUse][dst];

    }
}
