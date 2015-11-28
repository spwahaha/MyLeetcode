import java.util.ArrayList;

public class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head ==null) return true;
        ArrayList<Integer> ar = new ArrayList<Integer>();
    	ListNode node = head;
    	while(node!=null){
    		ar.add(node.val);
    		node = node.next;
    	}
    	for(int i=0;i<ar.size()/2;i++){
    		if(!ar.get(i).equals(ar.get(ar.size()-1-i))){
    			return false;
    		}
    	}
    	return true;
    }
    
}
