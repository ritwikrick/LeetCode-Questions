class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int m=matrix[0].length;
        int n=matrix.length;
        
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                list.add(matrix[i][j]);
            }
        }
        Collections.sort(list,(a,b)->a-b);
        int c=0;
        for(int i=0;i<list.size();i++){
            if(i==k-1){
                int num=list.get(i);
                return num;
            }
        }
        return -1;
    }
}