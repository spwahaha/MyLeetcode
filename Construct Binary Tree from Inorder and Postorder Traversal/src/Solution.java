
public class Solution {
	
	
	public static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	}
	 
	
    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        int m = postorder.length-1;
		TreeNode root = build(inorder, postorder, m, 0, m);
    	return root;
    }


	private static TreeNode build(int[] inorder, int[] postorder, int postIndex, int instart, int inend) {
		if(instart>inend){
			return null;
		}
		
		TreeNode root = new TreeNode(postorder[postIndex]);
		int index=instart;
		for(int i = instart;i<=inend;i++){
			if(inorder[i] == postorder[postIndex])
				break;
			index++;
		}
		int size = inend-index;
		

		root.right = build(inorder, postorder, postIndex-1,index+1, inend);
		root.left  = build(inorder, postorder, postIndex-size-1,instart,index-1);
		
		return root;
	}
	
	public static void main(String[] args){
		int[] inorder = {15, 30, 35, 40, 45, 50, 60, 70, 72, 75, 77, 80};
		int[] postorder = {15, 35, 45, 40, 30, 60, 72, 77, 75, 80, 70, 50};
//		int[] inorder = {2,1,3};
//		int[] postorder = {2,3,1};
		TreeNode node = buildTree(inorder, postorder);
		System.out.print("sad");
	}
}