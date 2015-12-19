package LinkedLists;

public class LoopDetection {
	public static ListNode findBeginning(ListNode head){
		ListNode fast = head;
		ListNode slow = head;
		
		while(fast!=null && fast.next !=null){
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast)
				break;
		}
		// detect for cycle
		if(fast == null || fast.next == null){
			return null;
		}
		
		fast = head;
		while(fast!=slow){
			fast = fast.next;
			slow = slow.next;
		}
		
		return fast;
	}
}
