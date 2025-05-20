class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] freq = new int[n + 1]; // difference array

        // Build difference array for query coverage
        for (int[] query : queries) {
            freq[query[0]]++;
            if (query[1] + 1 < n) {
                freq[query[1] + 1]--;
            }
        }

        // Prefix sum to get total coverage at each index
        for (int i = 1; i < n; i++) {
            freq[i] += freq[i - 1];
        }

        // Check feasibility
        for (int i = 0; i < n; i++) {
            if (nums[i] > freq[i]) return false;
        }

        return true;
    }
}
