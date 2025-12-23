class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        // int m=matrix[0].length;
        // int n=matrix.length;
        
        // ArrayList<Integer> list=new ArrayList<>();
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<m;j++){
        //         list.add(matrix[i][j]);
        //     }
        // }
        // Collections.sort(list,(a,b)->a-b);
        // int c=0;
        // for(int i=0;i<list.size();i++){
        //     if(i==k-1){
        //         int num=list.get(i);
        //         return num;
        //     }
        // }
        // return -1;

        //Efficient approach

        int n=matrix.length;
        PriorityQueue<int[]>pq=new PriorityQueue<>((a,b)->a[0]-b[0]);
        for(int i=0;i<n;i++){
            pq.add(new int[]{matrix[i][0],i,0});
        }

        int count=0;
        int ans=0;
        while(!pq.isEmpty()){
            int[] curr=pq.remove();
            ans=curr[0];
            int r=curr[1];
            int c=curr[2];
            count++;

            if(count==k) return ans;

            if(c+1<n){
                pq.add(new int[]{matrix[r][c+1],r,c+1});
            }
        }
        return ans;
    }
}