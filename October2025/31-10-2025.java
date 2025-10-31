// Shortest Cycle
// Difficulty: HardAccuracy: 76.23%Submissions: 4K+Points: 8
// You are given an undirected graph with V vertices numbered from 0 to V-1 and E edges, represented as a 2D array edges[][], where each element edges[i] = [u, v] represents an undirected edge between vertex u and v.
// Find the length of the shortest cycle in the graph. If the graph does not contain any cycle, return -1.


// Note: A cycle is a path that starts and ends at the same vertex without repeating any edge or vertex (except the start/end vertex). The shortest cycle is the one with the minimum number of edges.



import java.util.*;

class Solution {
    public int shortCycle(int V, int[][] edges) {
        // Create adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        int shortest = Integer.MAX_VALUE;

        // Run BFS from each vertex
        for (int start = 0; start < V; start++) {
            int[] dist = new int[V];
            Arrays.fill(dist, -1);
            int[] parent = new int[V];
            Arrays.fill(parent, -1);

            Queue<Integer> q = new LinkedList<>();
            q.offer(start);
            dist[start] = 0;

            while (!q.isEmpty()) {
                int u = q.poll();

                for (int v : adj.get(u)) {
                    if (dist[v] == -1) {
                        // Not visited
                        dist[v] = dist[u] + 1;
                        parent[v] = u;
                        q.offer(v);
                    } else if (parent[u] != v) {
                        // Found a cycle
                        int cycleLength = dist[u] + dist[v] + 1;
                        shortest = Math.min(shortest, cycleLength);
                    }
                }
            }
        }

        // If no cycle found
        return (shortest == Integer.MAX_VALUE) ? -1 : shortest;
    }
}