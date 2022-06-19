package com.mon.graphs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KruskalsAlgorithmTest {

    @Test
    void minCostConnectPoints() {
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
        KruskalsAlgorithm kruskalsAlgorithm = new KruskalsAlgorithm();
        int minCost = kruskalsAlgorithm.minCostConnectPoints(points);
        int minCost2 = kruskalsAlgorithm.minCostConnectPoints(points2);

        // then
        assertEquals(20, minCost);
        assertEquals(18, minCost2);
    }
}