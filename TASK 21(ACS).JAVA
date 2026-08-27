class StockSpanner {
    private int[] prices = new int[10005];
    private int[] spans = new int[10005];
    private int top = -1;

    public StockSpanner() {
    }

    public int next(int price) {
        int span = 1;

        while (top >= 0 && prices[top] <= price) {
            span += spans[top];
            top--;
        }

        prices[++top] = price;
        spans[top] = span;

        return span;
    }
}