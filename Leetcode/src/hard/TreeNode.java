package hard;

public class TreeNode {
	public TreeNode left;
	public TreeNode right;
	public TreeNode parent;
	public int val;
	public TreeNode(int val){
		this.val = val;
	}
	
	public String toString(){
		return this.val+"  ";
	}
}
