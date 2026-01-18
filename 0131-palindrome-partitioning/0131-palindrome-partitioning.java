class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans=new ArrayList<>();
        List<String> list=new ArrayList<>();
        find(ans,list,s,0,s.length());
        return ans;
    }
    public void find(List<List<String>> ans,List<String> list,String s, int start,int n){
        if(start==n){
            ans.add(new ArrayList<>(list));
            return;
        }
        StringBuilder sb=new StringBuilder();
        for(int i=start;i<n;i++){
            sb.append(s.charAt(i));

            if(check(sb.toString())){
                list.add(sb.toString());
                find(ans,list,s,i+1,n);
                //bacltrack
                list.remove(list.size()-1);
            }
        }
        
        
    }
    public boolean check(String s){
        int left=0;
        int right=s.length()-1;
        while(left<right){
            if(s.charAt(left)!=s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}