class Solution {
    public boolean isHappy(int n) {
        int slow = n, fast = n;

        do {
            slow = sum(slow);
            fast = sum(sum(fast));
        } while (slow != fast);

        return slow == 1;
    }

    int sum(int n) {
        int s = 0;
        while (n > 0) {
            int d = n % 10;
            s += d * d;
            n /= 10;
        }
        return s;
    }
}