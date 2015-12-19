
public class Reverse_Nodes_in_kGroup {
	/**
	 * Analyze is critical important
	 * divide list into group -> reverse each group -> connect them
	 * for example:
	 * 		1		2		3|	4		5		6|	7
	 * pre  post	   		kth	ppost
	 * ppost = kth.next
	 * pre.next = reverse(post)
	 * pre = post(after reverse, 1 is and the end of 1,2,3-> 3,2,1)
	 * post.next = ppost (connect with the later part)
	 * post = ppost
	 * @param head the head of the linked list
	 * @param k reverse with the group of k
	 * @return
	 */
	public static ListNode reverseKGroup(ListNode head, int k){
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
        ListNode pre = dummy;
        ListNode post = pre.next;
        ListNode kth = getKthNode(dummy.next,k);
        if(kth == null) return dummy.next;
        ListNode ppost = kth.next;
        while(kth!=null){
            ppost = kth.next;
            kth.next = null;
            pre.next = reverse(post);
            pre = post;
            post.next = ppost;
            post = ppost;
            kth = getKthNode(ppost, k);
        }
		return dummy.next;
	}
	
    
    private static ListNode getKthNode(ListNode node,int k){
        for(int i = 0; i < k-1; i++){
            if(node == null) return null;
            node = node.next;
        }
        return node;
    }
    
    private static ListNode reverse(ListNode head){
    	if(head == null || head.next == null){
    		return head;
    	}
    	
    	ListNode p = head.next;
    	ListNode n = reverse(head.next);
    	p.next = head;
    	head.next = null;
    	
    	return n;
    }
    
	public static void main(String[] args){
		ListNode[] nodes = new ListNode[7];
		nodes[0] = new ListNode(3);
		nodes[1] = new ListNode(3);
		nodes[2] = new ListNode(8);
		nodes[3] = new ListNode(5);
		nodes[4] = new ListNode(9);
		nodes[5] = new ListNode(2);
		nodes[6] = new ListNode(1);
//		nodes[0].next = nodes[1];
		for(int i = 0;i < nodes.length-1; i++){
			nodes[i].next = nodes[i+1];
		}
		ListNode head = reverseKGroup(nodes[0], 3);
		while(head != null){
			System.out.print(head.val);
			head = head.next;
		}

	}
    
}
