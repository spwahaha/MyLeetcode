import java.util.LinkedList;
import java.util.Queue;


public class Codec {
	
	  public static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	 }
	 
    // Encodes a tree to a single string.
	// DFS to get serialize the tree
    public String serialize(TreeNode root) {
    	StringBuilder sb = new StringBuilder();
    	if(root==null) return sb.toString();
    	Queue<TreeNode> q = new LinkedList<TreeNode>();
    	q.offer(root);
    	sb.append(root.val);
    	while(!q.isEmpty()){
    		int len = q.size();
    		
    		for(int i = 0; i < len; i++){
    			TreeNode node = q.poll();
    			if(node.left!=null){
    				q.offer(node.left);
    				sb.append(","+node.left.val);
    			}else{
    				sb.append(",null");
    			}
    			
    			if(node.right!=null){
    				q.offer(node.right);
    				sb.append(","+node.right.val);
    			}else{
    				sb.append(",null");
    			}
    		}
    	}
		return sb.toString();
        
    }

    // Decodes your encoded data to tree.
    // bfs to deserialize the tree
    // if str != "null", new TreeNode
    public TreeNode deserialize(String data) {
    	if(data == null || data.equals("")) return null;
		String[] str = data.split(",");
		int i = 0;
		int j = 1;
		TreeNode head = new TreeNode(Integer.parseInt(str[i]));
//		TreeNode node = head;
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.offer(head);
		while(!q.isEmpty()){
			TreeNode node = q.poll(); 
			if(!str[j].equals("null")){
				node.left = new TreeNode(Integer.parseInt(str[j]));
				q.offer(node.left);
			}
			j++;
			if(!str[j].equals("null")){
				node.right = new TreeNode(Integer.parseInt(str[j]));
				q.offer(node.right);
			}
			j++;
		}
        return head;
    }
    
    public static void main(String[] args){
    	Codec co = new Codec();
		TreeNode n1 = new TreeNode(1);
		TreeNode n3 = new TreeNode(3);
		TreeNode n2 = new TreeNode(2);
		TreeNode n6 = new TreeNode(6);
		TreeNode n5 = new TreeNode(5);
		TreeNode n4 = new TreeNode(4);
		TreeNode n7 = new TreeNode(7);
		TreeNode n8 = null;
//		n4.left = n1;
//		n4.right = n5;
//		n2.left = n1;
		n2.right = n3;
		n5.right = n6;
		n1.right = n2;
		String str1 = co.serialize(n4);
		System.out.println(str1);
		TreeNode res = co.deserialize(str1);
		System.out.println("11");
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));