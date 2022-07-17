package com.mon.sort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TopologicalSortReversePostOrderTest {

    @Test
    void test(){
        // given
        int[][] prerequisites1 = new int[][]{{1, 0}};
        int noOfCourses1 = 2;
        // output = [0, 1]

        int[][] prerequisites2 = new int[][]{{0,1},{1,0}};
        int noOfCourses2 = 2;
        // output = []

        // when
        TopologicalSortReversePostOrder topologicalSortReversePostOrder = new TopologicalSortReversePostOrder();
        int[] order1 = topologicalSortReversePostOrder.findOrder(noOfCourses1, prerequisites1);
        int[] order2 = topologicalSortReversePostOrder.findOrder(noOfCourses2, prerequisites2);

        // then
        assertArrayEquals(new int[]{0,1}, order1);
        assertArrayEquals(new int[]{}, order2);
    }

}