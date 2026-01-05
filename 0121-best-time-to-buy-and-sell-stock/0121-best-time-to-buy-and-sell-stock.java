class Solution {
    public int maxProfit(int[] prices) {
        int buyprice=Integer.MAX_VALUE;
        int maxpro=0;
        for(int i=0;i<prices.length;i++){
            if(prices[i]>buyprice){
                int profit=prices[i]-buyprice;
                maxpro=Math.max(profit,maxpro);
            }else{
                buyprice=prices[i];
            }
        }
        return maxpro;
    }
}