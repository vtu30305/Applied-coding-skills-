import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        Stack<Character> st = new Stack<>();
        boolean valid = true;

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{' || c == '<') {
                st.push(c);
            } else {
                if (st.isEmpty()) {
                    valid = false;
                    break;
                }

                char x = st.pop();

                if (!((x == '(' && c == ')') ||
                      (x == '[' && c == ']') ||
                      (x == '{' && c == '}') ||
                      (x == '<' && c == '>'))) {
                    valid = false;
                    break;
                }
            }
        }

        System.out.println(valid && st.isEmpty() ? "VALID" : "INVALID");
    }
}
output:
VALID