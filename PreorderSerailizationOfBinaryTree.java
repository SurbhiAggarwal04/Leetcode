package LeetCode;

import java.util.Stack;

public class PreorderSerailizationOfBinaryTree {
    public boolean isValidSerialization(String preorder) {
        Stack<String> stack=new Stack<>();
        String preorderArr[]=preorder.split(",");
        int i=0;
        while(i<preorderArr.length)
        {
            stack.push(preorderArr[i]);
            i++;
       
        System.out.println(stack.size());
       while(stack.size()>=3 && stack.get(stack.size()-1).equals("#") && stack.get(stack.size()-2).equals("#") && !stack.get(stack.size()-3).equals("#"))
       {
          
               stack.pop();
               stack.pop();
               stack.pop();
               stack.push("#");
           
       }
    }
       if(stack.size()==1 && stack.peek().equals("#"))
       return true;
       else return false;
       
    }
}