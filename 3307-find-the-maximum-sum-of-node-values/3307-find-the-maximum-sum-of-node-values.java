class Solution {
    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        long baseSum = 0;
        int countPositiveDelta = 0;
        int minDelta = Integer.MAX_VALUE;
        for (int num : nums) {
            baseSum += num;
            int delta = (num ^ k) - num;
            if (delta > 0) {
                countPositiveDelta++;
            }
            // Keep track of the minimum delta (whether positive or not)
            minDelta = Math.min(minDelta, Math.abs(delta));
        }

        long gain = 0;
        for (int num : nums) {
            int delta = (num ^ k) - num;
            if (delta > 0) {
                gain += delta;
            }
        }

        // If count of beneficial flips is even, we can flip all
        if (countPositiveDelta % 2 == 0) {
            return baseSum + gain;
        } else {
            // If odd, we leave out the least beneficial one
            return baseSum + gain - minDelta;
        }
    }
}
