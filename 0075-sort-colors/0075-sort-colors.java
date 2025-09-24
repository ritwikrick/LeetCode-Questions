class Solution {
   public void sortColors(int[] nums) {
    // int low = 0, mid = 0, high = nums.length - 1;
    // while (mid <= high) {
    //     if (nums[mid] == 0) {
    //         int tmp = nums[low];
    //         nums[low++] = nums[mid];
    //         nums[mid++] = tmp;
    //     } else if (nums[mid] == 1) {
    //         mid++;
    //     } else {
    //         int tmp = nums[mid];
    //         nums[mid] = nums[high];
    //         nums[high--] = tmp;
    //     }
    // }
        HashMap<Integer,Integer> map= new HashMap<>();
        // for(int i=0;i<nums.length;i++){
        //     int val=nums[i];
        //     map.put(val, map.getOrDefault(val,0)+1);
        // }
        for(int num:nums){
            map.put(num, map.getOrDefault(num,0)+1);
        }
        int index=0;
        for(int color=0;color<=2;color++){
            int count=map.getOrDefault(color,0);
            for(int j=0;j<count;j++){
                nums[index]=color;
                index++;
            }
        }
    }
}