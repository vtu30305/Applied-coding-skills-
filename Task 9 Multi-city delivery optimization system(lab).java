import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int k = sc.nextInt();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            int n = sc.nextInt();
            for (int j = 0; j < n; j++)
                list.add(sc.nextInt());
        }

        Collections.sort(list);

        System.out.println("Merged:");
        for (int x : list)
            System.out.print(x + " ");

        System.out.println("\n\nTopK:");
        for (int i = list.size() - 1; i >= list.size() - k; i--)
            System.out.print(list.get(i) + " ");

        System.out.println();
    }
}
output:
Merged:
1 2 3 6 7 8 9 12 14 15 18 20

TopK:
20 18 15 14 12