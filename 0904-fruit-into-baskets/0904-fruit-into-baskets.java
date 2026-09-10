class Solution {
    public int totalFruit(int[] fruits) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int left=0,count=0;
        for(int right=0;right<fruits.length;right++){
            map.put(fruits[right],map.getOrDefault(fruits[right],0)+1);
            while(map.size()>2){
                map.put(fruits[left],map.get(fruits[left])-1);
                //check if nums[left] is equal to zero or not
                if(map.get(fruits[left])==0){
                    //remove it
                    map.remove(fruits[left]);
                }
                //move forward left
                left++;
            }
            //if->its a valid window ->then
            if(map.size()<=2){
                count=Math.max(count,right-left+1);
            }
        }
        return count;
    }
}