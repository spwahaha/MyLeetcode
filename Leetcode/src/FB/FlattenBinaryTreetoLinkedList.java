package FB;

import java.util.ArrayList;
import java.util.List;

import hard.TreeNode;

public class FlattenBinaryTreetoLinkedList {
	TreeNode pre = null;
    public void flatten(TreeNode root) {
        if(root == null){
            return;
        }
        flatten(root.right);
        flatten(root.left);
        root.right = pre;
        root.left = null;
        pre = root;
    }
    
    //get the inorder traversal result in a list and then connect all the nodes
    public void flatten2(TreeNode root) {
        if(root == null){
            return;
        }
        List<TreeNode> list = new ArrayList<TreeNode>();
        pre(root, list);
        root = list.get(0);
        TreeNode node = root;
        for(int i = 1; i <= list.size(); i++){
            if(i == list.size()){
                node.left = null;
                node.right = null;
            }else{
                node.left = null;
                node.right = list.get(i);
                node = list.get(i);
            }
        }
    }
    
    private void pre(TreeNode root, List<TreeNode> list){
        if(root == null){
            return;
        }
        list.add(root);
        pre(root.left, list);
        pre(root.right, list);
    }
}
