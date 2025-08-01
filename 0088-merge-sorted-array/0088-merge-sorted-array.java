// class Solution {
//     public void merge(int[] nums1, int m, int[] nums2, int n) {
//         int[] result = new int[m + n]; // temp array to hold merged result
//         int p1 = 0, p2 = 0, p = 0;

//         // Merge until one array is exhausted
//         while (p1 < m && p2 < n) {
//             if (nums1[p1] < nums2[p2]) {
//                 result[p++] = nums1[p1++];
//             } else {
//                 result[p++] = nums2[p2++];
//             }
//         }

//         // Copy remaining elements from nums1
//         while (p1 < m) {
//             result[p++] = nums1[p1++];
//         }

//         // Copy remaining elements from nums2
//         while (p2 < n) {
//             result[p++] = nums2[p2++];
//         }

//         // Copy result back to nums1
//         for (int i = 0; i < m + n; i++) {
//             nums1[i] = result[i];
//         }
//     }
// }
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;             // Pointer for end of real nums1 data
        int p2 = n - 1;             // Pointer for end of nums2
        int p = m + n - 1;          // Pointer for end of nums1 (full size)

        // Merge from the end to the beginning
        while (p1 >= 0 && p2 >= 0) {
            if (nums1[p1] > nums2[p2]) {
                nums1[p--] = nums1[p1--];
            } else {
                nums1[p--] = nums2[p2--];
            }
        }

        // If there are leftover elements in nums2, copy them
        while (p2 >= 0) {
            nums1[p--] = nums2[p2--];
        }
        
        // No need to copy from nums1 — already in place
    }
}
