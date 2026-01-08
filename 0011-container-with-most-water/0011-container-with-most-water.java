class Solution {
    public int maxArea(int[] height) {
        int maxw=Integer.MIN_VALUE;
        int left=0;
        int right=height.length-1;
        while(left!=right){
            int ht=Math.min(height[left],height[right]);
            int width=right-left;
            maxw=Math.max(maxw,ht*width);

            if(height[left]<height[right]){
                left++;
            }else{
                right--;
            }
            
        }
        return maxw;

    }
}