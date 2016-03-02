package FB;

import Amazon.ListNode;

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode next = head.next;
        ListNode root = reverseList(next);
        next.next = head;
        head.next=  null;
        return root;
    }
}
