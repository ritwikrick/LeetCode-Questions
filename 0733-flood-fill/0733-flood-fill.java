class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int originalclr=image[sr][sc];
        if (originalclr == color) return image;//It PREVENTS DFS FROM EVER STARTING

        dfs(image,sr,sc,color,originalclr);
        return image;
    }
    private void dfs(int[][] image,int r,int c,int newcolor,int originalclr){
        if(r<0 || c<0 || r>=image.length || c>=image[0].length ){
            return;
        }
        if(image[r][c]!=originalclr){
            return;
        }
        image[r][c]=newcolor;
        dfs(image,r+1,c,newcolor,originalclr);
        dfs(image,r-1,c,newcolor,originalclr);
        dfs(image,r,c+1,newcolor,originalclr);
        dfs(image,r,c-1,newcolor,originalclr);
    }
}