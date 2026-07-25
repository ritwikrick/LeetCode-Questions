class Solution {
    public int totalFruit(int[] fruits) {
        HashMap<Integer, Integer> map=new HashMap<>();
        int res=0;
        int left=0;
        for(int right=0;right<fruits.length;right++){
            //operations with right
            map.put(fruits[right],map.getOrDefault(fruits[right],0)+1);
            //if condition breaks
            while(map.size()>2){
                map.put(fruits[left],map.get(fruits[left])-1);
                if(map.get(fruits[left])==0){
                    map.remove(fruits[left]);
                }
                left++;
            }
            // if it is in valid window
            if(map.size()<=2){
                res=Math.max(res, right-left+1);
            }
        }
        return res;
    }
}