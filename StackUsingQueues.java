package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueues {
	   Queue<Integer> q1=new LinkedList<>();
	    Queue<Integer> q2=new LinkedList<>();
	    public void push(int x) {
	        q1.offer(x);
	    }

	    // Removes the element on top of the stack.
	    public void pop() {
	        System.out.println(q1+" "+q2);
	        int size=q1.size();
	        for(int i=0;i<size-1;i++)
	        {
	            q2.offer(q1.remove());
	        }
	        System.out.println(q1+" "+q2);
	        int val=q1.remove();
	        q1=q2;
	        q2=new LinkedList<>();
	       // return val;
	    }

	    // Get the top element.
	    public int top() {
	         int size=q1.size();
	            for(int i=0;i<size-1;i++)
	        {
	            q2.offer(q1.remove());
	        }
	        int val=q1.remove();
	        q2.offer(val);
	        q1=q2;
	        q2=new LinkedList<>();
	        return val;
	    }

	    // Return whether the stack is empty.
	    public boolean empty() {
	        return q1.isEmpty() && q2.isEmpty();
	    }
}
