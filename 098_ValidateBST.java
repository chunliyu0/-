/* Analysis - Inorder */

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
    public boolean isValidBST(TreeNode root) {
        TreeNode p = root; 
        int pre = Integer.MIN_VALUE;
        boolean start = true;
        Stack<TreeNode> stk = new Stack<>();

        while(p!=null){
            while(p.left!=null){
                TreeNode dummy = p;
                p = p.left;
                dummy.left = null;
                stk.push(dummy);
            }
            if(start){
                pre = p.val;
                start = false;
            }
            else if(p.val <= pre)return false;
            pre = p.val;
            
            if(p.right!=null){
                p = p.right;
                continue;
            }
            
            if(stk.isEmpty())break;
            p = stk.pop();
        }
        
        return true;
    }
}
