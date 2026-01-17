import java.util.*;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(ans, new ArrayList<>(), nums, new boolean[nums.length]);
        return ans;
    }

    public void backtrack(List<List<Integer>> ans,
                          List<Integer> list,
                          int[] nums,
                          boolean[] used) {

        if (list.size() == nums.length) {
            ans.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {

            if (used[i]) continue;   // skip already used element

            used[i] = true;          // mark as used
            list.add(nums[i]);       // choose

            backtrack(ans, list, nums, used);

            list.remove(list.size() - 1); // backtrack
            used[i] = false;              // unmark
        }
    }
}
