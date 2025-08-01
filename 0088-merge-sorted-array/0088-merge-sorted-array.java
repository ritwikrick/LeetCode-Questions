class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] result = new int[m + n]; // temp array to hold merged result
        int p1 = 0, p2 = 0, p = 0;

        // Merge until one array is exhausted
        while (p1 < m && p2 < n) {
            if (nums1[p1] < nums2[p2]) {
                result[p++] = nums1[p1++];
            } else {
                result[p++] = nums2[p2++];
            }
        }

        // Copy remaining elements from nums1
        while (p1 < m) {
            result[p++] = nums1[p1++];
        }

        // Copy remaining elements from nums2
        while (p2 < n) {
            result[p++] = nums2[p2++];
        }

        // Copy result back to nums1
        for (int i = 0; i < m + n; i++) {
            nums1[i] = result[i];
        }
    }
}
