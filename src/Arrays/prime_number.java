/*
<metadata>
    <name>Prime Number</name>
    <url>https://www.geeksforgeeks.org/problems/prime-number2314/1</url>
    <description>Given a number n, determine whether it is a prime number or not.
Note: A prime number is a number greater than 1 that has no positive divisors other than 1 and itself.

Examples :

Input: n = 7
Output: true
Explanation: 7 has exactly two divisors: 1 and 7, making it a prime number.


Input: n = 25
Output: false
Explanation: 25 has more than two divisors: 1, 5, and 25, so it is not a prime number.</description>
    <notes></notes>
    <status>Completed</status>
    <level>Easy</level>
    <companies></companies>
    <remarks></remarks>
    <concepts></concepts>
    <date>2026-05-12</date>
</metadata>
*/



class Solution {
    static boolean isPrime(int n) {
        // code here
        if(n<=1){
            return false;
        }
        if(n==2){
            return true;
        }
        for(int i=2;i<=Math.sqrt(n);i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }
}
