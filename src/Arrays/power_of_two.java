/*
<metadata>
    <name>Power of Two</name>
    <url>https://leetcode.com/problems/power-of-two/</url>
    <description></description>
    <notes></notes>
    <status>In Progress</status>
    <level>Easy</level>
    <companies></companies>
    <remarks></remarks>
    <concepts></concepts>
    <date>2026-05-11</date>
</metadata>

*/
        class Solution {

    public boolean isPowerOfTwo(int n) {

        return (n > 0) && ((n & (n - 1)) == 0);

    }

}
        