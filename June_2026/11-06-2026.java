// 3558. Number of Ways to Assign Edge Weights I


class Solution {
    private final int mod = 1000000007;

    private long pow(long base, int exp) {
        long result = 1;
        while(exp > 0) {
            if(exp % 2 > 0) result = result * base % mod;
            base = base * base % mod;
            exp /= 2;
        }
        return result;
    }

    private int dfs(int node, int prev, List<Integer> graph[]){
        int dist = 0;
        for(int v : graph[node]) 
            if(v != prev) dist = Math.max(dist, dfs(v, node, graph) + 1);
        return dist;
    }

    public int assignEdgeWeights(int[][] edges) {
        int n = edges.length + 1;
        List<Integer> graph[] = new ArrayList[n + 1];
        Arrays.setAll(graph, i -> new ArrayList<>());

        for(int e[] : edges) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }

        return (int) pow(2, dfs(1, 0, graph) - 1);
    }
}