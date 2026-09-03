class MinStack {
    private int[] stack = new int[30000];
    private int[] minStack = new int[30000];
    private int top = -1;

    public MinStack() {
    }

    public void push(int val) {
        top++;
        stack[top] = val;

        if (top == 0) {
            minStack[top] = val;
        } else {
            minStack[top] = Math.min(val, minStack[top - 1]);
        }
    }

    public void pop() {
        top--;
    }

    public int top() {
        return stack[top];
    }

    public int getMin() {
        return minStack[top];
    }
}
