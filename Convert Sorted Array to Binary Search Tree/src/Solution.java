

public class Solution {
	
	
	  public static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	 
	
    public TreeNode sortedArrayToBST(int[] nums) {
    	if(nums==null||nums.length==0) return null;
        return helper(nums,0,nums.length-1);
    }
    
    private TreeNode helper(int[] nums, int i, int j) {
		// TODO Auto-generated method stub
		if(!(i<j)) return null;
    	int mid = i+(j-i)/2;
    	TreeNode node = new TreeNode(nums[mid]);
    	node.left = helper(nums,i,mid-1);
    	node.right = helper(nums,mid+1,j);
    	return node;
		
	}

	public static void insert(TreeNode root, int num){
    	if(num==root.val) return;
    	if(num>root.val) {
    		if(root.right!=null)		insert(root.right,num);
    		else root.right = new TreeNode(num);
    	}else{
    		if(root.left!=null)	insert(root.left,num);
    		else root.left = new TreeNode(num);
    	}	
    }
    
	public static void main(String[] args){
		TreeNode n1 = new TreeNode(1);
		TreeNode n3 = new TreeNode(3);
		TreeNode n2 = new TreeNode(2);
		TreeNode n6 = new TreeNode(6);
		TreeNode n5 = new TreeNode(5);
		TreeNode n4 = new TreeNode(4);
		TreeNode n7 = new TreeNode(7);
		/*
		n4.left = n2;
		n4.right = n5;
		n2.left = n1;
		n2.right = n3;
		n5.right = n6;
//		n1.left = n7;
*/
		insert(n4,3);
		insert(n4,2);
		insert(n4,5);
		insert(n4,8);
		insert(n4,6);

		
		System.out.println(1);
	}
    
    
}