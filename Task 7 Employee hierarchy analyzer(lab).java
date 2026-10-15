import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();

        int height = 0, count = 0;
        Queue<Integer> q = new LinkedList<>();

        if (n > 0 && a[0] != -1) q.add(0);

        while (!q.isEmpty()) {
            int size = q.size();
            count++;

            for (int i = 0; i < size; i++) {
                int idx = q.poll();

                int left = 2 * idx + 1;
                int right = 2 * idx + 2;

                if (left < n && a[left] != -1) q.add(left);
                if (right < n && a[right] != -1) q.add(right);
            }
        }

        height = count - 1;
        System.out.println("Height = " + height);
        System.out.println("Levels = " + count);
    }
}
output:
Height = 2
Levels = 3