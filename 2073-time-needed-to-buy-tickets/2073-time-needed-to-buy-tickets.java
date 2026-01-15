class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        //Storing index at queue and modifying values in tickets array.
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<tickets.length;i++){
            q.add(i);
        }
        // while(!q.isEmpty()){
        //     int idx=q.remove();
        //     tickets[idx]--;
        //     c++;
        //     if (tickets[idx] == 0 && idx == k) {
        //         return c;
        //     }
        //     if(tickets[idx]>0){
        //         q.add(idx);
        //     }
        // }
        // return c;
        int c=0;
        while(!q.isEmpty()){
            int curr=q.remove();
            tickets[curr]--;
            c++;
            if(tickets[curr]==0 && curr==k) {
                q.remove(curr);
                return c;
            }
            if(tickets[curr]!=0){
                q.add(curr);
            }
        }
        return c;
    }
}