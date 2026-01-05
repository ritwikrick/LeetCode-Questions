class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n=grid.length;
        int freq[]=new int[n*n+1];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid.length;j++){
                int val=grid[i][j];
                freq[val]++;
            }
        }
        int missing=-1;
        int repeated=-1;
        for(int i=1;i<freq.length;i++){
            if(freq[i]==2){
                repeated=i;
            }
            if(freq[i]==0){
                missing=i;
            }
        }
        return new int[]{repeated,missing};
    }
}