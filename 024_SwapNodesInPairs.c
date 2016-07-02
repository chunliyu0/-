/* Analysis
Just swap the values
*/

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
struct ListNode* swapPairs(struct ListNode* head) {
    if(head==NULL)return NULL;
    
    struct ListNode *p = head, *q = head;
    while(p->next){
        q = p->next;
        int tmp = p->val;
        p->val = q->val;
        q->val = tmp;
        
        p = p->next->next;
        if(!p)
            return head;
    }
    return head;
}
