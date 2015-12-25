package hard;

public class TreeNode {
	TreeNode left;
	TreeNode right;
	TreeNode parent;
	int val;
	public TreeNode(int val){
		this.val = val;
	}
	
	public String toString(){
		return this.val+"  ";
	}
}
