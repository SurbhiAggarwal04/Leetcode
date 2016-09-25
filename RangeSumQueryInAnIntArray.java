package LeetCode;
/*
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

Example:
Given nums = [-2, 0, 3, -5, 2, -1]

sumRange(0, 2) -> 1
sumRange(2, 5) -> -1
sumRange(0, 5) -> -3
 */
public class RangeSumQueryInAnIntArray {
	   private int[] nums;
	    private int[] sum;
	    public RangeSumQueryInAnIntArray(int[] nums) {
	        this.nums=nums;
	        sum=new int[nums.length+1];
	        sum[0]=0;
	        for(int k=0;k<nums.length;k++)
	        {
	            sum[k+1]+=sum[k]+nums[k];
	        }
	    }

	    public int sumRange(int i, int j) {
	        if(i>j)return 0;
	        
	        return sum[j+1]-sum[i];
	    }
}
