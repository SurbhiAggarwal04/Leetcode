package LeetCode;

public class TrailingZeroesInFactorial {
	 public static int trailingZeroes(int n) {
	        int count=0;
	        int i=5;
	        while(i<=n)
	        {
	            System.out.println(n/i);
	            count+=n/i;
	            i*=5;
	        }
	        return count;
	        
	    }
	 public static void main(String[] args) {
		System.out.println(trailingZeroes(100));
	}
}
