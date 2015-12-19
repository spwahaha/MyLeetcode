package LinkedLists;

import java.util.HashSet;

public class RemoveDups {
	
//	  Definition for singly-linked list.
	public static class ListNode {
	     int val;
	     ListNode next;
	     ListNode(int x) { val = x; }
	 }
	 
	 public static void removeDup(ListNode head){
		ListNode node = head;
		if(node == null) return;
		HashSet<Integer> set = new HashSet<Integer>();
		set.add(node.val);
		while(node.next!=null){
			if(set.contains(node.next.val)){
				node.next = node.next.next;
			}else{
				set.add(node.next.val);
				node = node.next;
			}
		}
//		return head;
	 }
	 // use dummy node
	  public static void removeDup1(ListNode head){
		  ListNode pre = null;
		  ListNode node = head;
		  HashSet<Integer> set = new HashSet<Integer>();
		  while(node!=null){
			  if(set.contains(node.val)){
				  pre.next = node.next;
			  }else{
				  set.add(node.val);
				  pre = node;
			  }
			  node = node.next;
		  }
	  }
	  
	  //with O(1) space but with O(n^2) time
	  public static void removeDup2(ListNode head){
		  ListNode node = head;
		  while(node!=null){
			  ListNode runner = node.next;
			  ListNode pre = node;
			  while(runner != null){
				  if(runner.val != node.val){
					pre = runner;
					runner = runner.next;
				  }else{
					runner = runner.next;
					pre.next = runner;
				  }
			  }
			  node = node.next;
		  }
	  }
	 
	 
	 
	 public static void main(String[] args){
//		 ListNode head = new ListNode(0);
		 ListNode[] nodes = new ListNode[9];
		 for(int i = 0; i < nodes.length; i++){
			 nodes[i] = new ListNode(i);
		 }
//		 head.next = nodes[0];
		 nodes[1].val = 0;
		 for(int i = 0; i < nodes.length - 1; i++){
			 nodes[i].next = nodes[i+1];
		 }

		 
		 ListNode node = nodes[0];
		 while(node!=null){
			System.out.print(node.val);
			node = node.next;
		 }
		 System.out.println();
		 removeDup(nodes[0]);
		 node = nodes[0];
		 while(node!=null){
			System.out.print(node.val);
			node = node.next;
		 }
		 
	 }
	 
}
