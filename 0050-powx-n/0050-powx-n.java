class Solution {
    public double myPow(double x, int n) {
        if(n == 0) return 1.0;
        if(n == 1) return x;
        double num = n;
        if(num < 0){
            x = 1/x;
            num = -num;
        }
        if(num % 2 == 0){
            return myPow(x * x,(int) num / 2);
        }
            return x * myPow(x, (int) num - 1);
       
    }
    
}