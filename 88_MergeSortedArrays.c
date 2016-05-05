//Since the array nums2 will be merged into nums1, the total length of the new nums1 is known as m+n.
//Now that the second part of the nums1 is empty, we can start from the end of two arrays.

void merge(int* nums1, int m, int* nums2, int n) {
    int k = m+n-1, i, j;
    
    //start from the ends of the two arrays
    for(i = m-1, j = n-1; i>=0 && j>=0; k--){
        if(nums1[i]>=nums2[j]){
            nums1[k] = nums1[i--];
        }
        else{
            nums1[k] = nums2[j--];
        }
    }
    
    //if i>=0 while j<0, then nums1 is already the result array. we only need to consider the case when nums2 has elements left.
    while(j>=0)
        nums1[k--] = nums2[j--];
}
