class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        // int c=0;
        // int maxc=Integer.MIN_VALUE;
        // for(int i=0;i<nums.length;i++){
        //     if(nums[i]==1){
        //         c++;
        //     }else{
        //         c=0;;
        //     }
        //     maxc=Math.max(maxc,c);
        // }
        // return maxc;

        int c=0;
        int maxc=0;
        for(int r=0;r<nums.length;r++){
            if(nums[r]==1){
                c++;
                maxc=Math.max(maxc,c);
            }else{
                c=0;
            }
        }
        return maxc;
    }
}