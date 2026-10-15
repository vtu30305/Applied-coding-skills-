class Solution {
    public String longestNiceSubstring(String s) {
        String ans = "";

        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String sub = s.substring(i, j);
                boolean nice = true;

                for (char c : sub.toCharArray()) {
                    char opposite = Character.isLowerCase(c)
                            ? Character.toUpperCase(c)
                            : Character.toLowerCase(c);

                    if (sub.indexOf(opposite) == -1) {
                        nice = false;
                        break;
                    }
                }

                if (nice && sub.length() > ans.length()) {
                    ans = sub;
                }
            }
        }

        return ans;
    }
}