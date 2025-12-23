class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // HashMap<Integer,Integer> map=new HashMap<>();
        // for(int i=0;i<nums.length;i++){
        //     map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        // }
        // ArrayList<Integer> list=new ArrayList<>(map.keySet());
        // Collections.sort(list, (a,b)->map.get(b)-map.get(a));
        // //Collections.sort(list,(a,b)->a-b);
        // int ans[]=new int[k];
        // for(int i=0;i<k;i++){
        //     ans[i]=list.get(i);
        // }
        // return ans;

        //Efficient-> Min Heap(O(mlogk))
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[1]-b[1]);
        ArrayList<Integer> list=new ArrayList<>(map.keySet());
        for(int i=0;i<list.size();i++){
            int key=list.get(i);
            int val=map.get(key);
            pq.add(new int[]{key,val});
            if(pq.size()>k){
                pq.remove();
            }
        }
        int ans[]=new int[k];
        for(int i=0;i<k;i++){
            ans[i]=pq.remove()[0];
        }
        return ans;
       
    }
}