class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);   // default result is -1
        
        Stack<Integer> st = new Stack<>(); // will store indexes

        // We go 2 times through the array to make it circular
        for (int i = 0; i < 2 * n; i++) {

            int index = i % n;        // circular index->[currentidx %n]
            int current = nums[index];

            // If current number is greater than element at stack top
            while (!st.isEmpty() && nums[st.peek()] < current) {
                res[st.pop()] = current;   // we found next greater element
            }

            // Only push first n indices (to avoid extra pushing)
            if (i < n) {
                st.push(index);
            }
        }

        return res;
    }
}
