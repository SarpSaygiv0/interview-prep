package com.medium.cycleingraph;

import java.util.HashSet;
import java.util.Set;

public class CycleInGraph {

    public boolean cycleInGraph(int[][] edges) {
        Set<Integer> explored = new HashSet<>();
        for (int vertex = 0; vertex < edges.length; vertex++) {
            Set<Integer> visited = new HashSet<>();
            if (containsCycle(edges, vertex, visited, explored))
                return true;
        }

        return false;
    }

    private boolean containsCycle(int[][] edges, int vertex, Set<Integer> visited, Set<Integer> explored) {
        if (visited.contains(vertex))
            return true;
        if (visited.contains(explored))
            return false;
        
        visited.add(vertex);

        for (int i = 0; i < edges[vertex].length; i++) {
            if (containsCycle(edges, edges[vertex][i], visited, explored)) {
                return true;
            }
        }
        visited.remove(vertex);
        explored.add(vertex);
        return false;
    }
}
