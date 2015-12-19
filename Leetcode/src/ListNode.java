
//  Definition for singly-linked list.
  public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { 
    	  val = x;
//    	  next = null;
      }
      
      public String toString(){
    	  
    	  String result =""+val;
    	  while(next!=null){
    		  result+=next.val;
    		  next = next.next;
    	  }
    	  return result;
      }
  }
 