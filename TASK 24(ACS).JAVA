class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder result = new StringBuilder();
        int balance = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                balance++;
                result.append(c);
            } else if (c == ')') {
                if (balance > 0) {
                    balance--;
                    result.append(c);
                }
            } else {
                result.append(c);
            }
        }

        StringBuilder answer = new StringBuilder();

        for (int i = result.length() - 1; i >= 0; i--) {
            char c = result.charAt(i);

            if (c == '(' && balance > 0) {
                balance--;
            } else {
                answer.append(c);
            }
        }

        return answer.reverse().toString();
    }
}