/* Analysis
(1) Case 1: the succ is above the target;
(2) Case 2: the succ is below the target;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode tmp = root, succ = null;
        while(tmp!=p){
            if(tmp.val < p.val)
                tmp = tmp.right;
            else{
                succ = tmp;
                tmp = tmp.left;
            }
                
        }
        //case 1
        if(tmp.right == null){
            return succ;
        }
        
        //case 2
        tmp = tmp.right;
        while(tmp.left!=null){
            tmp = tmp.left;
        }
        return tmp;
    }
}
