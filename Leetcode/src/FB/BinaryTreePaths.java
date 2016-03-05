package FB;

import java.util.ArrayList;
import java.util.List;

import hard.TreeNode;

public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<String>();
        helper(res, root, "");
        return res;
    }
    
    private void helper(List<String> res, TreeNode root, String cur){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            res.add(cur + root.val);
            return;
        }
        if(root.left != null){
            helper(res, root.left, cur + root.val + "->");
        }
        if(root.right != null){
            helper(res, root.right, cur + root.val + "->");
        }
    }
}
