import java.util.*;

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {

        Arrays.sort(nums);   // IMPORTANT for handling duplicates

        List<List<Integer>> ans = new ArrayList<>();
        boolean[] used = new boolean[nums.length];

        backtrack(ans, new ArrayList<>(), nums, used);
        return ans;
    }

    private void backtrack(List<List<Integer>> ans,
                           List<Integer> list,
                           int[] nums,
                           boolean[] used) {

        if (list.size() == nums.length) {
            ans.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {

            // Skip if already used
            if (used[i]) continue;

            // 🔥 KEY STEP TO AVOID DUPLICATES
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }

            used[i] = true;
            list.add(nums[i]);

            backtrack(ans, list, nums, used);

            // backtrack
            list.remove(list.size() - 1);
            used[i] = false;
        }
    }
}
