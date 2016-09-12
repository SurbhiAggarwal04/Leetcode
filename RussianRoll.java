package LeetCode;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*class Pair implements Comparable<Pair>
{
    int w;
    int h;
    public Pair(int w,int h)
    {
        this.w=w;
        this.h=h;
    }
    public int compareTo(Pair a)
    {
       System.out.println("inside compare");
       System.out.println("this:"+this.w+","+this.h+" a:"+a.w+","+a.h);
        if(this.w==a.w && this.h<a.h)
        	{
        	System.out.println("going");
        	return -1;
        	}
        if(this.w<a.w)
        	{
        	System.out.println("going");
        	return -1;
        	}
        else return 1;
    }
    public String toString()
    {
        return "w:"+w+",h:"+h;
    }
}*/
public class RussianRoll {
	public static void buildHeap(int[][] envelopes,int size)
	{
		int n=size-1;
		
		for(int i=(n-1)/2;i>=0;i-- )
		{
			percolateDown(envelopes,i,n);
		}
		/*for(int i=0;i<envelopes.length;i++)
		{
			System.out.println(Arrays.toString(envelopes[i]));
		}*/
		//System.out.println(Arrays.toString(envelopes));
		for(int i=n;i>=0;i--)
		{
			//System.out.println("a check");
			//System.out.println(Arrays.toString(envelopes[0]));
			int temp[]=envelopes[0];
	    	envelopes[0]=envelopes[n];
	    	envelopes[n]=temp;
	    	n--;
	    	percolateDown(envelopes,0,n);
		}
	}
	public static void percolateDown(int[][] envelopes,int i,int length)
	{
	    int l=2*i+1;
	    int r=2*i+2;
	    int largest=i;
	    int []max=envelopes[i];
	    if(l<=length && envelopes[l][0]>max[0])
	    {
	    	largest=l;
	    	max=envelopes[l];
	    }
	     if(l<=length && envelopes[l][0]==max[0] && envelopes[l][1]>=max[1])
	    {
	    	largest=l;
	    	max=envelopes[l];
	    }
	     if(r<=length && envelopes[r][0]>max[0])
	    {
	    	largest=r;
	    	max=envelopes[r];
	    }
	     if(r<=length && envelopes[r][0]==max[0] && envelopes[r][1]>=max[1])
	    {
	    	largest=r;
	    	max=envelopes[r];
	    }
	    if(largest!=i)
	    {
	    	int temp[]=envelopes[i];
	    	envelopes[i]=envelopes[largest];
	    	envelopes[largest]=temp;
	    	percolateDown(envelopes, largest, length);
	    }
	}
    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes.length==0)return 0;
        Integer maxCount[]=new Integer[envelopes.length];
        Arrays.fill(maxCount,1);
        int count=1;
        buildHeap(envelopes, envelopes.length);
       // Queue<Pair> queue=new PriorityQueue<Pair>();
       
        int min=0;
        for(int i=1;i<envelopes.length;i++)
        {
        	int j=0;
        	while(j<i)
        	{
        		if(envelopes[i][0]>envelopes[j][0] && envelopes[i][1]>envelopes[j][1] && maxCount[i]<maxCount[j]+1)
                {
        			maxCount[i]=maxCount[j]+1;
           		 //System.out.println(Arrays.toString(envelopes[i]));
           		 //count++;
           		 //min=i;
                }
        		j++;
        	}
        	 
        }
        System.out.println(Arrays.toString(maxCount));
        List<Integer> list=Arrays.asList(maxCount);

        return Collections.max(list);
        
    }
    public static void main(String[] args) {
		RussianRoll roll=new RussianRoll();
		System.out.println(roll.maxEnvelopes(new int[][]{{2,100},{3,200},{4,300},{5,500},{5,400},{5,250},{6,370},{6,360},{7,380}}));
	}
}
