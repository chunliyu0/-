/* Analysis
Keep track of the lower bound and the upper bound
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
    public int closestValue(TreeNode root, double target) {
        int lowerbnd = Integer.MAX_VALUE, upperbnd = Integer.MIN_VALUE;
        
        TreeNode p = root;
        while(p!=null){
            if(p.val < target){
                lowerbnd = p.val;
                p = p.right;
            }
            else if(p.val > target){
                upperbnd = p.val;
                p = p.left;
            }
            else
                return p.val;
        }
        return Math.abs(upperbnd - target) < Math.abs(target - lowerbnd) ? upperbnd : lowerbnd;
    }
}
