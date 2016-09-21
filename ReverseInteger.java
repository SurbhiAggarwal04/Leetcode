package LeetCode;

public class ReverseInteger {
	  public int reverse(int x) {
	        long result=0;
	        int result1=0;
	        boolean negative=false;
	        if(x<0)
	        {
	            negative=true;
	            x*=-1;
	        }
	        
	        while(x>0)
	        {
	            try
	            {
	            System.out.println("x:"+x);
	            
	            result*=10;
	             System.out.println("result:"+result);
	            result+=x%10;
	             if (result > Integer.MAX_VALUE) {return 0;}
	            result1=(int)result;
	            x/=10;
	            System.out.println(result);
	            }
	            catch(Exception e)
	            {return 0;}
	        }
	        
	        return negative?-result1:result1;
	    }
}
