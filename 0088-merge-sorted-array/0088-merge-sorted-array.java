class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // Copy elements from nums2 to the end of nums1
        System.arraycopy(nums2, 0, nums1, m, n);
        
        // Sort the combined array
        Arrays.sort(nums1);
    }
}
