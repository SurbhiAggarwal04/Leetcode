package LeetCode;

public class LongestCommonPrefixInAnArrayOfStrings {
	 public String longestCommonPrefix(String[] strs) {
         String longestPrefix = "";
   if(strs.length>0){
       longestPrefix = strs[0];
   }
   for(int i=1; i<strs.length; i++){
       String analyzing = strs[i];
       int j=0;
       for(; j<Math.min(longestPrefix.length(), strs[i].length()); j++){
           if(longestPrefix.charAt(j) != analyzing.charAt(j)){
               break;
           }
       }
       longestPrefix = strs[i].substring(0, j);
   }
   return longestPrefix;
   }
	 //Vertical Scanning
	 public String longestCommonPrefix1(String[] strs) {
		    if (strs == null || strs.length == 0) return "";
		    for (int i = 0; i < strs[0].length() ; i++){
		        char c = strs[0].charAt(i);
		        for (int j = 1; j < strs.length; j ++) {
		            if (i == strs[j].length() || strs[j].charAt(i) != c)
		                return strs[0].substring(0, i);             
		        }
		    }
		    return strs[0];
		}
	 
	 
	 //binary Search
	 public String longestCommonPrefix2(String[] strs) {
		    if (strs == null || strs.length == 0) return "";    
		        return longestCommonPrefix(strs, 0 , strs.length - 1);
		}

		private String longestCommonPrefix(String[] strs, int l, int r) {
		    if (l == r) {
		        return strs[l];
		    }
		    else {
		        int mid = (l + r)/2;
		        String lcpLeft =   longestCommonPrefix(strs, l , mid);
		        String lcpRight =  longestCommonPrefix(strs, mid + 1,r);
		        return commonPrefix(lcpLeft, lcpRight);
		   }
		}

		String commonPrefix(String left,String right) {
		    int min = Math.min(left.length(), right.length());       
		    for (int i = 0; i < min; i++) {
		        if ( left.charAt(i) != right.charAt(i) )
		            return left.substring(0, i);
		    }
		    return left.substring(0, min);
		}
		
		//Using Trie
}
