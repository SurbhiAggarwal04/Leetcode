package LeetCode;

import java.util.HashSet;
import java.util.Set;


public class HappyNumber {
    public boolean isHappy(int n) {
        int sum=0;
        Set<Integer> set=new HashSet<Integer>();
        while(!set.contains(n))
        {
            set.add(n);
            sum=0;
            while(n!=0)
            {
                sum+=(n%10)*(n%10);
                n=n/10;
            }
            n=sum;
            System.out.println(n);
            if(n==1)return true;
           // if(String.valueOf(n).length()==1 && n!=1)return false;
        }
        return false;
        
    }
}