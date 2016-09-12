package LeetCode;

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
