import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();

        int cycle = sc.nextInt();

        for (int i = 0; i < n; i += k) {
            int l = i, r = Math.min(i + k - 1, n - 1);

            while (l < r) {
                int t = a[l];
                a[l] = a[r];
                a[r] = t;
                l++;
                r--;
            }
        }

        for (int i = 0; i < n; i++) {
            if (i > 0) System.out.print(" ");
            System.out.print(a[i]);
        }
        System.out.println();
    }
}
output:
30 20 10 60 50 40 80 70