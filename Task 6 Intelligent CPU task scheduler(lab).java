import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] freq = new int[26];

        for (int i = 0; i < n; i++)
            freq[sc.next().charAt(0) - 'A']++;

        Arrays.sort(freq);
        int max = freq[25];
        int count = 0;

        for (int f : freq)
            if (f == max) count++;

        int time = Math.max(n, (max - 1) * (k + 1) + count);
        System.out.println(time);
    }
}
output:
8