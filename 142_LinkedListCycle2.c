/* analysis
fast node steps twice as fast as the slow node
when they meet, fast node walks one more cycle than the slow node.
therefore, one more cycle the the distance from the start point to the meeting point.
If they walk x nodes from the meeting point, they will meet at the the node where the cycle begins.
*/

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
struct ListNode *detectCycle(struct ListNode *head) {
    //base cases
    if(head == NULL || head->next == NULL) return NULL;
    
    struct ListNode *slow = head->next, *fast = head->next->next;
    while(fast!=NULL){
        if(slow == fast)break;
        slow = slow->next;
        if(fast->next == NULL)return NULL;//no cycle
        fast = fast->next->next;
    }
    if(slow!=fast)return NULL;//no cycle
    
    //two nodes walk a distance of n more nodes and meet at the the node where the cycle begins.
    while(head!=slow){
        head = head->next;
        slow = slow->next;
    }
    return head;
}
