/* Analysis
(1) Using stack to save the current node
(2) Be careful that to set the left of the current node to null when it is pushed into the stack

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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        Stack stk = new Stack<TreeNode>();
        
        if(root!=null)
            stk.push(root);
        while(stk.size()!=0){
            TreeNode tmp = (TreeNode)stk.pop();
            while(tmp.left!=null){
                stk.push(tmp);
                TreeNode node = tmp;
                tmp = tmp.left;
                node.left = null;
            }
            list.add((Integer)tmp.val);
            if(tmp.right!=null)
                stk.push(tmp.right);
        }
        return list;
    }
}

    
