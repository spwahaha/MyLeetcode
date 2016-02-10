
public class Palindrome_Linked_List {
    static ListNode first;
    public static boolean isPalindrome(ListNode head) {
        // Write your code here
        first = head;
        return helper(head);
    }
    
    private static boolean helper(ListNode head){
        if(head == null){
            return true;
        }
        boolean isPal = isPalindrome(head.next);
        if(!isPal) return false;
        isPal = (first.val == head.val);
        first = first.next;
        return isPal;
    }
    
    public static void main(String[] args){
    	int[] nums = {1,2,2,1};
    	ListNode[] lists = new ListNode[nums.length];
    	for(int i = 0; i < nums.length - 1; i++){
    		lists[i] = new ListNode(nums[i]);
    	}
    	
    	for(int i = 0; i < nums.length - 1; i++){
    		lists[i].next = lists[i + 1];
    	}
    	System.out.println(isPalindrome(lists[0]));
    }
}
