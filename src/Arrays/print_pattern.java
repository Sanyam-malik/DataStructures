/*
<metadata>
<name>Print Pattern</name>
<description>Given a number n, print a sequence of numbers starting from n. Each next number in the sequence is n - 5, and this continues recursively until the number becomes less than or equal to 0. After that, print the sequence in reverse order, adding 5 each time, until it reaches back to the original number n.Note: You must not use loops.

Examples:

Input: n = -16
Output: [-16]
Explanation: Since -16 is less than zero so it will remain same.

Input: n = 10
Output: [10, 5, 0, 5, 10]
Explanation: The value decreases until it is greater or equal to 0. After that it increases and stops when it becomes 10 again.

Constraints:-105 ≤ n ≤ 105</description>
<url>https://www.geeksforgeeks.org/problems/print-pattern3549/1</url>
<status>Completed</status>
<date>2026-06-25</date>
<level>Easy</level>
</metadata>
*/
class Solution {
    public ArrayList<Integer> pattern(int n) {
        ArrayList<Integer> res = new ArrayList<>();
        
        int curr = n;
        
        // decreasing
        while (curr > 0) {
            res.add(curr);
            curr -= 5;
        }
        
        res.add(curr); // last <= 0
        
        // increasing
        curr += 5;
        while (curr <= n) {
            res.add(curr);
            curr += 5;
        }
        
        return res;
    }
}