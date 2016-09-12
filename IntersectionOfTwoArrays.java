package LeetCode;

import java.util.*;

public class IntersectionOfTwoArrays {
    public int[] intersect(int[] nums1, int[] nums2) {
        //if(nums1.length==0 || nums2.length==0)return null;
        Hashtable<Integer,Integer> table=new Hashtable<Integer,Integer>();
        ArrayList<Integer> list=new ArrayList<Integer>();
        for(int i=0;i<nums1.length;i++)
        {
            if(table.containsKey(nums1[i]))
            {
                int count=table.get(nums1[i]);
                table.put(nums1[i],++count);
            }
            else
            {
                 table.put(nums1[i],1);
            }
        }
        for(int i=0;i<nums2.length;i++)
        {
            if(table.containsKey(nums2[i]) && table.get(nums2[i])>0)
            {
               list.add(nums2[i]);
                int count=table.get(nums2[i]);
                table.put(nums2[i],--count);
            }
        }
        int[] result=new int[list.size()];
        for(int i=0;i<list.size();i++)
        {
            result[i]=list.get(i);
        }
        return result;
    }
}