import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;



public class Solution {
	
		  public static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }

      	
	    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        	List<List<Integer>> list = new ArrayList<List<Integer>>();
    		List<Integer> li = new ArrayList<Integer>();
        	if(root==null) return list;
        	TreeNode p = root;
        	int count=1;
        	Queue<TreeNode> queue = new LinkedList<TreeNode>();
        	queue.offer(root);
        	// typical level order traversal, uses queue
        	while(!queue.isEmpty()){
        		p = queue.poll();
        		li.add(p.val);
        		if(p.left!=null) queue.offer(p.left);
        		if(p.right!=null) queue.offer(p.right);
        		count--;
        		if(count==0){
        			list.add(new ArrayList<Integer>(li));
        			li.clear();
        			count = queue.size();
        		}
        	}
        	
          	List<List<Integer>> list2 = new ArrayList<List<Integer>>();
          	for(int i = list.size()-1;i>=0;i--){
          		list2.add(list.get(i));
          	}
	        return list2;
		}
	    
		public static void main(String[] args){
			TreeNode n1 = new TreeNode(1);
			TreeNode n3 = new TreeNode(3);
			TreeNode n2 = new TreeNode(2);
			TreeNode n6 = new TreeNode(6);
			TreeNode n5 = new TreeNode(5);
			TreeNode n4 = new TreeNode(4);
			n4.left = n2;
			n4.right = n5;
			n2.left = n1;
//			n2.right = n3;
			n5.left = n3;
			n5.right = n6;

			System.out.println(levelOrderBottom(n4));
		}
}
