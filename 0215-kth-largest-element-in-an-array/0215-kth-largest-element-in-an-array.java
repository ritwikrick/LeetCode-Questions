class Pair implements Comparable<Pair>{
    int n;
    Pair(int n){
        this.n=n;
    }
    @Override
    public int compareTo(Pair p){
        //MAX-HEAP
        return p.n-this.n;
    }

}
class Solution {
    public int findKthLargest(int[] nums, int k) {
        int val=0;
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        for(int i=0;i<nums.length;i++){
            pq.add(new Pair(nums[i]));
        }
        for(int i=0;i<k;i++){
            val=pq.remove().n;
        }
        return val;
    }
}