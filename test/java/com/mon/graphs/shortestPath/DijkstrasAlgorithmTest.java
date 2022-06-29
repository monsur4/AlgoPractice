package com.mon.graphs.shortestPath;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DijkstrasAlgorithmTest {

    @Test
    void networkDelayTimeTest(){
        // given
        int[][] times = new int[][]{{2,1,1},{2,3,1},{3,4,1}};
        int n = 4;
        int k = 2;
        // output = 2;

//        int[][] times = new int[][]{{1,2,1}};
//        int n = 2;
//        int k = 2;
//         //output = -1;

//        int[][] times = new int[][]{{1,2,1}};
//        int n = 2;
//        int k = 1;
//        // output = 1;

        // when
        DijkstrasAlgorithm dijkstrasAlgorithm = new DijkstrasAlgorithm();
        int sol = dijkstrasAlgorithm.networkDelayTime(times, n, k);

        // then
        assertEquals(2, sol);
    }

}