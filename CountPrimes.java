package LeetCode;

import java.util.Arrays;

public class CountPrimes {
	 public int countPrimes(int n) {
	        boolean count[]=new boolean[n];
	        System.out.println(count.length);
	        Arrays.fill(count,true);
	        int nonPrimes=1;
	        for(int i=2;i*i<n;i++)
	        {
	            if(count[i])
	            {
	            int j=i*i;
	            while(j<n)
	            {
	                if(count[j])
	                {
	                nonPrimes++;
	                System.out.println("j:"+j);
	                count[j]=false;
	                }
	                j+=i;
	            }
	            }
	        }
	        if(nonPrimes<n-1)
	        return n-nonPrimes-1;
	        else return 0;
	    }
}
