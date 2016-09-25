package LeetCode;
/*
 * Ugly Numbers
Ugly numbers are numbers whose only prime factors are 2, 3 or 5. The sequence
1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15, …
 */
public class NumberIsUgly {
    public boolean isUgly(int num) {
        if(num==0)return false;
      while(num%2==0)
      {
          num=num/2;
      }
      while(num%3==0)
      {
          num=num/3;
      }
      while(num%5==0)
      {
          num=num/5;
      }
        if(num==1)return true;
        return false;
    }
}