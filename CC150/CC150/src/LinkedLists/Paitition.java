package LinkedLists;


public class Paitition {
	
    public static ListNode partition(ListNode head, int x) {
    	if(head == null) return head;
        ListNode newHead = head;
        ListNode tail = head;
        ListNode node = head.next;
        head.next = null;
        while(node!=null){
            ListNode next = node.next;
            if(node.val < x){
                node.next = newHead;
                newHead = node;
            }else{
                tail.next = node;
                tail = node;
                tail.next = null;
            }
            node = next;
        }
        return newHead;
    }
	
	public static void main(String[] args){
		ListNode[] nodes = new ListNode[7];
		nodes[0] = new ListNode(3);
		nodes[1] = new ListNode(3);
		nodes[2] = new ListNode(8);
		nodes[3] = new ListNode(5);
		nodes[4] = new ListNode(10);
		nodes[5] = new ListNode(2);
		nodes[6] = new ListNode(1);
		nodes[0].next = nodes[1];
		for(int i = 0;i < nodes.length-1; i++){
			nodes[i].next = nodes[i+1];
		}
		ListNode head = partition(nodes[0], 4);
		while(head != null){
			System.out.print(head.val);
			head = head.next;
		}

	}
}
