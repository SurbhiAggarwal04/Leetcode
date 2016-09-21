package LeetCode;

public class CoinChange {
	public static int total(int n, int[] v, int i) {
		if (n < 0) {
			return 0;
		}
		if (n == 0) {
			return 1;
		}
		// means coins over and n>0 so no solution
		if (i == v.length && n > 0) {
			return 0;
		}
		return total(n - v[i], v, i) + total(n, v, i + 1);
	}
	public static int dynamic(int[] v, int amount) {
		int[][] solution = new int[v.length + 1][amount + 1];

		// if amount=0 then just return empty set to make the change
		for (int i = 0; i <= v.length; i++) {
			solution[i][0] = 1;
		}

		// if no coins given, 0 ways to change the amount
		for (int i = 1; i <= amount; i++) {
			solution[0][i] = 0;
		}

		// now fill rest of the matrix.

		for (int i = 1; i <= v.length; i++) {
			for (int j = 1; j <= amount; j++) {
				// check if the coin value is less than the amount needed
				if (v[i - 1] <= j) {
					// reduce the amount by coin value and
					// use the subproblem solution (amount-v[i]) and
					// add the solution from the top to it
					solution[i][j] = solution[i - 1][j]
							+ solution[i][j - v[i - 1]];
				} else {
					// just copy the value from the top
					solution[i][j] = solution[i - 1][j];
				}
			}
		}
		return solution[v.length][amount];
	}
	public static int combinations(int n,int m)
	{
		if(n < 0)
			return 0;
 
		if(n == 0)
			return 1;
 
		int combinations = 0;
 
		if(m == 100)
			combinations+= combinations(n-100,100);
		if(m >= 50)
			combinations+= combinations(n-50,50);
		if(m >= 25)
			combinations+= combinations(n-25,25);
		if(m >= 10)
			combinations+= combinations(n-10,10);
		if(m >= 5)
			combinations+= combinations(n-5,5);
 
		combinations+= combinations(n-1,1);
 
		return combinations;
	}

public static void main(String[] args) {
	int coins[]=new int[]{1,5,10,25,50,100};
	System.out.println(total(15, coins, 0));
	System.out.println(dynamic(coins,15));
	System.out.println(combinations(15, 100));
}
}
