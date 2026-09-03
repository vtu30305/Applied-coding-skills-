class Solution {
    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        int[] stack = new int[n];
        int top = -1;

        for (int i = 0; i < n; i++) {
            while (top >= 0 && prices[stack[top]] >= prices[i]) {
                int index = stack[top--];
                prices[index] -= prices[i];
            }
            stack[++top] = i;
        }

        return prices;
    }
}
