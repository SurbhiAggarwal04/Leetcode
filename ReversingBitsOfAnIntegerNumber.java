package LeetCode;

public class ReversingBitsOfAnIntegerNumber {
    public int reverseBits(int n) {
        int result=0;
        int mask=1;
       // System.out.println(Integer.toBinaryString(n));
        for(int i=0;i<=31;i++)
        {
            //System.out.println("mask"+Integer.toBinaryString(n&mask));
            if((n&mask)!=0)result+=1;
            if(i!=31)result<<=1;
            //System.out.println(result);
            mask<<=1;
            //System.out.println(Integer.toBinaryString(mask));
        }
        return result;
     }
}
