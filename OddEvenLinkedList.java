package LeetCode;



  //Definition for singly-linked list.
   class OddEvenListNode {
      int val;
      OddEvenListNode next;
      OddEvenListNode(int x) { val = x; }
  }
 
public class OddEvenLinkedList {
    public OddEvenListNode oddEvenList(OddEvenListNode head) {
        if(head==null || head.next==null)return head;
        
        
        OddEvenListNode current=head,odd=head,even=head.next,evenHead=even;
        while(even!=null && even.next!=null)
        {
            odd.next=even.next;
            odd=odd.next;
            even.next=odd.next;
            even=even.next;
        }
        odd.next=evenHead;
        return head;
    }
}