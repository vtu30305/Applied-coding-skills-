import java.util.*;

class Solution {
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        int[] bit = new int[20002];
        Integer[] ans = new Integer[n];

        for (int i = n - 1; i >= 0; i--) {
            int x = nums[i] + 10001;
            int count = 0;

            for (int j = x - 1; j > 0; j -= j & -j)
                count += bit[j];

            ans[i] = count;

            for (int j = x; j < bit.length; j += j & -j)
                bit[j]++;
        }

        return Arrays.asList(ans);
    }
}