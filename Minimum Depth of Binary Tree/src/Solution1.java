import java.util.LinkedList;
import java.util.Queue;


public class Solution1 {
	
	
	public static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	 

    public static int minDepth(TreeNode root) {
    	// use the level order traversal, until the some node has no children
    	// the level number is the depth number
    		Queue<TreeNode> queue = new LinkedList<TreeNode>();
    		if(root==null) return 0;
    		queue.offer(root);
    		int i = 0;
    		boolean flag = false;
    		while(!queue.isEmpty()){
    			i++;
    			int k = queue.size();
    			for(int j = 0;j<k;j++){
    				TreeNode node = queue.poll();
    				if(node.left!=null) queue.offer(node.left);
    				if(node.right!=null) queue.offer(node.right);
    				if(node.left==null&&node.right==null){
    					flag = true;
    					break;
    				}
    			}
				if(flag)
					break;
    		}
    		return i;
    }
    public static void main(String[] args){
    	Solution1 sl = new Solution1();
    	TreeNode root = new TreeNode(1);
    	root.left = new TreeNode(2);
    	root.right = new TreeNode(3);
    	root.left.left = new TreeNode(2);
    	System.out.println(minDepth(root.left.left));
    }

}
