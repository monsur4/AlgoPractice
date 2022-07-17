package com.mon.sort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TopologicalSortKahnsAlgorithmTest {

    @Test
    void test(){
        // given
        int[][] prerequisites = new int[][]{{1, 0}};
        int noOfCourses = 2;
        // output = [0, 1]

        // when
        TopologicalSortKahnsAlgorithm topologicalSortKahnsAlgorithm = new TopologicalSortKahnsAlgorithm();
        int[] order = topologicalSortKahnsAlgorithm.findOrder(noOfCourses, prerequisites);

        // then
        assertArrayEquals(new int[]{0,1}, order);
    }

}