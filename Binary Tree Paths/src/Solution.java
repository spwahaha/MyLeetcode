import java.util.ArrayList;
import java.util.List;

public class Solution {
	
	  public static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	 
    public static List<String> binaryTreePaths(TreeNode root) {
    	if(root==null) return null;
        List<List<String>> res = new ArrayList<List<String>>();
        List<String> list = new ArrayList<String>();
        list.add(""+root.val);
        helper(res,list,root);
        List<String> res1 = new ArrayList<String>();
        
        for(List<String> li:res){
        	StringBuilder sb = new StringBuilder();
        	for(String ch:li){
        		sb.append("->");
        		sb.append(ch.toString());
        	}
        	sb.delete(0, 2);
        	res1.add(sb.toString());
        }
        return res1;
        
    }

	private static void helper(List<List<String>> res, List<String> list, TreeNode root) {
		// TODO Auto-generated method stub
		if(root.left==null&&root.right==null){
			res.add(new ArrayList<String>(list));
			return;
		}
		if(root.left!=null){
			list.add(""+ root.left.val);
			helper(res,list,root.left);
			list.remove(list.size()-1);
		}
		if(root.right!=null){
			list.add(""+root.right.val);
			helper(res, list, root.right);
			list.remove(list.size()-1);
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
		n4.left = n2;
		n4.right = n5;
		n2.left = n1;
//		n2.right = n3;
		n5.left = n3;
		n5.right = n6;
//		n1.left = n7;
		System.out.println(binaryTreePaths(n5));
	}
    
    
}