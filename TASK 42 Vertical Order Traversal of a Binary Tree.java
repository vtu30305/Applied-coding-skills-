

class Solution {
    class Pair {
        TreeNode node;
        int row, col;

        Pair(TreeNode node, int row, int col) {
            this.node = node;
            this.row = row;
            this.col = col;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        TreeMap<Integer, List<int[]>> map = new TreeMap<>();
        Queue<Pair> queue = new LinkedList<>();

        queue.add(new Pair(root, 0, 0));

        while (!queue.isEmpty()) {
            Pair p = queue.poll();

            map.putIfAbsent(p.col, new ArrayList<>());
            map.get(p.col).add(new int[]{p.row, p.node.val});

            if (p.node.left != null)
                queue.add(new Pair(p.node.left, p.row + 1, p.col - 1));

            if (p.node.right != null)
                queue.add(new Pair(p.node.right, p.row + 1, p.col + 1));
        }

        for (List<int[]> list : map.values()) {
            list.sort((a, b) -> {
                if (a[0] != b[0])
                    return Integer.compare(a[0], b[0]);
                return Integer.compare(a[1], b[1]);
            });

            List<Integer> column = new ArrayList<>();

            for (int[] x : list)
                column.add(x[1]);

            result.add(column);
        }

        return result;
    }
}