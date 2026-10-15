import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();
        int[][] a = new int[r][c];
        Queue<int[]> q = new LinkedList<>();
        int trees = 0, minutes = 0;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                a[i][j] = sc.nextInt();

                if (a[i][j] == 2)
                    q.add(new int[]{i, j});
                if (a[i][j] == 1)
                    trees++;
            }
        }

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while (!q.isEmpty() && trees > 0) {
            int size = q.size();
            boolean spread = false;

            for (int i = 0; i < size; i++) {
                int[] p = q.poll();

                for (int d = 0; d < 4; d++) {
                    int x = p[0] + dx[d];
                    int y = p[1] + dy[d];

                    if (x >= 0 && x < r && y >= 0 && y < c
                            && a[x][y] == 1) {
                        a[x][y] = 2;
                        trees--;
                        q.add(new int[]{x, y});
                        spread = true;
                    }
                }
            }

            if (spread) minutes++;
        }

        System.out.println("Minutes = " + (trees == 0 ? minutes : -1));
    }
}
output:
Minutes = X
