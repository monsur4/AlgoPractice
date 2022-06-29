package com.mon.advancedArrays;

import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class PriorityQueueTest {

    @Test
    public void testDelMin(){
        // given
        int[] numbers = {3, 4, 5, 8, 99, 1, 4, 2, 6, 7, 8, 3};

        // when
        PriorityQueue<Integer> pq = new PriorityQueue<>(numbers.length, Comparator.comparingInt(a -> a));
        for(int n: numbers){
            pq.insert(n);
        }

        // then
        assertEquals(1, pq.delMin());
        assertEquals(2, pq.delMin());
        assertEquals(3, pq.delMin());
        assertEquals(3, pq.delMin());
        assertEquals(4, pq.delMin());
        assertEquals(4, pq.delMin());
        assertEquals(5, pq.delMin());
        assertEquals(6, pq.delMin());
        assertEquals(7, pq.delMin());
        assertEquals(8, pq.delMin());
        assertEquals(8, pq.delMin());
        assertEquals(99, pq.delMin());
        assertThrows(ArrayIndexOutOfBoundsException.class, pq::delMin);
    }

}