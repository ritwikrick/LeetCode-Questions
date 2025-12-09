class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<tickets.length;i++){
            q.add(i);
        }
        int c=0;
        while(!q.isEmpty()){
            int curr=q.remove();
            tickets[curr]--;
            c++;
            if (tickets[curr] == 0 && curr == k) {
                return c;
            }
            if(tickets[curr]>0){
                q.add(curr);
            }
        }
        return c;
    }
}