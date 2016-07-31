/* Analysis
Using stack to store the next one
*/

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {
    TreeNode curr;// curr is the starting point and curr is included;
    Stack stk = new Stack<TreeNode>();// stk is used to prestore the next smallest one;
    
    public BSTIterator(TreeNode root) {
        curr = root;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
         return (curr != null || !stk.isEmpty());
    }

    /** @return the next smallest number */
    public int next() {
        while(curr!=null){
            stk.push(curr);
            curr = curr.left;
        }
        TreeNode ret = (TreeNode)stk.pop();
        curr = ret.right;
        
        return ret.val;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
