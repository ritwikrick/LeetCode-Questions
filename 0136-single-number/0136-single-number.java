class Solution {
    public int singleNumber(int[] nums) {
        for(int i=0;i<nums.length;i++){
            int c=0;
            for(int j=0;j<nums.length;j++){
                if(nums[i]==nums[j]){
                    c++;
                } 
            }
            if(c==1){
                return nums[i];
            }
        }
        return -1;
    }
}

// class Solution {
//     public int singleNumber(int[] nums) {
//         for (int i = 0; i < nums.length; i++) {
//             int c = 0;
//             for (int j = 0; j < nums.length; j++) {
//                 if (nums[i] == nums[j]) {
//                     c++;
//                 }
//             }
//             if (c == 1) { // If count is 1, return the number
//                 return nums[i];
//             }
//         }
//         return -1; // Return -1 if no single number is found
//     }
// }
