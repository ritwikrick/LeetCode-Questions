class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0, j = 0, k = 0;
        int[] temp = new int[m + n];
        
        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]) {
                temp[k++] = nums1[i++];
            } else {
                temp[k++] = nums2[j++];
            }
        }
        
        // Copy remaining elements of nums1 if any
        while (i < m) {
            temp[k++] = nums1[i++];
        }
        
        // Copy remaining elements of nums2 if any
        while (j < n) {
            temp[k++] = nums2[j++];
        }
        
        // Copy the result back to nums1
        for (int x = 0; x < m + n; x++) {
            nums1[x] = temp[x];
        }
    }
}
