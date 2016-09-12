package LeetCode;

public class AdditionOfBinaryNumbers {
    public String addBinary(String a, String b) {
        if(a.trim().equals(""))return b;
        if(b.trim().equals(""))return a;
        
        int lengthA=a.length();
        int lengthB=b.length();
        StringBuilder sbA=new StringBuilder(a);
        StringBuilder sbB=new StringBuilder(b);
        if(lengthA<lengthB)
        {
            for(int i=0;i<lengthB-lengthA;i++)
            {
                sbA.insert(i,0);
            }
        }
         if(lengthB<lengthA)
        {
            for(int i=0;i<lengthA-lengthB;i++)
            {
                sbB.insert(i,0);
            }
        }
        int carry=0;
        StringBuilder result=new StringBuilder();
        
        int i=sbA.length()-1;
        while(i>=0)
        {
            if(sbA.charAt(i)=='1' && sbB.charAt(i)=='1')
            {
                if(carry==0)
                result.insert(0,'0');
                else
                result.insert(0,'1');
                carry=1;
            }
            else
            {
                if(sbA.charAt(i)=='0' && sbB.charAt(i)=='0')
                {
                     result.insert(0,String.valueOf(carry));
                     carry=0;
                }
                else
                {
                    if(carry==0)
                    result.insert(0,'1');
                    else
                    {
                        result.insert(0,'0');
                        carry=1;
                    }
                    
                }
                
               
            }
            i--;
        }
        if(carry!=0)
        result.insert(0,String.valueOf(carry));
        return result.toString();
        
    }
}
