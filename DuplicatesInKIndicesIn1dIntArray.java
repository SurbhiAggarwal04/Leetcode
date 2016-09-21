package LeetCode;

import java.util.HashMap;

public class DuplicatesInKIndicesIn1dIntArray {
	  public boolean containsNearbyDuplicate(int[] nums, int k) {
	        if(nums==null || nums.length==0)
	        return false;
	        HashMap<Integer,Boolean> map=new HashMap<>();
	        for(int i=0;i<nums.length;i++)
	        {
	            if(map.containsKey(nums[i]))
	            {
	                if(map.get(nums[i]))return true;
	            }
	            map.put(nums[i],true);
	            if(i-k>=0)
	            {
	                map.put(nums[i-k],false);
	            }
	        }
	        return false;
	    }
}
