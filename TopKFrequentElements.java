package LeetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class TopKFrequentElements {
	 public List<Integer> topKFrequent(int[] nums, int k) {
	        Map<Integer,ArrayList<Integer>> resultMap=new TreeMap<>(Collections.reverseOrder());
	        Map<Integer,Integer> map=new HashMap<Integer,Integer>();
	        ArrayList<Integer> result=new ArrayList<Integer>();
	        for(int i=0;i<nums.length;i++)
	        {
	            if(map.containsKey(nums[i]))
	            {
	                int count=map.get(nums[i]);
	                map.put(nums[i],++count);
	            }
	            else
	            {
	                map.put(nums[i],1);
	            }
	        }
	        for(int i:map.keySet())
	        {
	            if(resultMap.containsKey(map.get(i)))
	            {
	                ArrayList<Integer> list=resultMap.get(map.get(i));
	                list.add(i);
	                resultMap.put(map.get(i),list);
	            }
	            else
	            {
	                ArrayList<Integer> list=new ArrayList<Integer>();
	                list.add(i);
	                resultMap.put(map.get(i),list);
	            }
	        }
	      //  int count==0;
	        for(int j:resultMap.keySet())
	        {
	             ArrayList<Integer> list=resultMap.get(j);
	             for(int i=0;i<list.size();i++)
	             {
	                 result.add(list.get(i));
	                 if(result.size()==k)break;
	             }
	              if(result.size()==k)break;
	        }
	        return result;
	    }
}
