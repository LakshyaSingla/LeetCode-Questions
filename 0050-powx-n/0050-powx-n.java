class Solution {
    public double myPow(double x, int n) {
        if(n == 0) return 1.0;
        double num = n;
        if(num < 0){
            num = -num;
            x = 1/x;
        }

        if(num % 2 == 0){
         return myPow(x * x, (int) num / 2);
        }
            return x * myPow(x, (int) num - 1);
        
    }
}