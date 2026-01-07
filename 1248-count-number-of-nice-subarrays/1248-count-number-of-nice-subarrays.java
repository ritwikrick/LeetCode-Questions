class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return nice(nums,k)- nice(nums,k-1);
    }
    public int nice(int[] nums, int k){
        int left = 0, odd = 0, count = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] % 2 != 0) odd++;

            while (odd > k) {
                if (nums[left] % 2 != 0) odd--;
                left++;
            }

            count += right - left + 1;
        }
        return count;
    }
}