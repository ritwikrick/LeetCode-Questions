class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        // for(int i=0;i<nums.length;i++){
        //     int sum=0;
        //     int c=0;
        //     for(int j=i;j<nums.length;j++){
        //         c++;
        //         sum+=nums[j];
        //         if(c>=2 && sum%k==0){
        //             return true;
        //         }
        //         // if(c>3) continue;
        //     }
        // }
        // return false;
        int sum=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0, -1);
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            int mod=sum%k;
            if(map.containsKey(mod)){
                if(i-map.get(mod)>=2){
                    return true;
                }
            }else{
                map.put(mod,i);
            }
            
        }
        return false;
    }
}