class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int[] stack = new int[asteroids.length];
        int top = -1;

        for (int asteroid : asteroids) {
            boolean destroyed = false;

            while (top >= 0 && stack[top] > 0 && asteroid < 0) {
                if (stack[top] < -asteroid) {
                    top--;
                } else if (stack[top] == -asteroid) {
                    top--;
                    destroyed = true;
                    break;
                } else {
                    destroyed = true;
                    break;
                }
            }

            if (!destroyed) {
                stack[++top] = asteroid;
            }
        }

        int[] result = new int[top + 1];

        for (int i = 0; i <= top; i++) {
            result[i] = stack[i];
        }

        return result;
    }
}
