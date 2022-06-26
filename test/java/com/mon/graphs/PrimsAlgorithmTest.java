package com.mon.graphs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrimsAlgorithmTest {

    @Test
    void minCostToConnectPoints(){
        //given
        int[][] points = new int[][]{
                {0,0},
                {2,2},
                {3,10},
                {5,2},
                {7,0},
        };
        int[][] points2 = new int[][]{
                {3,12},
                {-2,5},
                {-4,1},
        };

        // when
        PrimsAlgorithm primsAlgorithm = new PrimsAlgorithm();
        int minCost1 = primsAlgorithm.minCostConnectPoints(points);
        int minCost2 = primsAlgorithm.minCostConnectPoints(points2);

        // then
        assertEquals(20, minCost1);
        assertEquals(18, minCost2);
    }

}