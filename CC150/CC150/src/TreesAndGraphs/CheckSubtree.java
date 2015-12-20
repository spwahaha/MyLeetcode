package TreesAndGraphs;

public class CheckSubtree {
	
	/**
	 * Compare by traversal string
	 * @param tree1
	 * @param tree2
	 * @return
	 */
	public static boolean containsTree(TreeNode tree1, TreeNode tree2){
		StringBuilder sb1 = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		traversal(tree1,sb1);
		traversal(tree2,sb2);
		return sb1.indexOf(sb2.toString())!=-1;
	}
	
	private static void traversal(TreeNode root, StringBuilder sb){
		if(root == null){
			sb.append("x");
			return;
		}
		
		sb.append(""+root.val);
		traversal(root.left, sb);
		traversal(root.right, sb);
	}
	
	
	public static boolean subTree(TreeNode t1, TreeNode t2){
		if(t1==null) return false;
		if(t2==null) return true;
		
		if(t1.val == t2.val && match(t1,t2)){
			return true;
		}
		
		return subTree(t1.left, t2) || subTree(t1.right, t2);
	}
	
	private static boolean match(TreeNode t1, TreeNode t2){
		if(t1 == null && t2 == null) return true;
		if(t1 == null || t2 == null) return false;
		if(t1.val != t2.val) return false;
		return match(t1.left, t2.left) && match(t1.right, t2.right);
	}
	
	
}
