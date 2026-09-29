import java.util.*;

class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int fresh = 0;
        int minutes = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        int[][] directions = {
            {1, 0}, {-1, 0}, {0, 1}, {0, -1}
        };

        while (!queue.isEmpty() && fresh > 0) {
            int size = queue.size();
            minutes++;

            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                int r = current[0];
                int c = current[1];

                for (int[] d : directions) {
                    int nr = r + d[0];
                    int nc = c + d[1];

                    if (nr >= 0 && nr < m && nc >= 0 && nc < n
                            && grid[nr][nc] == 1) {

                        grid[nr][nc] = 2;
                        fresh--;
                        queue.add(new int[]{nr, nc});
                    }
                }
            }
        }

        return fresh == 0 ? minutes : -1;
    }
}