class Solution {
    public int maxSubarraySumCircular(int[] nums) {

        int maxKadane = Integer.MIN_VALUE;
        int sum = 0;

        // Normal Kadane (non-circular)
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            maxKadane = Math.max(maxKadane, sum);
            if (sum < 0) sum = 0;
        }

        // If all numbers are negative, maxKadane is the answer
        // because circular sum would incorrectly become 0
        boolean allNeg = true;
        int total = 0;
        for (int x : nums) {
            total += x;
            if (x > 0) allNeg = false;
        }
        if (allNeg) return maxKadane;  // same as normal Kadane for all-negative case


        // Now find MINIMUM subarray sum using inverted Kadane
        int minKadane = Integer.MAX_VALUE;
        sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            minKadane = Math.min(minKadane, sum);
            if (sum > 0) sum = 0;   // reset opposite of max-Kadane
        }

        // circular max = totalSum - minimumSubarraySum
        int maxCircular = total - minKadane;

        // final answer = max(normal, circular)
        return Math.max(maxKadane, maxCircular);
    }
}
