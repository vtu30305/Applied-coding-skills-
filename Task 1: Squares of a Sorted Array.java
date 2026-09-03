import java.util.*;
public class Solution{
    public static int[]sortedSquares(int[]nums){
        int n=nums.length;
        int[] ans=new int[n];
        int left = 0;
        int right = n-1;
        int pos=n-1;
        while(left<=right){
            int leftSquare=nums[left]*nums[left];
            int rightSquare=nums[right]*nums[right];
            if(leftSquare > rightSquare){
                ans[pos]=leftSquare;
                left++;
            }
            else{
                ans[pos]=rightSquare;
                right--;
            }
            pos--;
        }
        return ans;
    }
    public static void main(String[] args){
        int[] nums={-4,-1,0,3,10};
        int[] result=sortedSquares(nums);
        System.out.println(Arrays.toString(result));
    }
}
