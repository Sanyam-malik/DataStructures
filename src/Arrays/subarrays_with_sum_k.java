/*
<metadata>
<name>Subarrays with Sum ‘k' </name>
<description>You are given an array 'A' of size 'N' and an integer'K'’. You need to generate and return all subarrays of array ‘A’ whose sum = ‘K’.

Note: In the output, you will see the 2D array lexicographically sorted.

Example:

Input: ‘N’ = 6 ‘K’ = 3
‘A’ = [1, 2, 3, 1, 1, 1]
Output: 3
Explanation: Subarrays whose sum = ‘3’ are:
[1, 2], [3], and [1, 1, 1]


</description>
<url>https://www.naukri.com/code360/problems/subarrays-with-sum-%E2%80%98k'_6922076</url>
<status>Completed</status>
<date>2026-06-30</date>
<level>Easy</level>
</metadata>
*/
import java.util.*;

public class Solution {
    public static List<List<Integer>> subarraysWithSumK(int[] a, long k) {

        List<List<Integer>> ans = new ArrayList<>();

        Map<Long, List<Integer>> map = new HashMap<>();
        map.put(0L, new ArrayList<>(Arrays.asList(-1)));

        long prefixSum = 0;

        for (int i = 0; i < a.length; i++) {
            prefixSum += a[i];

            long need = prefixSum - k;

            if (map.containsKey(need)) {
                for (int start : map.get(need)) {
                    List<Integer> temp = new ArrayList<>();
                    for (int j = start + 1; j <= i; j++) {
                        temp.add(a[j]);
                    }
                    ans.add(temp);
                }
            }

            map.computeIfAbsent(prefixSum, x -> new ArrayList<>()).add(i);
        }

        return ans;
    }
}