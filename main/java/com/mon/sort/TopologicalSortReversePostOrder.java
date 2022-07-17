package com.mon.sort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * Topological sort algorithm implemented with depth first search and reverse post order
 * Also includes cycle detection
 */
public class TopologicalSortReversePostOrder {

    // visited
    boolean[] visited;
    int[] solution;
    int pos;

    // detect cycle
    boolean[] onStack;
    boolean hasCycle = false;

    public int[] findOrder(int numCourses, int[][] prerequisites){
        // build a graph
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        IntStream.range(0, numCourses).forEach(i-> adjList.put(i, new ArrayList<>()));
        IntStream.range(0, prerequisites.length).forEach(i->{
            int[] pre = prerequisites[i];
            adjList.get(pre[1]).add(pre[0]);
        });

        // visited
        visited = new boolean[numCourses];

        // solution
        solution = new int[numCourses];
        pos = numCourses-1;

        // detect cycle
        onStack = new boolean[numCourses];

        // run dfs and place elements front the last index of the array
        IntStream.range(0, numCourses).forEach(i->{
            if(!visited[i] && !hasCycle){
                dfs(adjList, i);
            }
        });

        return hasCycle ? new int[]{} : solution;
    }

    private void dfs(Map<Integer, List<Integer>> graph, int s){
        if(hasCycle) return;
        visited[s] = true;
        onStack[s] = true;
        List<Integer> neighbour = graph.get(s);
        for(int n: neighbour){
            if(onStack[n]) {
                hasCycle = true;
                return;
            }
            if(!visited[n]) {
                dfs(graph, n);
            }
        }
        onStack[s] = false;
        solution[pos--] = s;
    }
}
