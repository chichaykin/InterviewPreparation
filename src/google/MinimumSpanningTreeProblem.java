package google;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;


//https://leetcode.com/problems/optimize-water-distribution-in-a-village/
public class MinimumSpanningTreeProblem {

    static class Edge {
        int cost;
        int src;
        int dst;

        public Edge(int cost, int src, int dst) {
            this.cost = cost;
            this.src = src;
            this.dst = dst;
        }
    }

    // Return the minimum total cost to supply water to all houses.
    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < wells.length; i++) {
            edges.add(new Edge(wells[i], 0, i + 1));
        }
        for (int[] pipe : pipes) {
            int v1 = pipe[0], v2 = pipe[1], cost = pipe[2];
            edges.add(new Edge(cost, v1, v2));
        }

        int cost = 0;
        Collections.sort(edges, Comparator.comparingInt(o -> o.cost));
        int parent[] = new int[n + 1];
        for (int i = 1; i < parent.length; i++) {
            parent[i] = i;
        }
        for (Edge edge : edges) {
            int src = find(parent, edge.src), dst = find(parent, edge.dst);
            if (src != dst) {
                union(parent, src, dst);
                cost += edge.cost;
                //System.out.println(String.format("cost: (%d-%d) - %d", edge.dst, edge.src, edge.cost));
            }
        }
        return cost;
    }

    private void union(int[] parent, int src, int dst) {
        parent[src] = dst;
    }

    private int find(int[] parent, int src) {
        while (src != parent[src]) {
            parent[src] = parent[parent[src]];
            src = parent[src];
        }
        return src;
    }

    @Test
    public void test() {
        int wells[] = {1, 2, 2}, pipes[][] = {{1, 2, 1}, {2, 3, 1}};
        assertEquals(3, minCostToSupplyWater(3, wells, pipes));
    }

    @Test
    public void test2() {
        int wells[] = {1, 2, 2}, pipes[][] = {{1, 3, 1}, {3, 2, 1}};
        assertEquals(3, minCostToSupplyWater(3, wells, pipes));
    }

    @Test
    public void test22() {
        int wells[] = {1, 2, 2}, pipes[][] = {{1, 3, 1}, {2, 3, 1}};
        assertEquals(3, minCostToSupplyWater(3, wells, pipes));
    }

    @Test
    public void test3() {
        int wells[] = {46012, 72474, 64965, 751, 33304}, pipes[][] = {{2, 1, 6719}, {3, 2, 75312}, {5, 3, 44918}};
        assertEquals(131704, minCostToSupplyWater(5, wells, pipes));
    }
}
