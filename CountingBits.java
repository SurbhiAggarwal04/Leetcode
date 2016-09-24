package LeetCode;

/*
 * Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.

Example:

For num = 5 you should return [0,1,1,2,1,2].
 */
public class CountingBits {
	public int[] countBits(int num) {
        int[] result=new int[num+1];
        if(num<0)return result;
        result[0]=0;
        int powIndex=0;
        int i=1;
        int previous=0;
        while(i<=num)
        {
            if(i==Math.pow(2,powIndex))
            {
                result[i]=1;
                powIndex++;
                previous=1;
               
               
            }
            else
            {
               result[i]=result[previous]+1;
               previous++;
            }
            
            i++;
        }
        return result;
        
    }
}
