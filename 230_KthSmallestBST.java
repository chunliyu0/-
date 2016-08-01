/* Analysis - Inorder
Using [k--; if(k==0)break;] to replace the visit;
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
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stk = new Stack<>();
        TreeNode tmp = root;

        while(!stk.isEmpty() || tmp!=null){
            while(tmp.left!=null){
                TreeNode dummy = tmp;
                tmp = tmp.left;
                dummy.left = null;
                stk.push(dummy);
            }//find the smallest one
            
            k--;
            if(k==0)break;
            
            if(tmp.right==null){
                tmp = stk.pop();
            }
            else{
                tmp = tmp.right;
            }
        }
        
        return tmp.val;
    }
}
