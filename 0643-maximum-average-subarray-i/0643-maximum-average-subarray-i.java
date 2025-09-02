class Solution {
    public double findMaxAverage(int[] nums, int k) {
    //     double max=Integer.MIN_VALUE;
    //     for(int i=0;i<nums.length-k+1;i++){
    //         double sum=0;
    //         for(int j=i;j<i+k;j++){
    //             sum=sum+nums[j];
    //             max=Math.max(max,sum);
    //         }
    //     }
    //     return max/k;
    // }
    int n=nums.length;
    double sum=0;
    for(int i=0;i<k;i++){
        sum=sum+nums[i];
    }
    double max=sum;
    int l=0;
    int r=k;
    while(r<n){
        sum+=nums[r] - nums[l];
        l++;
        r++;
        max=Math.max(sum,max);
    }
    return max/k;
    }



}