/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int n1 = getLength(l1), n2 = getLength(l2);
        
        ListNode dummy = new ListNode(1);
        if(n1 < n2)
            dummy.next = add(l2, l1, n2, n1);
        else
            dummy.next = add(l1, l2, n1, n2);
        
        if(dummy.next.val > 9){
            dummy.next.val %= 10;
            return dummy;
        }
        return dummy.next;
    }
    
    public ListNode add(ListNode l1, ListNode l2, int len1, int len2) {
        if(l1 == null) // the length of l1 is always greater than l2
            return null;
        
        ListNode p = (len1 == len2? new ListNode(l1.val + l2.val) : new ListNode(l1.val));
        ListNode post = (len1 == len2? add(l1.next, l2.next, len1 - 1, len2 - 1): add(l1.next, l2, len1 - 1, len2));
        if(post != null && post.val > 9){
            p.val += 1;
            post.val %= 10;
        }
        
        p.next = post;
        return p;
    }
    
    public int getLength(ListNode list){
        int n = 0;
        ListNode p = list;
        while(p != null){
            p = p.next;
            n ++;
        }
        return n;
    }
}
