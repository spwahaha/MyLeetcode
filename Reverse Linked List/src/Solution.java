
public class Solution {
	//iteration
    public ListNode reverseList(ListNode head) {
    	if(head==null||head.next==null){
    		return head;
    	}
    	ListNode pre = head;
    	ListNode p = head.next;
    	ListNode post = p.next;
    	pre.next = null;
    	while(p !=null){
//    		pre.next = null;
    		p.next = pre;
    		
    		pre = p;
    		p = post;
    		if(post!=null){
    		  post = post.next;
    		}

    	}
    	
    	return pre;
    }
    
    // recursion 
    public ListNode reverseList2(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode p = head.next;
        ListNode n = reverseList(p);
        
        head.next = null;
        p.next = head;
        
        return n;
    }
}
