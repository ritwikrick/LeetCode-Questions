class Solution {
    public double myPow(double x, int n) {
        // long N=n;
        if(n<0){
            x=1/x;
            n=-n;
        }
        return poww(x,n);
    }
    public double poww(double x,int n){
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