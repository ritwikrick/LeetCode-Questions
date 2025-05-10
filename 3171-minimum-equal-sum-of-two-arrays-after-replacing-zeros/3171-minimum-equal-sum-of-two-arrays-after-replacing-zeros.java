class Solution {
    public long minSum(int[] nums1, int[] nums2) {
        long sum1 = 0, sum2 = 0;
        int z1 = 0, z2 = 0;

        for (int x : nums1) {
            if (x == 0) { z1++; sum1 += 1; }
            else        {       sum1 += x; }
        }
        for (int x : nums2) {
            if (x == 0) { z2++; sum2 += 1; }
            else        {       sum2 += x; }
        }

        // ensure sum1 <= sum2
        if (sum1 > sum2) {
            long tSum = sum1; sum1 = sum2; sum2 = tSum;
            int tZ = z1;       z1   = z2; z2   = tZ;
        }

        if (sum1 == sum2)         return sum1;      // already equal
        if (z1 > 0)               return sum2;      // can boost smaller side
        return -1;                                    // cannot adjust
    }
}
