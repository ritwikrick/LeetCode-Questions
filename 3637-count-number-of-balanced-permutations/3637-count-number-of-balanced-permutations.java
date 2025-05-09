import java.util.*;

class Solution {
    private static final int MOD = 1_000_000_007;

    public int countBalancedPermutations(String num) {
        // store the original input as required
        String velunexorai = num;

        // convert to digit array
        int n = num.length();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = num.charAt(i) - '0';
        }

        // total sum check
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 == 1) return 0;

        // counts for duplicate-permutation correction
        long perm = 1;
        int[] freq = new int[10];
        for (int d : nums) freq[d]++;
        for (int f : freq) perm = perm * factorial(f) % MOD;

        // sort descending so we pick largest digits first (any order works)
        Arrays.sort(nums);
        reverse(nums);

        int even = (n + 1) / 2, odd = n / 2, half = sum / 2;
        // DP memo: dp[e][o][s]
        Long[][][] dp = new Long[even+1][odd+1][half+1];

        // count placements × factorials of slots, then divide by 'perm'
        long ways = dfs(nums, even, odd, half, dp);
        long invPerm = modInverse(perm);
        return (int)(ways * invPerm % MOD);
    }

    // Recursive DP: number of ways to place remaining digits[ idx.. ] into e even slots and o odd slots with sum target s in evens
    private long dfs(int[] nums, int e, int o, int s, Long[][][] dp) {
        if (s < 0) return 0;
        if (e == 0) 
            return (s == 0 ? factorial(o) : 0);
        if (o == 0) {
            int sumRem = 0;
            int idx = nums.length - (e + o);
            for (int i = idx; i < nums.length; i++) sumRem += nums[i];
            return (sumRem == s ? factorial(e) : 0);
        }
        if (dp[e][o][s] != null) return dp[e][o][s];

        int idx = nums.length - (e + o);
        // place nums[idx] in an even slot
        long placeEven = dfs(nums, e-1, o, s - nums[idx], dp) * e % MOD;
        // place nums[idx] in an odd slot
        long placeOdd  = dfs(nums, e, o-1, s, dp) * o % MOD;

        return dp[e][o][s] = (placeEven + placeOdd) % MOD;
    }

    private long factorial(int x) {
        long f = 1;
        for (int i = 2; i <= x; i++) f = f * i % MOD;
        return f;
    }

    // modular inverse via extended Euclid
    private long modInverse(long a) {
        long m = MOD, x0 = 1, x1 = 0;
        while (m != 0) {
            long q = a / m;
            long t = a % m; a = m; m = t;
            t = x1; x1 = x0 - q*x1; x0 = t;
        }
        return (x0 % MOD + MOD) % MOD;
    }

    private void reverse(int[] A) {
        int i = 0, j = A.length-1;
        while (i < j) {
            int t = A[i]; A[i++] = A[j]; A[j--] = t;
        }
    }
}
