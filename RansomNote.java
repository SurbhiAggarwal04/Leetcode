package LeetCode;

public class RansomNote {
	   public static boolean canConstruct(String ransomNote, String magazine) {
	        System.out.println(ransomNote+" "+magazine);
	        if(ransomNote.length()==0)return true;
	        if((ransomNote.length()>0 && magazine.length()==0))return false;
	        int index=magazine.indexOf(ransomNote.charAt(0));
	        if(index==-1)return false;
	        return canConstruct(ransomNote.substring(1), magazine.substring(0,index)+magazine.substring(index+1));
	        
	    }
	   public static void main(String[] args) {
		System.out.println(canConstruct("a", "b"));
		System.out.println(canConstruct("aa", "ab"));
		System.out.println(canConstruct("aa", "aab"));
	}
}
