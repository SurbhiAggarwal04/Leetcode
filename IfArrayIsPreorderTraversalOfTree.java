package LeetCode;

import java.util.Stack;

public class IfArrayIsPreorderTraversalOfTree {
	public static void main(String[] args) {
		//int pre[] = new int[] { 40, 30, 35, 80, 100 }; //true
		 int pre[] = {2, 4, 1}; //false
		// int pre[] = {2, 4, 3}; //true
		 //int pre[] = {40, 30, 35, 20, 80, 100}; //false
		System.out.println(check(pre, 0, pre.length - 1, Integer.MIN_VALUE,
				Integer.MAX_VALUE));
		System.out.println(check1(pre));

	}

	public static boolean check(int[] pre, int index, int end, int min, int max) {
		if(index>end)return true;
		if(index==end && pre[index]>=min && pre[index]<=max)return true;
		//System.out.println(pre[index]+" "+min+" "+max);
		if (pre[index] < min || pre[index] > max)
			return false;
		int j = index + 1;
		while (j <= end && pre[j] < pre[index]) {
			j++;
		}
        //System.out.println("max "+pre[j]);
		return check(pre, index + 1, j - 1, min, pre[index])
				&& check(pre, j, end, pre[index], max);

	}
	public static boolean check1(int[] pre)
	{
		Stack<Integer> stack=new Stack<Integer>();
		int root=Integer.MIN_VALUE;
		for(int i=0;i<pre.length;i++)
		{
			if(pre[i]<root)return false;
			while(!stack.isEmpty() && pre[i]>stack.peek())
			{
				root=stack.pop();
			}
			stack.push(pre[i]);
		}
		return true;
	}
}
