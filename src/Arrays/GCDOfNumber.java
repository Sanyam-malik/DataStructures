//https://www.geeksforgeeks.org/problems/gcd-of-two-numbers3459/1
class Solution {
    public static int gcd(int a, int b) {
        // code here
        if(a == 0) {
            return b;
        }
        int x = Math.min(a, b);
        int y = Math.max(a, b);
        return gcd(y%x, x);
    }
}
