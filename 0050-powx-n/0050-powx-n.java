class Solution {
    public double myPow(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }

        double result = 1;
        while (N > 0) {
            if ((N & 1) == 1) { // same as N % 2 == 1, but uses bitwise
                result = result * x;
            }
            x = x * x;
            N = N / 2;
        }
        return result;
    }
}
