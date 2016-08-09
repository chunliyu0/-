/* Analysis - Leverl Traversal */

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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ret = new ArrayList<Integer>();
        
        if(root == null)return ret;
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        while(!que.isEmpty()){
            int len = que.size();
            ret.add(que.peek().val);
            for(int i = 0; i<len; i++){
                TreeNode tmp = que.remove();
                if(tmp.right!=null)que.add(tmp.right);
                if(tmp.left!=null)que.add(tmp.left);
            }
        }
        
        return ret;
    }
}
