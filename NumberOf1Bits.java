package LeetCode;

public class NumberOf1Bits {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
      /*int result = 0;
 
       while(n!=0){
        if(n%2==1){
            ++result;
        }
        n = n/2;
       }
 
    return result;*/
   int result = 0;
        for (int i = 0; i < 32; i++) {
            result += n & 1;
            n = n >> 1;
        }
         
        return result;
    }
}