package LeetCode;

public class IsBadVersion {
	public int firstBadVersion(int n) {
        if(n<=0)return 0;
        if(n>0 && isBadVersion(1))return 1;
        int start=1;
        int end=n;
        int badVersion=0;
        while(start<=end)
        {
            int mid=start+(end-start)/2;
            if(mid-1>0 && !isBadVersion(mid-1) && isBadVersion(mid))
            {
                badVersion=mid;
                break;
            }
            if(isBadVersion(mid))end=mid-1;
            else start=mid+1;
        }
        return badVersion;
    }
	public static boolean isBadVersion(int n)
	{
		return true;
	}
}
