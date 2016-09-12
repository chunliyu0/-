/* Analysis */

/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if(root == null)return;
        
        TreeLinkNode pre = root;
        while(pre != null){
            TreeLinkNode dummy = new TreeLinkNode(0);
            TreeLinkNode p = dummy;
            TreeLinkNode curr = pre;
            while(curr != null){
                if(curr.left != null){
                    p.next = curr.left;
                    p = p.next;
                }
                if(curr.right != null){
                    p.next = curr.right;
                    p = p.next;
                }
                curr = curr.next;
            }
            pre = dummy.next;
        }
    }
}
