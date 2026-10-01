import java.util.*;

class Solution {
    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        for (int i = 0; i < n; i++)
            if (group[i] == -1)
                group[i] = m++;

        List<Integer>[] itemGraph = new ArrayList[n];
        List<Integer>[] groupGraph = new ArrayList[m];

        for (int i = 0; i < n; i++)
            itemGraph[i] = new ArrayList<>();

        for (int i = 0; i < m; i++)
            groupGraph[i] = new ArrayList<>();

        int[] itemIn = new int[n];
        int[] groupIn = new int[m];

        for (int i = 0; i < n; i++) {
            for (int pre : beforeItems.get(i)) {
                itemGraph[pre].add(i);
                itemIn[i]++;

                if (group[pre] != group[i]) {
                    groupGraph[group[pre]].add(group[i]);
                    groupIn[group[i]]++;
                }
            }
        }

        List<Integer> groups = topo(groupGraph, groupIn);
        if (groups.size() != m)
            return new int[0];

        List<Integer> items = topo(itemGraph, itemIn);
        if (items.size() != n)
            return new int[0];

        List<Integer>[] grouped = new ArrayList[m];

        for (int i = 0; i < m; i++)
            grouped[i] = new ArrayList<>();

        for (int x : items)
            grouped[group[x]].add(x);

        int[] ans = new int[n];
        int k = 0;

        for (int g : groups)
            for (int x : grouped[g])
                ans[k++] = x;

        return ans;
    }

    private List<Integer> topo(List<Integer>[] graph, int[] indegree) {
        Queue<Integer> q = new LinkedList<>();
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < indegree.length; i++)
            if (indegree[i] == 0)
                q.add(i);

        while (!q.isEmpty()) {
            int u = q.poll();
            result.add(u);

            for (int v : graph[u]) {
                if (--indegree[v] == 0)
                    q.add(v);
            }
        }

        return result;
    }
}