package com.mon.sort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SelectionSortTest {

    @Test
    void sortComparingOutputWithExpectedArray() {
        // given
        int[] array = new int[]{4,1,3,2,0,-1,7,10,1,9,20};

        // when
        SelectionSort.sort(array);

        // then
        assertArrayEquals(new int[]{-1, 0, 1, 1, 2, 3, 4, 7, 9, 10, 20}, array);
    }

    @Test
    void sortComparingOutputWithElementOrdering() {
        // given
        int[] array = new int[]{4,1,3,2,0,-1,7,10,1,9,20};

        // when
        SelectionSort.sort(array);

        // then
        for(int j = 1; j < array.length; j++){
            int i = j - 1;
            assertTrue(array[i] <= array[j],
                    "element at index " + i + ": " + array[i]
                    + "\nelement at index " + j + ": " + array[j]);
            // could use compareTo for Integer Object
        }
    }

}