package LinkedLists;

public class Intersection {
	
	public static ListNode findIntersection(ListNode headA, ListNode headB){
		int m = length(headA);
		int n = length(headB);
		ListNode longer = m > n? headA:headB;
		ListNode shorter = m > n? headB:headA;
		
		for(int i = 0; i < Math.abs(m-n); i++){
			longer = longer.next;
		}
		while(longer!=null & shorter !=null){
			if(longer == shorter){
				return longer;
			}
			longer = longer.next;
			shorter = shorter.next;
		}
		
		return null;
		
		
	}
	
	private static int length(ListNode head){
		int n = 0;
		while(head!=null){
			n++;
			head = head.next;
		}
		return n;
	}
}
