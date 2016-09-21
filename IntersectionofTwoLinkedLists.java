package LeetCode;

import java.util.Stack;

public class IntersectionofTwoLinkedLists {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Stack<ListNode> stackA=new Stack<>();
        Stack<ListNode> stackB=new Stack<>();
        while(headA!=null){
            stackA.push(headA);
            headA=headA.next;
        }
        while(headB!=null){
            stackB.push(headB);
            headB=headB.next;
        }
        ListNode result=null;
        while (!stackA.isEmpty() && !stackB.isEmpty())
        {
            if(stackA.peek() == stackB.peek())
            {
                result=stackA.pop();
                stackB.pop();
            }
            else break;
        }
        return result;
        
    }
}
