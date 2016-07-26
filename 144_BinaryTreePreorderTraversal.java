/* Analysis
Traverse the current node and the left node, then push the right node to the stack
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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        Stack stk = new Stack<TreeNode>();
        
        if(root!=null)
            stk.push(root);
        while(stk.size()!=0){
            TreeNode tmp = (TreeNode)stk.pop();
            list.add((Integer)tmp.val);
            if(tmp.right!=null)
                stk.push(tmp.right);
            while(tmp.left!=null){
                tmp = tmp.left;
                list.add((Integer)tmp.val);
                if(tmp.right!=null)
                    stk.push(tmp.right);
            }
        }
        return list;
    }
}
