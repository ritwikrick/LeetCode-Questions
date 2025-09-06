class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        //O(n)
        // int n=arr.length;
        // for(int i=0;i<n;i++){
        //    if(arr[i]>arr[i+1]){
        //             return i;
        //         }
        // }

        // //O(logn)
        // int n=arr.length;
        // int left=0;
        // int right=n-1;


        // while(left<right){
        //     int mid = left + (right - left) / 2;
        //     if(arr[mid]<arr[mid+1]){
        //         left=mid+1;
        //     }else{
        //         right=mid;
        //     }
        // }
        // return left;
        //O(n)
        // int n=arr.length;
        // int i;
        // for( i=0;i<n;i++){
        //     if(arr[i]>arr[i+1]){
        //         break;
        //     }
        // }
        // return i;
        int low=0;
        int high=arr.length-1;
        while(low<high){
            int mid=low+(high-low)/2;
            if(arr[mid]<arr[mid+1]){
                low=mid+1;
            }else{
                high=mid;
            }
        }
        return low;


    }
}