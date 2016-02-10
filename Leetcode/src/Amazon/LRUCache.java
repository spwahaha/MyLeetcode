package Amazon;

import java.util.HashMap;

public class LRUCache {
	class ListNode{
		int key;
		int val;
		ListNode next;
		ListNode pre;
		
		public ListNode(int key, int val){
			this.key = key;
			this.val = val;
		}
	}
	
	int capacity;
	ListNode head;
	ListNode tail;
	HashMap<Integer, ListNode> map;
	public LRUCache(int capacity){
		this.capacity = capacity;
		head = new ListNode(-1, -1);
		tail = new ListNode(-1, -1);
		map = new HashMap<Integer, ListNode>();
		head.next = tail;
		tail.pre = head;
	}
	
	public int get(int key){
		if(!map.containsKey(key)){
			return -1;
		}else{
			ListNode cur = map.get(key);
			cur.pre.next = cur.next;
			cur.next.pre = cur.pre;
			moveToTail(cur);
			return cur.val;
		}
	}
	
	private void moveToTail(ListNode node){
		tail.pre.next = node;
		node.next = tail;
		node.pre = tail.pre;
		tail.pre = node;
	}
	
	public void set(int key, int val){
		if(get(key) != -1){
			map.get(key).val = val;
			return;
		}
		if(map.size() == this.capacity){
			map.remove(head.next.key);
			head.next = head.next.next;
			head.next.pre = head;
		}
		ListNode insert = new ListNode(key, val);
		map.put(key, insert);
		moveToTail(insert);
		
	}
	
}
