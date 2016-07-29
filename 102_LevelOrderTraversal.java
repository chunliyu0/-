/* Analysis
(1) Using n to record how many nodes belong to the same level in the queue;
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        Queue que = new LinkedList<TreeNode>();
        
        if(root!=null) que.add(root);
        while(!que.isEmpty()){
            int n = que.size();
            List<Integer> list = new ArrayList<Integer>();
            
            while(n > 0){
                TreeNode tmp= (TreeNode)que.poll();
                list.add(tmp.val);
                if(tmp.left!=null)que.add(tmp.left);
                if(tmp.right!=null)que.add(tmp.right);
                n--;
            }
            ret.add(list);
        }
        
        return ret;
    }
}
