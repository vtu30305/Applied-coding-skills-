import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] a = new int[n][2];

        for (int i = 0; i < n; i++) {
            a[i][0] = sc.nextInt();
            a[i][1] = sc.nextInt();
        }

        Arrays.sort(a, (x, y) -> x[1] - y[1]);

        int count = 0, end = 0;

        for (int i = 0; i < n; i++) {
            if (count == 0 || a[i][0] >= end) {
                count++;
                end = a[i][1];
            }
        }

        System.out.println("MaximumEvents = " + count);
    }
}
output:
MaximumEvents = 4