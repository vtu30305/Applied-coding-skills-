import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int w = sc.nextInt();

        int[] weight = new int[n + 1];
        int[] value = new int[n + 1];
        int[][] dp = new int[n + 1][w + 1];

        for (int i = 1; i <= n; i++) {
            weight[i] = sc.nextInt();
            value[i] = sc.nextInt();
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= w; j++) {
                dp[i][j] = dp[i - 1][j];

                if (weight[i] <= j) {
                    dp[i][j] = Math.max(dp[i][j],
                        dp[i - 1][j - weight[i]] + value[i]);
                }
            }
        }

        ArrayList<Integer> selected = new ArrayList<>();
        int capacity = w;

        for (int i = n; i >= 1; i--) {
            if (dp[i][capacity] != dp[i - 1][capacity]) {
                selected.add(i);
                capacity -= weight[i];
            }
        }

        Collections.sort(selected);

        System.out.println("MaximumValue = " + dp[n][w]);
        System.out.println("SelectedItems:");

        for (int x : selected)
            System.out.print(x + " ");

        System.out.println();
    }
}
output:
MaximumValue = X
SelectedItems:
indices