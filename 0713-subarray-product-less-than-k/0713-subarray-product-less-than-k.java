class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        // int c=0;
        // for(int i=0;i<nums.length;i++){
        //     long p=1;
        //     for(int j=i;j<nums.length;j++){
        //         p*=nums[j];
        //         if(p<k){
        //             c++;
        //         }else{
        //             break;
        //         }
        //     }
        // }
        // return c;

        //SLIDING WINDOW
          if (k <= 1) return 0;

        int left=0;
        int p=1;
        int c=0;
        for(int right=0;right<nums.length;right++){
            p=p*nums[right];
            while(p>=k){
                p=p/nums[left];
                left++;
            }
            if(p<k){
                c+=right-left+1;
            }
        }
        return c;
        
    }
}