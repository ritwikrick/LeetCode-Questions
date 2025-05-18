import java.util.*;

class Solution {
    public List<Integer> findLonely(int[] nums) {
        Arrays.sort(nums); // Step 1: Sort the array
        List<Integer> result = new ArrayList<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            // Check if current number appears only once
            boolean isUnique = (i == 0 || nums[i] != nums[i - 1]) &&
                               (i == n - 1 || nums[i] != nums[i + 1]);

            // Check if no adjacent values (x-1 or x+1) exist
            boolean hasNoAdjacent = (i == 0 || nums[i - 1] != nums[i] - 1) &&
                                    (i == n - 1 || nums[i + 1] != nums[i] + 1);

            if (isUnique && hasNoAdjacent) {
                result.add(nums[i]);
            }
        }

        return result;
    }
}
