package Amazon;

public class AddGreater {
	static int sum = 0;
	public static void addGreater(TreeNode root){
		if(root == null){
			return;
		}
		addGreater(root.right);
		sum += root.val;
		root.val = sum;
		addGreater(root.left);
	}
	
	
	
	public static void main(String[] args){
		TreeNode[] nodes = new TreeNode[5];
		for(int i = 1; i <= 5; i++){
			nodes[i - 1] = new TreeNode(i); 
		}
		nodes[2].left = nodes[0];
		nodes[2].right = nodes[4];
		nodes[0].right = nodes[1];
		nodes[4].left = nodes[3];
		addGreater(nodes[2]);
		System.out.print("qw");
	}
}
