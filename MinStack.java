package LeetCode;

import java.util.Stack;

public class MinStack{

    /** initialize your data structure here. */
    Stack<Integer> minStack;
    Stack<Integer> stack;
    public MinStack() {
        minStack=new Stack<>();
        stack=new Stack<>();
    }
    
    public void push(int x) {
        stack.push(x);
        if(minStack.isEmpty() || minStack.peek()>=x)
        minStack.push(x);
    }
    
    public void pop() {
       if(stack.size()>0)
       {
           int val=stack.pop();
           if(!minStack.isEmpty() && val==minStack.peek())minStack.pop();
       }
        
        
    }
    
    public int top() {
       return stack.isEmpty()?0:stack.peek();
    }
    
    public int getMin() {
        return minStack.isEmpty()?0:minStack.peek();
    }
}