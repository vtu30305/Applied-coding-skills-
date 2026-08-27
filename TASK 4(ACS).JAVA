class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

       
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        int leftSum = 0;

        for (int i = 0; i < n; i++) {

          
            int leftCount = i;

           
            int rightCount = n - i - 1;

           
            int leftDifference = nums[i] * leftCount - leftSum;

           
            int rightSum = totalSum - leftSum - nums[i];

            
            int rightDifference = rightSum - nums[i] * rightCount;

           
            result[i] = leftDifference + rightDifference;

          
            leftSum += nums[i];
        }

        return result;
    }
}