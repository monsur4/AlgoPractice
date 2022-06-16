package com.mon.sort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SelectionSortTest {

    @Test
    void sort() {
        // given
        int[] array = new int[]{4,1,3,2,0,-1,7,10,1,9,20};

        // when
        SelectionSort.sort(array);

        // then
        assertArrayEquals(new int[]{-1, 0, 1, 1, 2, 3, 4, 7, 9, 10, 20}, array);
    }
}