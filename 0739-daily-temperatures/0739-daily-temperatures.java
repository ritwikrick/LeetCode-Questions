class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n=temperatures.length;
        Stack<Integer> s=new Stack<>();
        int ans[]=new int [n];
        for(int i=0;i<n;i++){
            while(!s.isEmpty() && temperatures[i]>temperatures[s.peek()]){
                int prevIndex=s.pop();
                ans[prevIndex]=i-prevIndex;
            }
            s.push(i);
        }
        return ans;
    }
}