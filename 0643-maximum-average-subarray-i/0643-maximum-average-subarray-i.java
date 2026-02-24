class Solution {
    public double findMaxAverage(int[] nums, int k) {
        // double avg=0;
        // double maxavg=-Double.MAX_VALUE;
        // for(int i=0;i<nums.length;i++){
        //     double sum=0;
        //     for(int j=i;j<nums.length;j++){
        //         sum+=nums[j];
        //         int c=j-i+1;
        //         if(c==k){
        //             avg=sum/c;
        //             maxavg=Math.max(maxavg,avg);
        //         }

        //     }
        // }
        // return maxavg;
        // double sum=0;
        // //Find sum upto first window
        // for(int i=0;i<k;i++){
        //     sum+=nums[i];
        // }
        // double maxsum=sum;
        // int left=0;
        // for(int right=k;right<nums.length;right++){
        //     sum=sum-nums[left];
        //     left++;
        //     sum=sum+nums[right];
        //     maxsum=Math.max(maxsum,sum);
        // }
        // return maxsum/k;
        int n=nums.length;
        double sum=0;
        for(int i=0;i<k;i++){
            sum+=nums[i];
        }
        double maxf=sum;
        int l=0;
        for(int r=k;r<n;r++){
            sum-=nums[l];
            l++;
            sum+=nums[r];
            if(maxf<sum){
                maxf=sum;
            }
            

        }
        return maxf/k;

    }
}














































// class Solution {
//     public double findMaxAverage(int[] nums, int k) {
//     //     double max=Integer.MIN_VALUE;
//     //     for(int i=0;i<nums.length-k+1;i++){
//     //         double sum=0;
//     //         for(int j=i;j<i+k;j++){
//     //             sum=sum+nums[j];
//     //             max=Math.max(max,sum);
//     //         }
//     //     }
//     //     return max/k;
//     // }
//     int n=nums.length;
//     double sum=0;
//     for(int i=0;i<k;i++){
//         sum=sum+nums[i];
//     }
//     double max=sum;
//     int l=0;
//     int r=k;
//     while(r<n){
//         sum+=nums[r] - nums[l];
//         l++;
//         r++;
//         max=Math.max(sum,max);
//     }
//     return max/k;
//     }



// }