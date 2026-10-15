import java.util.*;

public class Main {
    static ArrayList<Integer>[] g;
    static boolean[] visited;

    static void dfs(int u) {
        visited[u] = true;

        for (int v : g[u])
            if (!visited[v])
                dfs(v);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        g = new ArrayList[n + 1];
        visited = new boolean[n + 1];

        for (int i = 1; i <= n; i++)
            g[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            g[u].add(v);
            g[v].add(u);
        }

        int count = 0;

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                dfs(i);
                count++;
            }
        }

        System.out.println("Connected Components = " + count);
    }
}
output:
Connected Components = 2