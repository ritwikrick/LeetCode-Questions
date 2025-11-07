class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return diff(nums,k) - diff(nums,k-1);
    }
    public int diff(int []nums, int k){
        HashMap<Integer,Integer> map=new HashMap<>();
        int n=nums.length;
        int left=0;
        int c=0;
        for(int right=0;right<n;right++){
            int val=nums[right];
            map.put(val,map.getOrDefault(val,0)+1);
            while(map.size()>k){
                int l=nums[left];
                left++;
                map.put(l,map.get(l)-1);
                if(map.get(l)==0) map.remove(l);
            }
            c=c+ right-left+1;
           
        }
        return c;
    }
}