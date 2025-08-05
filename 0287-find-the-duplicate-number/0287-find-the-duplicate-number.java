// import java.util.HashMap;

// class Solution {
//     public int findDuplicate(int[] nums) {
//         // Brute-force approach (commented out for now):
//         /*
//         for (int i = 0; i < nums.length; i++) {
//             for (int j = i + 1; j < nums.length; j++) {
//                 if (nums[i] == nums[j]) {
//                     return nums[i]; // found duplicate
//                 }
//             }
//         }
//         return -1; // shouldn't happen as per problem constraints
//         */

//         // HashMap approach:
//         HashMap<Integer, Integer> map = new HashMap<>();
//         for (int num : nums) {
//             map.put(num, map.getOrDefault(num, 0) + 1);
//             if (map.get(num) > 1) {
//                 return num;
//             }
//         }
//         return -1; // shouldn't reach here as per problem guarantee
//     }
// }
class Solution {
    public int findDuplicate(int[] nums) {
        // Step 1: Detect intersection point
        int slow = nums[0];
        int fast = nums[0];

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        // Step 2: Find entrance to cycle (duplicate)
        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }
}
