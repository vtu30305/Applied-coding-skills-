import java.util.*;

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        int[] parent = new int[n];

        for (int i = 0; i < n; i++)
            parent[i] = i;

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < accounts.get(i).size(); j++) {
                String email = accounts.get(i).get(j);

                if (map.containsKey(email))
                    union(parent, i, map.get(email));
                else
                    map.put(email, i);
            }
        }

        Map<Integer, List<String>> groups = new HashMap<>();

        for (String email : map.keySet()) {
            int root = find(parent, map.get(email));
            groups.computeIfAbsent(root, x -> new ArrayList<>()).add(email);
        }

        List<List<String>> ans = new ArrayList<>();

        for (int root : groups.keySet()) {
            List<String> emails = groups.get(root);
            Collections.sort(emails);

            List<String> list = new ArrayList<>();
            list.add(accounts.get(root).get(0));
            list.addAll(emails);

            ans.add(list);
        }

        return ans;
    }

    int find(int[] parent, int x) {
        if (parent[x] != x)
            parent[x] = find(parent, parent[x]);
        return parent[x];
    }

    void union(int[] parent, int a, int b) {
        parent[find(parent, a)] = find(parent, b);
    }
}