class Solution {
    public int subarraySum(int[] nums, int k) {
        // //O(n^2)
        // int n=nums.length;
        // int c=0;
        // for(int i=0;i<n;i++){
        //     int sum=0;
        //     for(int j=i;j<n;j++){
        //         sum=sum+nums[j];
        //         if(sum==k){
        //             c++;
        //         }

        //     }
        // }
        // return c;
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        int psum=0;
        int c=0;
        for(int i=0;i<nums.length;i++){
            psum+=nums[i];
            if(map.containsKey(psum-k)){
                c=c+map.get(psum-k);
            }
            map.put(psum,map.getOrDefault(psum,0)+1);
        }
        return c;
        
    }
}