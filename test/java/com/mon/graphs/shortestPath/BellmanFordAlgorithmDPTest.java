package com.mon.graphs.shortestPath;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BellmanFordAlgorithmDPTest {

    @Test
    void findCheapestPriceTest() {
        // given
        // test 1
        int n1 = 3;
        int[][] flights1 = new int[][]{{0, 1, 2}, {1, 2, 1}, {2, 0, 10}};
        int src1 = 1;
        int dst1 = 2;
        int k1 = 1;
        // output = 1

        // test 2
        int n2 = 3;
        int[][] flights2 = new int[][]{{0, 1, 100}, {1, 2, 100}, {0, 2, 500}};
        int src2 = 0;
        int dst2 = 2;
        int k2 = 1;
        // output = 200

        // test 3
        int n3 = 3;
        int[][] flights3 = new int[][]{{0, 1, 100}, {1, 2, 100}, {0, 2, 500}};
        int src3 = 0;
        int dst3 = 2;
        int k3 = 0;
        // output = 500

        // test 4
        int n4 = 4;
        int[][] flights4 = new int[][]{{0, 1, 100}, {1, 2, 100}, {2, 0, 100}, {1, 3, 600}, {2, 3, 200}};
        int src4 = 0;
        int dst4 = 3;
        int k4 = 1;
        // output = 700


        // when
        BellmanFordAlgorithmDP bellmanFordAlgorithmDP = new BellmanFordAlgorithmDP();
        int sol1 = bellmanFordAlgorithmDP.findCheapestPrice(n1, flights1, src1, dst1, k1);
        int sol2 = bellmanFordAlgorithmDP.findCheapestPrice(n2, flights2, src2, dst2, k2);
        int sol3 = bellmanFordAlgorithmDP.findCheapestPrice(n3, flights3, src3, dst3, k3);
        int sol4 = bellmanFordAlgorithmDP.findCheapestPrice(n4, flights4, src4, dst4, k4);

        // then
        assertEquals(1, sol1);
        assertEquals(200, sol2);
        assertEquals(500, sol3);
        assertEquals(700, sol4);

    }

}