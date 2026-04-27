// 1559. Detect Cycles in 2D Grid




class Solution {
    public boolean containsCycle(char[][] grid) {
        int row[] = { 1, -1, 0, 0 };
        int col[] = { 0, 0, 1, -1 };
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] isVisited = new boolean[n][m];

        Queue<int[]> queue = new LinkedList<>();

        for (int k = 0; k < n; k++) {
            for (int z = 0; z < m; z++) {
                if (!isVisited[k][z]) {
                    queue.add(new int[]{k,z,-1,-1});
                    isVisited[k][z]= true;
                    while (!queue.isEmpty()) {
                        int[] co = queue.poll();
                        char c = grid[co[0]][co[1]];
                        String last = co[2] + "#" + co[3];
                        for (int i = 0; i < 4; i++) {
                            int x = co[0] + row[i];
                            int y = co[1] + col[i];
                            String ne = x + "#" + y;
                            if (!ne.equals(last) &&
                                    x >= 0 && x < n && y >= 0 && y < m &&
                                    !isVisited[x][y] && c == grid[x][y]) {
                                queue.add(new int[] { x, y, co[0], co[1] });
                                isVisited[x][y] = true;
                            } else if (!ne.equals(last) &&
                                    x >= 0 && x < n && y >= 0 && y < m &&
                                    isVisited[x][y] && c == grid[x][y]) {
                                return true;
                            }

                        }
                    }
                }
            }
        }
        return false;
    }
}