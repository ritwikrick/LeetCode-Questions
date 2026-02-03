class Solution {
    public int leastInterval(char[] tasks, int n) {
        int freq[]= new int[26];
        for(int i=0;i<tasks.length;i++){
            freq[tasks[i]-'A']++;
        }
        int maxf=0;
        for(int i=0;i<freq.length;i++){
            if(freq[i]>maxf){
                maxf=freq[i];
            }
        }
        int count=0;
        for(int i=0;i<freq.length;i++){
            if(maxf==freq[i]){
                count++;
            }
        }
        int part= (maxf-1)*(n+1) + count;
        if(part>tasks.length){
            return part;
        }
        return tasks.length;
    }
}