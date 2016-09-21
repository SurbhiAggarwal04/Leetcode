package LeetCode;

public class CountNumberWithUniqueDigits {
	 public int countNumbersWithUniqueDigits(int n) {
	        if(n==0)return 1;
	        if(n==1)return 10;
	        int ans=10;
	        for(int i=2;i<=n;i++)
	        {
	            int temp=9;
	            int index=9;
	            for(int j=1;j<i;j++)
	            {
	                temp*=index;
	                index--;
	            }
	            ans+=temp;
	        }
	        return ans;
	        
	    }
}
