/* Analysis - recursive
Check the left first, then begin for the right
*/

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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        if(root == p || root == q)return root;
        
        TreeNode lnode = lowestCommonAncestor(root.left, p, q);
        TreeNode rnode = lowestCommonAncestor(root.right, p, q);
        if(lnode!=null && rnode!=null)
            return root;
        
        return (lnode != null) ? lnode:rnode;
    }
}
