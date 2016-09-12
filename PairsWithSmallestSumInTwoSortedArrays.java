package LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Pair implements Comparable<Pair>
{
    int i;
    int j;
    int sum;
    public Pair(int i,int j,int sum)
    {
        this.i=i;
        this.j=j;
        this.sum=sum;
    }
    public int compareTo(Pair p)
    {
       // System.out.println("compare");
        if(p.sum<this.sum)return 1;
        return -1;
    }
}
public class PairsWithSmallestSumInTwoSortedArrays {
	 public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
	        List<int[]> result=new ArrayList<>();
	        PriorityQueue<Pair> pq=new PriorityQueue<>();
	        if(nums1.length<=0 || nums2.length<=0 || k<=0)return result;
	        pq.add(new Pair(0,0,nums1[0]+nums2[0]));
	        int count=0;
	        boolean visited[][]=new boolean[nums1.length][nums2.length];
	        visited[0][0]=true;
	        while(!pq.isEmpty())
	        {
	            Pair p=pq.poll();
	            
	            result.add(new int[]{nums1[p.i],nums2[p.j]});
	            count++;
	            if(count==k)break;
	            if(p.i+1<nums1.length && !visited[p.i+1][p.j])
	            {
	                pq.add(new Pair(p.i+1,p.j,nums1[p.i+1]+nums2[p.j]));
	                visited[p.i+1][p.j]=true;
	            }
	            if(p.j+1<nums2.length && !visited[p.i][p.j+1])
	            {
	                pq.add(new Pair(p.i,p.j+1,nums1[p.i]+nums2[p.j+1]));
	                visited[p.i][p.j+1]=true;
	            }
	        }
	        return result;
	        
	    }
}
