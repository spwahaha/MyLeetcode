
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode fakeHead = new ListNode(-1);
    	fakeHead.next = head;
    	ListNode node = fakeHead;
    	while(node.next!=null){
    		if(node.next.val == val){
    			node.next = node.next.next;
    		}else{
    			node = node.next;
    		}
    	}
    	return fakeHead.next;
    }
}
