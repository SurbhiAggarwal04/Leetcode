package LeetCode;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;
/*
 * Example:
Given nums = [-2, 5, -1], lower = -2, upper = 2,
Return 3.
The three ranges are : [0, 0], [2, 2], [0, 2] and their respective sums are: -2, -1, 2.
 */

public class CountOfRangeSum {
    public static int countRangeSum(int[] nums, int lower, int upper) {
        int n = nums.length;
        long[] sums = new long[n + 1];
        for (int i = 0; i < n; ++i)
            sums[i + 1] = sums[i] + nums[i];
        System.out.println("sum:"+Arrays.toString(sums));
        return countWhileMergeSort(sums, 0, n + 1, lower, upper);
    }
    
    private static int countWhileMergeSort(long[] sums, int start, int end, int lower, int upper) {
        if (end - start <= 1) return 0;
        int mid = (start + end) / 2;
        int count = countWhileMergeSort(sums, start, mid, lower, upper) 
                  + countWhileMergeSort(sums, mid, end, lower, upper);
        System.out.println("sum:"+Arrays.toString(sums));
        System.out.println("previouscount:"+count);
        //System.out.println("sum:"+Arrays.toString(sums));
        int j = mid, k = mid, t = mid, r = 0;
        long[] cache = new long[end - start];
        for (int i = start; i < mid; ++i, ++r) {
            while (k < end && sums[k] - sums[i] < lower) k++;
            while (j < end && sums[j] - sums[i] <= upper) j++;
            while (t < end && sums[t] < sums[i]) cache[r++] = sums[t++]; //start merging
            cache[r] = sums[i];
            count += j - k;
        }
        System.out.println("count:"+count);
        System.arraycopy(cache, 0, sums, start, r);
        return count;
    }
    
    public static int countRangeSumv1(int[] nums, int lower, int upper) {
        int count = 0;
        long[] sum = new long[nums.length+1];
        TreeMap<Long, Integer> map = new TreeMap<Long, Integer>(); 
        map.put(0L, 1);
        for(int i=0; i<nums.length; i++){
            sum[i+1] = sum[i]+nums[i];
            map.put(sum[i+1], map.containsKey(sum[i+1])? map.get(sum[i+1])+1: 1);
        }
        for(int i=0; i<nums.length; i++){
            map.put(sum[i], map.get(sum[i])-1);
            if(map.get(sum[i]) == 0) map.remove(sum[i]);
            for(Map.Entry<Long, Integer> entry: map.subMap(sum[i]+lower, sum[i]+upper+1).entrySet())
                count += entry.getValue();
        }
        return count;
    }
    public static void main(String[] args) {
		System.out.println(countRangeSum(new int[]{-2,5,-1},-2,2));
		System.out.println(countRangeSumv1(new int[]{-2,5,-1},-2,2));
	}
}