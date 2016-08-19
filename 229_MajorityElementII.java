public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        ArrayList<Integer> list = new ArrayList<Integer>(2);
        int ret1=0, ret2=0,count1=0,count2=0;
        
        //get the two popular number (may not the majority which shows up more than 1/3)
        for(int tmp:nums){
            if(tmp==ret1)
                count1++;
            else if(tmp==ret2)
                count2++;
            else if(count1==0){
                ret1=tmp;
                count1=1;
            }
            else if(count2==0){
                ret2=tmp;
                count2=1;
            }
            else{
                count1--;
                count2--;
            }
        }
        
        //find out if there exists majority numbers
        count1=0;count2=0;
        for(int tmp:nums){
            if(tmp==ret1)
                count1++;
            else if(tmp==ret2)
                count2++;
        }
        int len = nums.length/3;
        if(count1>len)
            list.add(ret1);
        if(count2>len)
            list.add(ret2);
        
        return list;
    }
}

