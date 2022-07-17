package com.mon.sort;

import java.util.*;
import java.util.stream.IntStream;

/**
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1.
 * You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first
 * if you want to take course ai.
 *
 * For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
 * Return the ordering of courses you should take to finish all courses. If there are many valid answers,
 * return any of them. If it is impossible to finish all courses, return an empty array.
 *
 *
 *
 * Example 1:
 *
 * Input: numCourses = 2, prerequisites = [[1,0]]
 * Output: [0,1]
 * Explanation: There are a total of 2 courses to take. To take course 1 you should have finished course 0.
 * So the correct course order is [0,1].
 * Example 2:
 *
 * Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
 * Output: [0,2,1,3]
 * Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2.
 * Both courses 1 and 2 should be taken after you finished course 0.
 * So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3].
 * Example 3:
 *
 * Input: numCourses = 1, prerequisites = []
 * Output: [0]
 */
public class TopologicalSortKahnsAlgorithm {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        Map<Integer, Integer> inDegMap = new HashMap<>();
        IntStream.range(0, numCourses)
                .forEach(i -> {
                    inDegMap.put(i, 0);
                    adjList.put(i, new ArrayList<>());
                });
        IntStream.range(0, prerequisites.length)
                .forEach(i -> {
                    int[] prereq = prerequisites[i];
                    inDegMap.put(prereq[0], inDegMap.get(prereq[0]) + 1);
                    adjList.get(prereq[1]).add(prereq[0]);
                });

        Queue<Integer> queue = new LinkedList<>();
        int[] sol = new int[numCourses];
        int pos = 0;

        for (int el : inDegMap.keySet()) {
            if (inDegMap.get(el) == 0) {
                queue.add(el);
            }

        }

        while (!queue.isEmpty()) {
            int r = queue.remove();
            sol[pos++] = r;
            List<Integer> adj = adjList.get(r);
            for (int el : adj) {
                if (inDegMap.containsKey(el)) {
                    inDegMap.put(el, inDegMap.get(el) - 1);
                    // add to the queue inDeg of zero
                    if(inDegMap.get(el) == 0) queue.add(el);
                }
            }
        }

        return pos == numCourses ? sol : new int[]{};
    }

    public static void main(String[] args) {
        TopologicalSortKahnsAlgorithm topologicalSortKahnsAlgorithm = new TopologicalSortKahnsAlgorithm();
        int[] order = topologicalSortKahnsAlgorithm.findOrder(2, new int[][]{{1, 0}});
        System.out.println("order = " + Arrays.toString(order));
    }
}
