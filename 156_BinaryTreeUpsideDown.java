/* Analysis - Inorder
(1) Using a stack to store node on the path from the root to the new root;
(2) We just need to reverse the node simply from the root to the new root
*/

// I BEST SOLUTION:
public class Solution {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        TreeNode parent = null, tmp = root, nextLeft = null, nextRight = null;
        while(tmp != null) {
            nextLeft = tmp.left;
            tmp.left = nextRight;
            nextRight = tmp.right;
            tmp.right = parent;
            parent = tmp;
            tmp = nextLeft;
        }
        return parent;
    }
}

// II INTUITIVE SOLUTION:
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
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if(root == null)return null;
        
        Stack<TreeNode> stk = new Stack<>();
        while(root.left!=null){//get the new root
            stk.push(root);
            root = root.left;
        }
        
        TreeNode tmp = root;
        while(!stk.empty()){
            TreeNode parent = stk.pop();
            tmp.left = parent.right;
            tmp.right = parent;
            parent.left = null;
            parent.right = null;
            tmp = parent;
        }
        return root;
    }
}
