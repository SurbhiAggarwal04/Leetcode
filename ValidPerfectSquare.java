package LeetCode;
public class ValidPerfectSquare {
	public static boolean isPerfectSquare(int num) {
        long L = 1, R = (num >> 1) + 1;
        System.out.println("L:"+L+" R:"+R);
		while (L <= R) {
			System.out.println("L:"+L+" R:"+R);
			long  m = L + ((R - L) >> 1);
			System.out.println("m:"+m);
			long  mul = m * m;
			if (mul == num) return true;
			else if (mul > num) R = m - 1;
			else L = m + 1;
		}
		return false;
    }
	public static double sqrt(int a)
	{
		if (a < 0)
			throw new IllegalArgumentException();
 
		double max = a;
		double min = 0.0;
		Double result = null;
		Double estimate = null;
 
		while(estimate == null || Math.abs(estimate) > .001)
		{
			result = (max + min)/2;
 
			estimate = result* result - a;
 
			if(estimate > 0)
				max = result;
			else
				min = result;
		}
 
		return result;
	}

public static void main(String[] args) {
	isPerfectSquare(121);
}
}
