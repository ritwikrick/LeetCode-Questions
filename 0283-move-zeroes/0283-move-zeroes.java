class Solution {
    public void moveZeroes(int[] nums) {
        int c=0;
        int j=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                c++;
            }else{
                nums[j]=nums[i];
                j++;
            }

        }
        for(int i=j;i<j+c;i++){
            nums[i]=0;
        }
        
    }
}