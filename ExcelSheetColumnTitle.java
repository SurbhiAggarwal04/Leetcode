package LeetCode;

public class ExcelSheetColumnTitle {
	   public String convertToTitle(int n) {
	        if(n<=26)return Character.toString((char)(n-1+'A'));
	        StringBuilder result=new StringBuilder();
	        
	        while(n>0)
	        {
	            n--;
	            char ch=(char)(n%26+'A');
	            result.insert(0,ch);
	            n/=26;
	        }
	        return result.toString();
	    }
}
