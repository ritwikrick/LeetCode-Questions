class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);   // remainder 0 occurs once initially

        int sum = 0;
        int c = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            // Proper modulo fix
            int mod = (sum % k + k) % k;

            // Count existing occurrences of this remainder
            if (map.containsKey(mod)) {
                c += map.get(mod);
            }

            // Update frequency
            map.put(mod, map.getOrDefault(mod, 0) + 1);
        }

        return c;
    }
}
