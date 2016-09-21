package LeetCode;

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
