class Solution {
    public int[] searchRange(int[] nums, int target) {
        int c=0;
        int first=-1;
        int last=-1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==target){
                c++;
                if(c==1){
                    first=i;
                    last=i;
                }else{
                    last=i;
                }
            }
        }
        return new int[]{first,last};
    }
}