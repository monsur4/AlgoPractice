package com.mon.advancedArrays;

import java.util.Comparator;
import java.util.stream.IntStream;

public class HeapSort<T> {

    public T[] sort(T[] toSort, Comparator<T> comparator){
        MaxPriorityQueue<T> mpq = new MaxPriorityQueue<>(toSort, comparator);
        for (T el: toSort){
            mpq.insert(el);
        }

        IntStream.rangeClosed(1, toSort.length).forEach(i->mpq.delMax());
        T[] arr = (T[])new Object[toSort.length];
        IntStream.rangeClosed(1, toSort.length).forEach(i-> arr[i-1] = mpq.pq[i]);
        return arr;
    }

    static class MaxPriorityQueue<T>{
        public T[] pq;
        private int size;
        private int N;
        public Comparator<T> comparator;
        public MaxPriorityQueue(T[] t, Comparator<T> comparator){
            size = t.length;
            pq = (T[])new Object[size + 1];
            N = 1;
            this.comparator = comparator;
        }

        public void insert(T el){
            if(N > size) throw new ArrayIndexOutOfBoundsException("Attempt to insert el " + el +
                    " into pos N=" + N + " of Priority queue of size"+size);
            pq[N++] = el;
            swim(N-1);
        }

        public T delMax(){
            if(N == 1) throw new ArrayIndexOutOfBoundsException("Attempt to remove from empty pq index N=" + (N-1));
            T el = pq[1];
            exchange(1, --N);
            sink(1);
            return el;
        }

        private void exchange(int p, int q){
            T el = pq[p];
            pq[p] = pq[q];
            pq[q] = el;
        }

        private void sink(int pos){
            while((2 * pos) < N){
                int j = 2 * pos;
                if((j + 1) < N && comparator.compare(pq[j+1], pq[j]) > 0) {
                    j++;
                }
                if(comparator.compare(pq[pos], pq[j]) >= 0) break;
                exchange(pos, j);
                pos = j;
            }
        }

        private void swim(int pos){
            while((pos/2) >= 1){
                int parent = pos/2;
                if(comparator.compare(pq[parent], pq[pos]) >= 0) break;
                exchange(pos, parent);
                pos = parent;
            }
        }
    }
}
