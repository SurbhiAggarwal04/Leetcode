package LeetCode;

public class isPowerof4 {
	public boolean isPowerOfFour(int num) {
	    while(num>0){
	        if(num==1){
	            return true;
	        }
	 
	        if(num%4!=0){
	            return false;
	        }else{
	            num=num/4;
	        }
	    }
	 
	    return false;
	}
	public boolean isPowerOfFourV2(int num) {
	    int count0=0;
	    int count1=0;
	 
	    while(num>0){
	        if((num&1)==1){
	            count1++;
	        }else{
	            count0++;
	        }
	 
	        num>>=1;
	    }
	 
	    return count1==1 && (count0%2==0);
	}
	public boolean isPowerOfFourV3(int num) {
		   if(num==0) return false;
		 
		   int pow = (int) (Math.log(num) / Math.log(4));
		   if(num==Math.pow(4, pow)){
		       return true;
		   }else{
		       return false;
		   }
		}
}
