class Solution {
    public void nextPermutation(int[] nums) {
        int n=nums.length;
        int pivot=-1;
        for(int i=n-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                pivot=i;
                break;
            }
        }
        if(pivot==-1){
            Arrays.sort(nums);
            return;
        }
        for(int i=n-1;i>=0;i--){
            if(nums[i]>nums[pivot]){
                swap(i,pivot,nums);
                break;
            }
        }
        int i=pivot+1;
        int j=n-1;
        while(i<j){
            swap(i,j,nums);
            i++;
            j--;
        }
    }
    public void swap(int i, int j, int[] nums) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
}

}