
public class Solution {
	
	
	public static class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
	}
	 
	/**review about how to construct binary tree from inorder and preorder
	 * inorder: left, root, right
	 * preorder: root, lefr, right
	 * */
	
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        int h1 = preorder.length - 1;
        int h2 = inorder.length - 1;
        int l1 = 0;
        int l2 = 0;
        return build( preorder, l1, inorder, l2, h2);
    }



	private static TreeNode build(int[] preorder, int l1, int[] inorder, int l2, int h2) {
		// TODO Auto-generated method stub
		if(l2>h2){
			return null;
		}
		TreeNode root = new TreeNode(preorder[l1]);
		int index = -1;
		for(int i = l2; i <= h2;i++ ){
			if(inorder[i] == preorder[l1]){
				index = i;
				break;
			}
		}
		
		int leftSize = index - l2;
		root.left = build(preorder, l1+1,inorder,l2,index-1);
		root.right = build(preorder, l1+leftSize+1,  inorder,index+1,h2);
		return root;
	}
	
	public static void main(String[] args){
		int[] inorder = {15, 30, 35, 40, 45, 50, 60, 70, 72, 75, 77, 80};
		int[] preorder = {50, 30, 15, 40, 35, 45, 70, 60, 80, 75, 72, 77};
		TreeNode node = buildTree(preorder, inorder);
		System.out.print("sad");
	}
    
}