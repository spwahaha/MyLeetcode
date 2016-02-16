package Amazon;

public class AddTwoNumbers {
	
	//(2 -> 4 -> 3) + (5 -> 6 -> 4) == 7 -> 0 -> 8
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addHelper(l1, l2, 0);
    }
    
    private ListNode addHelper(ListNode l1, ListNode l2, int carry){
        if(l1 == null && l2 == null && carry == 0){
            return null;
        }
        int res = carry;
        if(l1 != null){
            res += l1.val;
            l1 = l1.next;
        }
        if(l2 != null){
            res += l2.val;
            l2 = l2.next;
        }
        
        ListNode node = new ListNode(res % 10);
        node.next = addHelper(l1, l2, res / 10);
        return node;
    }
    
	//(2 -> 4 -> 3) + (5 -> 6 -> 4) == 8 -> 0 -> 7
    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        padList(l1, l2);
        ListNode head = new ListNode(0);
        addLists(head, l1, l2);
        if(head.val == 0){
        	return head.next;
        }else{
        	return head;
        }
    }
    
    private static void padList(ListNode l1, ListNode l2){
    	int size1 = 0;
    	int size2 = 0;
    	while(l1 != null){
    		size1++;
    		l1 = l1.next;
    	}
    	
    	while(l2 != null){
    		size2++;
    		l2 = l2.next;
    	}
    	int diff = Math.abs(size1 - size2);
    	if(diff == 0) return;
    	ListNode head = new ListNode(0);
    	ListNode node = head;
    	while(diff > 1){
    		node.next = new ListNode(0);
    		node = node.next;
    		diff--;
    	}
    	
    	if(size1 - size2 > 0){
    		node.next = l2;
    		l2 = head;
    	}else{
    		node.next = l1;
    		l1 = head;
    	}
    }
    
    private static void addLists(ListNode pre, ListNode node1, ListNode node2){
    	if(node1 == null && node2 == null){
    		return;
    	}
    	
    	int sum = 0;
    	if(node1 != null){
    		sum += node1.val;
    		node1 = node1.next;
    	}
    	if(node2 != null){
    		sum += node2.val;
    		node2 = node2.next;
    	}
    	
    	pre.val += sum / 10;
    	ListNode node = new ListNode(sum % 10);
    	pre.next = node;
    	addLists(node, node1, node2);
    	pre.val += node.val / 10;
    	node.val = node.val % 10;
    	
    }
    
	public static void main(String[] args){
		ListNode[] nodes1 = new ListNode[3];
		ListNode[] nodes2 = new ListNode[3];
		nodes1[0] = new ListNode(9);
		nodes1[1] = new ListNode(9);
		nodes1[2] = new ListNode(9);
//		nodes1[3] = new ListNode(2);
		nodes2[0] = new ListNode(9);
		nodes2[1] = new ListNode(9);
		nodes2[2] = new ListNode(1);
		for(int i = 0; i < nodes1.length-1; i++){
			nodes1[i].next = nodes1[i+1];
		}
		for(int i = 0; i < nodes2.length-1; i++){
			nodes2[i].next = nodes2[i+1];
		}
		
		ListNode res = addTwoNumbers2(nodes1[0], nodes2[0]);
		while(res!=null){
			System.out.print(res.val);
			res = res.next;
		}
	}
}
