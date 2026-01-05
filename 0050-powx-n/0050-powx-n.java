class Solution {
    public double myPow(double x, int n) {
        long N=n;
        if(N<0){
            x=1/x;
            N=-N;
        }
        return poww(x,N);
    }
    public double poww(double x,long n){
        if(n==0) return 1;
        // if(n%2==0){
        //     return poww(x,n/2)*poww(x,n/2);
        // }else{
        //     return x*poww(x,n/2)*poww(x,n/2);
        // }
         double half = poww(x, n / 2);

        if (n % 2 == 0) {
            return half * half;
        } else {
            return x * half * half;
        }
    }
}