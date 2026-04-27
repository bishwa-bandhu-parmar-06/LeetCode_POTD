// 1391. Check if There is a Valid Path in a Grid




class Solution {
    int[][][] moves = new int[][][]{{}, {{0, 1}, {0, -1}}, {{1, 0}, {-1, 0}}, {{0, -1}, {1, 0}}, {{0, 1}, {1, 0}}, {{0, -1}, {-1, 0}}, {{0, 1}, {-1, 0}}};

    public boolean hasValidPath(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        Deque<int[]> q = new ArrayDeque<>();

        q.addLast(new int[]{0, 0});
        visited[0][0] = true;

        while (!q.isEmpty()) {
            int[] cur = q.removeFirst();
            int i = cur[0], j = cur[1];
            if (i == m - 1 && j == n - 1) return true;
            for (int[] move : moves[grid[i][j]]) {
                int _i = i + move[0];
                int _j = j + move[1];

                if (_i >= 0 && _i < m && _j >= 0 && _j < n && !visited[_i][_j]) {
                    for (int[] back : moves[grid[_i][_j]]) {
                        if (_i + back[0] == i && _j + back[1] == j) {
                            visited[_i][_j] = true;
                            q.offer(new int[]{_i, _j});
                        }
                    }
                }
            }
        }

        return false;
    }
}