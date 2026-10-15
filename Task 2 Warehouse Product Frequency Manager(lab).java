import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            map.put(a[i], map.getOrDefault(a[i], 0) + 1);
        }

        int id = 0, max = 0;

        for (int x : map.keySet()) {
            if (map.get(x) > max) {
                max = map.get(x);
                id = x;
            }
        }

        System.out.println(id + " " + max);
    }
}
output:
5 4