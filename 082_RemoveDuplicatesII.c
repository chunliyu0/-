/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
struct ListNode* deleteDuplicates(struct ListNode* head) {
    //Base cases
    if(head==NULL || head->next == NULL)return head;
    
    struct ListNode *p = head->next;
    
    //deal with the case when the head is distinct;
    if(p->val != head->val) {
        head->next = deleteDuplicates(head->next);
        return head;
    }

    //deal with the case when the head has duplicate values;
    while(p->val == head->val){
        p = p->next;
        if(p == NULL)return NULL;//all the list is filled with the same value
    }
    return deleteDuplicates(p);//delete the head
}
