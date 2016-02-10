
public class PalindromeList {
	static ListNode front;
	public static boolean isPalindrome(ListNode head){
		front = head;
		if(head == null || head.next == null) return true;
		return helper(head);
	}
	
	private static boolean helper(ListNode head){
		if(head.next == null){
			return head.val == front.val;
		}
		
		ListNode next = head.next;
		boolean palindrome = helper(next);
		front = front.next;
		if(!palindrome){
			return false;
		}else{
			return front.val == head.val;
		}
	} 
	
	public static void main(String[] args){
		ListNode[] nodes = new ListNode[6];
		nodes[0] = new ListNode(1);
		nodes[1] = new ListNode(2);
		nodes[2] = new ListNode(3);
		nodes[3] = new ListNode(3);
		nodes[4] = new ListNode(2);
		nodes[5] = new ListNode(1);
		for(int i = 0; i < nodes.length - 1; i++){
			nodes[i].next = nodes[i + 1];
		}
		
		System.out.println(isPalindrome(nodes[0]));
	}
	
}
