package FB;

import hard.TreeNode;

public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        return valid(root, null, null);
    }
    
    private boolean valid(TreeNode root, Integer max, Integer min){
        if(root == null){
            return true;
        }
        
        if(max != null && root.val >= max){
            return false;
        }
        if(min != null && root.val <= min){
            return false;
        }
        
        return valid(root.left, root.val, min) && valid(root.right, max, root.val);
    }
}
