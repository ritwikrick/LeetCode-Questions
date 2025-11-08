class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set=new HashSet<>();
        int longest=0;
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        ArrayList<Integer> list=new ArrayList<>(set);
        for(int i=0;i<list.size();i++){
            int n=list.get(i);
            if(!set.contains(n-1)){
                int curr=n;
                int count=1;
                while(set.contains(curr+1)){
                    curr++;
                    count++;
                }
                longest=Math.max(longest,count);
            }

        }
        return longest;

    }
}