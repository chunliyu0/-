// I best soluton - Recursive
/* Analysis - Recursive */
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
    public boolean isValid(TreeNode node, double min, double max){
        if(node == null )return true;
        
        if(node.val < max && node.val > min)
            return isValid(node.left, min, node.val) && isValid(node.right, node.val, max);
        return false;
    }
    
    public boolean isValidBST(TreeNode root) {
        return isValid(root, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
    }
}

// II Iterative Solution
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

