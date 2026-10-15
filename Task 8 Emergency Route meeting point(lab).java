import java.util.*;

public class Main {
    static class Node {
        int val;
        Node left, right;

        Node(int v) {
            val = v;
        }
    }

    static Node build(int[] a, int i) {
        if (i >= a.length || a[i] == -1) return null;

        Node root = new Node(a[i]);
        root.left = build(a, 2 * i + 1);
        root.right = build(a, 2 * i + 2);
        return root;
    }

    static Node lca(Node root, int a, int b) {
        if (root == null || root.val == a || root.val == b)
            return root;

        Node left = lca(root.left, a, b);
        Node right = lca(root.right, a, b);

        if (left != null && right != null) return root;
        return left != null ? left : right;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();

        int x = sc.nextInt();
        int y = sc.nextInt();

        Node root = build(a, 0);
        Node ans = lca(root, x, y);

        if (ans != null)
            System.out.println("LCA = " + ans.val);
    }
}
output:
LCA = 5