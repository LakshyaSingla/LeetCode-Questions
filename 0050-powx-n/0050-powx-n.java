class Solution {
    public double myPow(double x, int n) {
        double base = x;
        double res = 1;
        long N = n;
        if(n < 0){
             N = -N;

        }
        while(N > 0){
            if(N % 2 == 1){
                res *= base;
                N--;
            }else{
                base *= base;
                N /= 2;
            }
        }
        if(n < 0) return 1 / res;
        return res;
    }
}