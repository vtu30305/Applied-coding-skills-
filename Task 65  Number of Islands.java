import java.util.*;

class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        int count = 0;
        int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    Queue<int[]> q = new LinkedList<>();
                    q.add(new int[]{i, j});
                    grid[i][j] = '0';

                    while (!q.isEmpty()) {
                        int[] cur = q.poll();

                        for (int[] d : dir) {
                            int r = cur[0] + d[0];
                            int c = cur[1] + d[1];

                            if (r >= 0 && r < m && c >= 0 && c < n
                                    && grid[r][c] == '1') {
                                grid[r][c] = '0';
                                q.add(new int[]{r, c});
                            }
                        }
                    }
                }
            }
        }

        return count;
    }
}