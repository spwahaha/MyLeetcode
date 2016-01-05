import java.util.ArrayList;
import java.util.List;

import hard.TreeNode;

public class Binary_Tree_Paths {
	public static List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<String>();
        if(root == null) return res;
        List<List<Integer>> temp = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        helper(temp, list, root);
        for(List<Integer> li:temp){
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < li.size(); i++){
                sb.append("" + li.get(i));
                if(i!=li.size()-1) sb.append("->");
            }
            res.add(sb.toString());
        }
        return res;
    }
    
    private static void helper(List<List<Integer>> res, List<Integer> list, TreeNode root){
        if(root.left == null && root.right==null){
            list.add(root.val);
            res.add(new ArrayList<Integer>(list));
            list.remove(list.size()-1);
            return;
        }
        if(root.left!=null){
            list.add(root.val);
            helper(res, list, root.left);
            list.remove(list.size()-1);
        }

        if(root.right!=null){
        	list.add(root.val);
            helper(res, list, root.right);
            list.remove(list.size()-1);
        }
            
    }
    
    public static void main(String[] args){
    	TreeNode n0 = new TreeNode(1);
    	n0.left = new TreeNode(2);
    	System.out.print(binaryTreePaths(n0));
    }
}
