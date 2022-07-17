package com.mon.graphs.shortestPath;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BellmanFordAlgorithmQueue1Test {

    @Test
    void minimumEffortPathTest(){
        // given
        int[][] heights1 = new int[][]{{1,2,2},{3,8,2},{5,3,5}}; // output = 2
        int[][] heights2 = new int[][]{{1,2,3},{3,8,4},{5,3,5}}; // output = 1
        int[][] heights3 = new int[][]{{1,2,1,1,1},{1,2,1,2,1},{1,2,1,2,1},{1,2,1,2,1},{1,1,1,2,1}}; // output = 0

        // when
        BellmanFordAlgorithmQueue1 bfa = new BellmanFordAlgorithmQueue1();
        int sol1 = bfa.minimumEffortPath(heights1);
        int sol2 = bfa.minimumEffortPath(heights2);
        int sol3 = bfa.minimumEffortPath(heights3);

        // then
        assertEquals(2, sol1);
        assertEquals(1, sol2);
        assertEquals(0, sol3);
    }

}