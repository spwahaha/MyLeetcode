import java.util.ArrayList;
import java.util.List;

public class Solution {
	
	
	public static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	}
	 
    public static int countNodes(TreeNode root) {
    	if(root==null) return 0;
    	int l = heightLeft(root);
    	int r = heightRight(root);
    	if(l == r)
    		return (1<<l) -1;
    	else{
    		return countNodes(root.left) + countNodes(root.right) + 1;
    	}

    }
    
    private static int heightRight(TreeNode root) {
		// TODO Auto-generated method stub
    	int d = 0;
    	while(root!=null){
    		d++;
    		root = root.right;
    	}
		return d;
	}

	private static int heightLeft(TreeNode root){
    	int d = 0;
    	while(root!=null){
    		d++;
    		root = root.left;
    	}
    	return d;
    }
    /*
    private static void CountNode(TreeNode node, int h){
    	if(h==1){
    		count++;
    		return;
    	}
    	if(node.left!=null)
    		CountNode(node.left, h-1);
    	if(node.right!=null)
    		CountNode(node.right,h-1);
    }
    */
    
	public static void main(String[] args){
		TreeNode n1 = new TreeNode(1);
		TreeNode n3 = new TreeNode(3);
		TreeNode n2 = new TreeNode(2);
		TreeNode n6 = new TreeNode(6);
		TreeNode n5 = new TreeNode(5);
		TreeNode n4 = new TreeNode(4);
		TreeNode n7 = new TreeNode(7);
		n4.left = n2;
		n4.right = n5;
		n2.left = n1;
		n2.right = n3;
		n5.left = n6;
//		n1.left = n7;
		
		System.out.println(countNodes(n4));
//		System.out.print(1<<2);
	}
}