package TreesAndGraphs;

public class SuccessorOfBST {
	public static TreeNode inorderSucc(TreeNode node){
		if(node == null) return null;
		if(node.right != null){
			return leftMost(node.right);
		}else{
			TreeNode par = node.parent;
			if(node == par.left){
				// node is the left child of par;
				return par;
			}else{
				par = node.parent;
				while(node!=null && node==par.right){
					node = par;
					par = node.parent;
				}
				return par;
			}
		}
	}
	
	private static TreeNode leftMost(TreeNode root){
		if(root==null) return null;
		while(root.left!=null){
			root = root.left;
		}
		return root;
	}
	
	public static void main(String[] args){
//		TreeNode n0 = new TreeNode(0);
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);
		TreeNode n7 = new TreeNode(7);
		TreeNode n8 = new TreeNode(8);
		TreeNode n9 = new TreeNode(9);
		TreeNode n10 = new TreeNode(10);
		
//		n0.left = n1;
//		n0.right = n2;
//		n1.left = n3;
//		n1.right = n4;
//		n2.left = n5;
//		n2.right = n6;
		
		n10.left = n6;
		n6.parent = n10;
		n6.left = n3;
		n6.right = n8;
		n3.parent = n6;
		n8.parent = n6;
		n3.left = n2;
		n3.right = n5;
		n2.parent = n3;
		n5.parent = n3;
		n2.left = n1;
		n1.parent = n2;
		n5.left = n4;
		n4.parent = n5;
		n8.left = n7;
		n8.right = n9;
		n7.parent = n8;
		n9.parent = n8;
		
		System.out.println(inorderSucc(n9));
	}
}
