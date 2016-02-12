package Amazon;

public class PalindromeLinkedList {
	public boolean isPalindrome(ListNode head) {
		if(head == null || head.next == null){
			return true;
		}
		ListNode mid = findMid(head);
		ListNode l1 = head;
		ListNode l2 = reverse(mid.next);
		while(l1 != null && l2 != null){
			if(l1.val != l2.val){
				return false;
			}
			l1 = l1.next;
			l2 = l2.next;
		}
		return true;
	}
	
	private ListNode findMid(ListNode head){
		if(head == null || head.next == null){
			return head;
		}
		ListNode fast = head.next;
		ListNode slow = head;
		while(fast != null && fast.next != null){
			fast = fast.next.next;
			slow = slow.next;
		}
		return slow;
	}
	
	private ListNode reverse(ListNode head){
		if(head == null || head.next == null){
			return head;
		}
		ListNode pre = head;
		ListNode cur = head.next;
		pre.next = null;
		while(cur != null){
			ListNode next = cur.next;
			cur.next = pre;
			pre = cur;
			cur = next;
		}
		return pre;
	}
	
	ListNode start;
	public boolean isPalindrome1(ListNode head) {
		if(head == null || head.next == null){
			return true;
		}
		start = head;
		return helper(head);
	}
	
	private boolean helper(ListNode head){
		if(head == null){
			return true;
		}
		boolean backPali = helper(head.next);
		if(!backPali){
			return false;
		}
		
		if(start.val != head.val){
			return false;
		}
		start = start.next;
		return true;
		
	}

	
}
