class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atmost(nums,k) - atmost(nums,k-1);
    }
    public int atmost(int nums[], int k){
        HashMap<Integer, Integer> map=new HashMap<>();
        int left=0;
        int count=0;
        for(int right=0;right<nums.length;right++){
            int val=nums[right];
            map.put(val,map.getOrDefault(val,0)+1);
            while(map.size()>k){
                //dec freq of left
                map.put(nums[left],map.get(nums[left])-1);
                if(map.get(nums[left])==0) map.remove(nums[left]);
                //incrementing left
                left++;
            }
            if(map.size()<=k){
                count+=right-left+1;
            }
        }
        return count;
    }
}