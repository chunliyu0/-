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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        Stack stk = new Stack<TreeNode>();
        
        if(root != null)stk.push(root);
        while(!stk.empty()){
            TreeNode tmp = (TreeNode)stk.peek();
            if(tmp.left==null && tmp.right==null){
                list.add(tmp.val);
                stk.pop();
                continue;
            }
            if(tmp.right!=null){
                stk.push(tmp.right);
                tmp.right = null;
            }
            if(tmp.left!=null){
                stk.push(tmp.left);
                tmp.left = null;
            }
        }
        
        return list;

    }
}

    
