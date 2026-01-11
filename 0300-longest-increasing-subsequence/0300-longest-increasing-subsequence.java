class Solution {
    public int lengthOfLIS(int[] nums) {
        LinkedHashSet<Integer>set=new LinkedHashSet<>();
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        int nums2[]=new int[set.size()];
        int idx = 0;
        for (int val : set) {
            nums2[idx++] = val;
        }
        Arrays.sort(nums2);
        int dp[][]=new int[nums.length+1][nums2.length+1];
        for(int i=0;i<nums.length+1;i++){
            for(int j=0;j<nums2.length+1;j++){
                dp[i][j]=-1;
            }
        }
        return lcs(nums,nums2,nums.length,nums2.length,dp);

    }
    public int lcs(int nums1[],int nums2[],int m, int n,int dp[][]){
        if(m==0 || n==0){
            return 0;
        }

        if(dp[m][n]!=-1){
            return dp[m][n];
        }else{
            if(nums1[m-1]==nums2[n-1]){
                return lcs(nums1,nums2,m-1,n-1,dp)+1;
            }else{
                int ch1=lcs(nums1,nums2,m,n-1,dp);
                int ch2=lcs(nums1,nums2,m-1,n,dp);
                dp[m][n]=Math.max(ch1,ch2);
            }
        }
        return dp[m][n];
    }
}