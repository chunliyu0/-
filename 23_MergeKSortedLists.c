/* Merge Sort because we can already merge two sorted lists*/

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
 
 struct ListNode* mergeTwoLists(struct ListNode* l1, struct ListNode* l2) {
    //Base case
    if(l1 == NULL) return l2;
    if(l2 == NULL) return l1;
    
    struct ListNode *ret;
    
    //recursive step
    if( l1->val < l2->val){
        ret=l1;   
        ret->next=mergeTwoLists(l1->next,l2);
    }
    else{ 
        ret=l2;   
        ret->next = mergeTwoLists(l1,l2->next);
    }  
    return ret; 
}

struct ListNode* mergeKLists(struct ListNode** lists, int listsSize) {
    //critical condition
    if(listsSize == 0)
        return NULL;
    
    int begin, end = listsSize-1;
    
    while(end>0){
        begin = 0;
        while(begin < end){
            lists[begin] = mergeTwoLists(lists[begin], lists[end]);
            begin++;
            end--;
        }
    }
    
    return lists[0];
}




