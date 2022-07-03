package com.mon.advancedArrays;

import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class HeapSortTest {

    @Test
    public void testHeapSortPriorityQueue(){
        // given
        Integer[] numbers = {3, 4, 5, 8, 99, 1, 4, 2, 6, 7, 8, 3};

        // when
        HeapSort.MaxPriorityQueue<Integer> hmpq = new HeapSort.MaxPriorityQueue<>(numbers, Comparator.comparingInt(a->a));
        for(int el: numbers){
            hmpq.insert(el);
        }
        // then
        assertEquals(99, hmpq.delMax());
        assertEquals(8, hmpq.delMax());
        assertEquals(8, hmpq.delMax());
        assertEquals(7, hmpq.delMax());
        assertEquals(6, hmpq.delMax());
        assertEquals(5, hmpq.delMax());
        assertEquals(4, hmpq.delMax());
        assertEquals(4, hmpq.delMax());
        assertEquals(3, hmpq.delMax());
        assertEquals(3, hmpq.delMax());
        assertEquals(2, hmpq.delMax());
        assertEquals(1, hmpq.delMax());
        assertThrows(ArrayIndexOutOfBoundsException.class, hmpq::delMax);
    }

    @Test
    public void testHeapSort(){
        // given
        Integer[] numbers = {3, 4, 5, 8, 99, 1, 4, 2, 6, 7, 8, 3};

        // when
        HeapSort<Integer> hp = new HeapSort<>();
        // Integer[] sorted = hp.sort(numbers, Comparator.comparingInt(a -> a)); => ClassCastException,
        // cannot cast Integer to Object (☹️weird)

        // then
        assertArrayEquals(new Integer[]{1, 2, 3, 3, 4, 4, 5, 6, 7, 8, 8, 99},
                hp.sort(numbers, Comparator.comparingInt(a -> a)));
    }

}