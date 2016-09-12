package LeetCode;
public class MaxSumRectangleInAMatrix {
    public static int[] findMaxSum(int [] n,int k)
    {
        int currentSum=0,prevSum=0;
        int start=0;
        int result[]=new int[]{Integer.MIN_VALUE,0,-1};
        for(int i=0;i<n.length;i++)
        {
            /*if(currentSum+n[i]<n[i] && currentSum+n[i]>currentSum)
	     	{
			start=i;
			currentSum=n[i];
	    	}
	    	else
	    	{
			currentSum+=n[i];
			
	    	}*/
	    	currentSum+=n[i];
	    	if (currentSum < 0) {
                currentSum = 0;
                start = i + 1;
            } else if (currentSum > result[0] && currentSum<=k) {
                result[0] = currentSum;
                result[1] = start;
                result[2] = i;
            }
           /*if(currentSum>result[0] && currentSum<=k)
            {
                result[0]=currentSum;
                result[1]=start;
                result[2]=i;
            }*/
        }
        if (result[2] == -1) {
            result[0] = Integer.MIN_VALUE;
            for (int i = 0; i < n.length; i++) {
                if (n[i] > result[0] && n[i]<=k) {
                    result[0] = n[i];
                    result[1] = i;
                    result[2] = i;
                }
            }
        }
        System.out.println(result[0]);
        return result;
    }
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int max=Integer.MIN_VALUE;
        int columns=matrix[0].length;
        int rows=matrix.length;
        int leftCol=0,rightCol=0,startRow=0,endRow=0;
        for(int i=0;i<columns;i++)
        {
             int temp[]=new int[rows];
            for(int j=i;j<columns;j++)
            {
               
                for(int l=0;l<rows;l++)
                {
                    temp[l]+=matrix[l][j];
                }
                int[] result=findMaxSum(temp,k);
                if(result[0]>max)
                {
                    max=result[0];
                    leftCol=i;
                    rightCol=j;
                    startRow=result[1];
                    endRow=result[2];
                }
            }
        }
        return max;
        
    }
}

