class Solution {
    public int maxProduct(int[] nums) {
        int maxi = Integer.MIN_VALUE;
        int prod = 1;

        // Left pass
        for (int i = 0; i < nums.length; i++) {
            prod *= nums[i];
            maxi = Math.max(maxi, prod);
            if (prod == 0) prod = 1;   // correct reset
        }

        prod = 1;

        // Right pass
        for (int i = nums.length - 1; i >= 0; i--) {
            prod *= nums[i];
            maxi = Math.max(maxi, prod);
            if (prod == 0) prod = 1;
        }

        return maxi;
    }
}
