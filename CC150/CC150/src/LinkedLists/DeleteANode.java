package LinkedLists;

public class DeleteANode {
	static ListNode[] nodes = new ListNode[3];
	public static void delete(ListNode node){
		if(node == null) return;
		if(node.next == null){
			node = null;
			return;
		} 
		node.val = node.next.val;
		node.next = node.next.next;
	}
	
	public static void main(String[] args){
		nodes[0] = new ListNode(0);
		nodes[1] = new ListNode(1);
		nodes[2] = new ListNode(2);
		nodes[0].next = nodes[1];
		nodes[1].next = nodes[2];
		ListNode node = nodes[0];
		while(node!=null){
			System.out.print(node.val);
			node = node.next;
		}
		
		System.out.println();
		delete(nodes[1]);
		node = nodes[0];
		while(node!=null){
			System.out.print(node.val);
			node = node.next;
		}
		
	}
}