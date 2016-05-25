/* Analysis
Set two pointers slow and fast, if there is a cycle, they will finally meet each other.
*/

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
bool hasCycle(struct ListNode *head) {
    if(head == NULL || head->next == NULL)
        return false;
    
    struct ListNode *slow = head->next, *fast = head->next->next;
    while(fast != NULL){
        if(slow == fast)
            return true;
        slow = slow->next;
        if(fast->next == NULL) return false;//very important
        fast = fast->next->next;
    }
    return false;
}
