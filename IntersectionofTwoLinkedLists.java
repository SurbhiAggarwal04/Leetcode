package LeetCode;

import java.util.Stack;
/*
 * A:          a1 → a2
                   ↘
                     c1 → c2 → c3
                   ↗            
B:     b1 → b2 → b3

1. Using stack
2. Using moving the bigger list d steps ahead which is the difference in length in two lists.
 */
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
