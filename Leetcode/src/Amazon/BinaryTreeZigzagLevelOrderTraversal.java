package Amazon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root == null){
            return res;
        }
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        boolean fromLeft = true;
        while(!q.isEmpty()){
            List<Integer> list = new LinkedList<Integer>();
            int size = q.size();
            for(int i = 0; i < size; i++){
                TreeNode node = q.poll();
                if(fromLeft){
                    list.add(node.val);
                }else{
                    list.add(0, node.val);
                }
                if(node.left != null){
                    q.add(node.left);
                }
                if(node.right != null){
                    q.add(node.right);
                }
            }
            fromLeft = !fromLeft;
            res.add(list);
        }
        
        return res;
    }
}
