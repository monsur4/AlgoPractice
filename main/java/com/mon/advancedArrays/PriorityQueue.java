package com.mon.advancedArrays;

import java.util.Comparator;

public class PriorityQueue<T> {
    int size;
    int N = 1;
    T[] pq;
    Comparator<T> comparator;
    public PriorityQueue(int size, Comparator<T> comparator){
        this.size = size;
        pq = (T[])new Object[size + 1];
        this.comparator = comparator;
    }

    public void insert(T el){
        if(N > size)
            throw new ArrayIndexOutOfBoundsException(
                    "Cannot insert element into a full priority queue. index N=" + (N) +  " size=" + size);
        pq[N++] = el;
        swim(N-1);
    }

    private void swim(int n){
        int parent = n/2;
        while(n > 1 && comparator.compare(pq[n],pq[parent]) < 0){
            exchange(n, parent);
            n = parent;
            parent = n/2;
        }
    }

    private void exchange(int n, int parent){
        T temp = pq[n];
        pq[n] = pq[parent];
        pq[parent] = temp;
    }

    public T delMin(){
        if(N == 1)
            throw new ArrayIndexOutOfBoundsException("Unable to remove from an empty Priority queue of size N=" + (N-1));
        T el = pq[1];
        exchange(1, --N);
        pq[N] = null; // null out the extreme of the array
        sink(1);
        return el;
    }

    private void sink(int n){
        int child = n * 2;
        while(child < N){
            if(child + 1 < N && comparator.compare(pq[child + 1],pq[child]) < 0) child++;
            if(comparator.compare(pq[n], pq[child]) > 0) exchange(n, child);
            else break;
            n = child;
            child = child * 2;
        }
    }
}
