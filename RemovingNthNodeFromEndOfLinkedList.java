package LeetCode;

public class RemovingNthNodeFromEndOfLinkedList {
	public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode current=head;
        int i=1;
        while(i<n && current!=null)
        {
             current=current.next;
             i++;
        }
        
         
        ListNode newCurrent=head;
        ListNode previous=null;
        while(current.next!=null)
        {
            previous=newCurrent;
            newCurrent=newCurrent.next;
            current=current.next;
        }
        if(previous==null)return head.next;
        previous.next=newCurrent.next;
        return head;
    }
}
