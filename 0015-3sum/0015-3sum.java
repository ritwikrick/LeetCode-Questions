// class Solution {
//     public List<List<Integer>> threeSum(int[] nums) {
//         int ans[][]=new int [3][nums.length]
//         for(int i=0;i<nums.length;i++){
//             for(int j=i+1;j<nums.length;j++){
//                 for(int k=j+1;i<nums.lenght;k++){
//                     if(i!=j && i!=k && j!=k && (nums[i]+nums[j]+nums[k]==0) ){
//                         ans=
//                     }
//                 }
//             }
//         }
//     }
// }
import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            // Skip duplicate values for i
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // Skip duplicates for left
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    // Skip duplicates for right
                    while (left < right && nums[right] == nums[right - 1]) right--;

                    left++;
                    right--;
                } else if (sum < 0) {
                    left++; // move toward higher value
                } else {
                    right--; // move toward lower value
                }
            }
        }

        return result;
    }
}
