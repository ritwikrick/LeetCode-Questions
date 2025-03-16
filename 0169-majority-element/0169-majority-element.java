class Solution {
    //Rick
    public int majorityElement(int[] nums) {
        int candidate = nums[0], count = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == candidate) {
                count++;  // Increase count if same as candidate
            } else {
                count--;  // Decrease count if different
                if (count == 0) {  // If count reaches 0, change candidate
                    candidate = nums[i];
                    count = 1;
                }
            }
        }
        return candidate;
    }
}
