import java.util.*;

class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        List<Integer>[] red = new ArrayList[n];
        List<Integer>[] blue = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            red[i] = new ArrayList<>();
            blue[i] = new ArrayList<>();
        }

        for (int[] e : redEdges)
            red[e[0]].add(e[1]);

        for (int[] e : blueEdges)
            blue[e[0]].add(e[1]);

        int[][] dist = new int[n][2];
        for (int[] d : dist)
            Arrays.fill(d, -1);

        Queue<int[]> q = new LinkedList<>();

        dist[0][0] = 0;
        dist[0][1] = 0;

        q.add(new int[]{0, 0});
        q.add(new int[]{0, 1});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int node = cur[0];
            int color = cur[1];

            List<Integer> next = color == 0 ? blue[node] : red[node];

            for (int v : next) {
                int nextColor = 1 - color;

                if (dist[v][nextColor] == -1) {
                    dist[v][nextColor] = dist[node][color] + 1;
                    q.add(new int[]{v, nextColor});
                }
            }
        }

        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            if (dist[i][0] == -1)
                ans[i] = dist[i][1];
            else if (dist[i][1] == -1)
                ans[i] = dist[i][0];
            else
                ans[i] = Math.min(dist[i][0], dist[i][1]);
        }

        return ans;
    }
}