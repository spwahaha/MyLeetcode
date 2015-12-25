package LinkedLists;

import LinkedLists.RemoveDups.ListNode;

public class KthToLast {
	public static class ListNode {
	     int val;
	     ListNode next;
	     ListNode(int x) { val = x; }
	 }
	
	public static class Index{
		public int index = 0;
	}
	 
	 //recursive use another class to pass reference and pass back the Nth last
	 public static ListNode kthLast(ListNode head, int k){
		 Index ind = new Index();
		 return getKthLast(head, k, ind);
	 }
	 
	 private static ListNode getKthLast(ListNode head, int k, Index ind){
		 if(head == null){
			 return null;
		 }
		 ListNode node = getKthLast(head.next, k, ind);
		 ind.index ++;
		 if(ind.index==k){
			 return head;
		 }
		 return node;
	 }
	 
	 private static ListNode kthLast1(ListNode head, int k){
		 ListNode runner = head;
		 for(int i = 0; i < k-1; i++){
			 if(runner == null) return null;
			 runner = runner.next;
		 }
		 ListNode cur = head;
		 while(runner.next!=null){
			 cur = cur.next;
			 runner = runner.next;
		 }
		 return cur;
	 }
	 
	 
	 public static void main(String[] args){
//		 ListNode head = new ListNode(0);
		 ListNode[] nodes = new ListNode[9];
		 for(int i = 0; i < nodes.length; i++){
			 nodes[i] = new ListNode(i);
		 }
		 
		 for(int i = 0; i < nodes.length - 1; i++){
			 nodes[i].next = nodes[i+1];
		 }
		 
		 ListNode node = nodes[0];
		 while(node!=null){
			System.out.print(node.val);
			node = node.next;
		 }
		 System.out.println();
		 System.out.println(kthLast1(nodes[0],2).val);
//		 while(node!=null){
//			System.out.print(node.val);
//			node = node.next;
//		 }
		 
	 }
}