class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int c=0;
        int maxc=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1){
                c++;
            }else{
                c=0;;
            }
            maxc=Math.max(maxc,c);
        }
        return maxc;
    }
}