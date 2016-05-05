/* MergeSort << Divide-And-Conquer whose time complexity is O(n log n) if there are n nums in the list*/

/* MergeSort because we can already merge two sorted lists.
Everytime merge two lists until all the lists are merged into one。
So the space complexity is 1;
the time complexity will be O(n * k*log(k)). If there are k lists and n nums in each list.
--times needed for each merge = times inside mergeTwoLists * times for merges rounds
--the first merge: 2n * k/2. (end == k/2)
--the second merge: 4n * k/4.
--the third merge: 8n * k/8.
--the last merge: kn * 1.
2n * k/2 + 4n * k/4 + ... + (2^x)n * k/(2^x) = nk * x while k/(2^x) = 1 --> x = log2(k) ==> O(n * k*log(k))
or analyze as follows:
(1)For Merge-Sort, the average time complexity is O(k*log(k)).
   To merge n lists in to one, it takes O(k*log(k)) in which k is the size of the big list.
(2)for each Merge-Sort, namely mergeTwoLists, the time complexity is 2n in which n is the the nums in each list.
*/

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




