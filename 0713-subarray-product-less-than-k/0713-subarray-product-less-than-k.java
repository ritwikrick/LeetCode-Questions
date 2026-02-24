class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        // if(k==0) return 0;
        // int p=1;
        // int left=0;
        // int count=0;
        // for(int right=0;right<nums.length;right++){
        //     p=p*nums[right];
        //     while(p>=k && left<=right){
        //         p=p/nums[left];
        //         left++;
        //     }
        //     count+=right-left+1;
        // }
        // return count;

        if(k==0) return 0;
        int p=1;
        int c=0;
        int l=0;
        for(int r=0;r<nums.length;r++){
            p=p*nums[r];
            while(p>=k && l<=r){
                p=p/nums[l];
                l++;
            }
            c+=r-l+1;
        }
        return c;
    }
}