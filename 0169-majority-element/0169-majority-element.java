// class Solution {
//     public int majorityElement(int[] nums) {
//         for(int i=0;i<nums.length;i++){
//             int c=0;
//            for(int j=i+1;j<nums.length;j++){
//                 if(nums[i]==nums[j]){
//                     c++;
//                     if(c>=nums.length/2){
//                     return nums[i];
//                     }
//                 }
                
//             }
//         }
//         return -1;
        
        
//     }
// }

// class Solution {
//     //Rick
//     public int majorityElement(int[] nums) {
//         int candidate = nums[0], count = 1;

//         for (int i = 1; i < nums.length; i++) {
//             if (nums[i] == candidate) {
//                 count++;  // Increase count if same as candidate
//             } else {
//                 count--;  // Decrease count if different
//                 if (count == 0) {  // If count reaches 0, change candidate
//                     candidate = nums[i];
//                     count = 1;
//                 }
//             }
//         }
//         return candidate;
//     }
// }

class Solution {
    public int majorityElement(int[] nums) {
        // Step 1: Find a candidate using Boyer-Moore Majority Vote Algorithm
        int candidate = nums[0], count = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == candidate) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    candidate = nums[i];
                    count = 1;
                }
            }
        }

        // Step 2: Validate the candidate (only needed if majority is not guaranteed)
        int frequency = 0;
        for (int num : nums) {
            if (num == candidate) {
                frequency++;
            }
        }

        // Check if it appears more than n/2 times
        if (frequency > nums.length / 2) {
            return candidate;
        } else {
            return -1; // No majority element found
        }
    }
}

