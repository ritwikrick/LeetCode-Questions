class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // int p=nums1.length-1;
        // int p2=nums2.length-1;
        // int p1=nums1.length-n-1;
        // while(p1>=0 && p2>=0){
        //     if(nums1[p1]>=nums2[p2]){
        //         nums1[p]=nums1[p1];
        //         p1--;
        //     }else{
        //         nums1[p]=nums2[p2];
        //         p2--;
        //     }
        //     p--;
        // }
        // while(p2>=0){
        //     nums1[p]=nums2[p2];
        //     p2--;
        //     p--;
        // }
        int p1=0,p2=0,p=0;
        int arr[]=new int[m+n];
        while(p1<m && p2<n){
            if(nums1[p1]<=nums2[p2]){
                arr[p]=nums1[p1];
                p1++;
            }else{
                arr[p]=nums2[p2];
                p2++;
            }
            p++;
        }
        while(p1<m){
            arr[p]=nums1[p1];
            p1++;
            p++;
        }
        while(p2<n){
             arr[p]=nums2[p2];
             p2++;
             p++;
        }
        for(int i=0;i<nums1.length;i++){
            nums1[i]=arr[i];
        }
    }
}