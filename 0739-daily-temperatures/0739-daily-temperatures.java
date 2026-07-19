class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> s=new Stack<>();
        int ans[]= new int[temperatures.length];
        for(int i=temperatures.length-1;i>=0;i--){
            while(!s.isEmpty() && temperatures[s.peek()]<=temperatures[i]){
                s.pop();
            }
            if(!s.isEmpty()){
                ans[i]=s.peek()-i;
            }
            s.push(i);
        }
        return ans;


        //O(N^2)
        // int arr[]=new int[temperatures.length];
        // for(int i=0;i<temperatures.length;i++){
        //     int curr=temperatures[i];
        //     for(int j=i;j<temperatures.length;j++){
        //         if(curr<temperatures[j]){
        //             int c=j-i;
        //             arr[i]=c;
        //             break;
        //         }
        //     }
        // }
        // return arr;
    }
}