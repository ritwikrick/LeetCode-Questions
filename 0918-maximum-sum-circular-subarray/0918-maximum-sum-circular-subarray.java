class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int total = 0;

        int currMax = 0;
        int maxSum = nums[0];

        int currMin = 0;
        int minSum = nums[0];

        for (int num : nums) {
            total += num;

            // Kadane for maximum subarray
            currMax = Math.max(num, currMax + num);
            maxSum = Math.max(maxSum, currMax);

            // Kadane for minimum subarray
            currMin = Math.min(num, currMin + num);
            minSum = Math.min(minSum, currMin);
        }

        // Edge case: If all numbers are negative
        // then maxSum is the maximum element, and
        // total - minSum becomes 0 (invalid)
        if (maxSum < 0) return maxSum;

        // Circular max = total - minimum subarray sum
        int maxCircular = total - minSum;

        return Math.max(maxSum, maxCircular);
    }
}
