package LinkedLists;

import java.util.Stack;

public class Palindrome {
	
	
	static class Result{
		public ListNode node;
		public boolean result;
		public Result(ListNode node, boolean n){
			this.node = node;
			this.result = n;
		}
	}
	
	public static boolean isPalindrome(ListNode head){
		ListNode slow = head;
		ListNode fast = head;
		Stack<Integer> stack = new Stack<Integer>();
		while(fast!=null && fast.next!=null){
			stack.push(slow.val);
			slow = slow.next;
			fast = fast.next.next;
		}
		
		if(fast!=null){
			slow = slow.next;
		}
		while(slow!=null){
			if(!stack.pop().equals(slow.val)){
				return false;
			}
			slow = slow.next;
		}
		return true;
	}
	
	public static boolean isPalindrome2(ListNode head){
		int n = length(head);
		Result res = isPalRecur(head,n);
		return res.result;
	}
	
	private static int length(ListNode head){
		int n = 0;
		ListNode node = head;
		while(node!=null){
			n++;
			node = node.next;
		}
		return n;
	}
	
	private static Result isPalRecur(ListNode head, int length){
		if(length == 0){
			return new Result(head, true);
		}
		if(length == 1){
			return new Result(head.next, true);
		}
		
		Result res = isPalRecur(head.next, length-2);
		
		if(!res.result || res.node == null){
			return res;
		}
		if(res.node.val != head.val){
			res.result = false;
		}
		
		res.node = res.node.next;
		return res;
		
	}
	
	
	
	
	private static ListNode reverseList(ListNode head){
		if(head == null || head.next == null){
			return head;
		}
		ListNode p = head.next;
		ListNode n = reverseList(p);
		p.next = head;
		head.next = null;
		return n;	
	}
}
