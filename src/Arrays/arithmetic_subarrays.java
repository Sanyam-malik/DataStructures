/*
<metadata>
<name>Arithmetic Subarrays</name>
<description>A sequence of numbers is called arithmetic if it 
consists of at least two elements, and the difference between every two 
consecutive elements is the same. More formally, a sequence s is arithmetic if and only if s[i+1] - s[i] == s[1] - s[0] for all valid i.

For example, these are arithmetic sequences:

1, 3, 5, 7, 9
7, 7, 7, 7
3, -1, -5, -9

The following sequence is not arithmetic:

1, 1, 2, 5, 7

You are given an array of n integers, nums, and two arrays of m integers each, l and r, representing the m range queries, where the ith query is the range [l[i], r[i]]. All the arrays are 0-indexed.

Return a list of boolean elements answer, where answer[i] is true if the subarray nums[l[i]], nums[l[i]+1], ... , nums[r[i]] can be rearranged to form an arithmetic sequence, and false otherwise.

 </description>
<url>https://leetcode.com/problems/arithmetic-subarrays/description/</url>
<status>Completed</status>
<date>2026-07-16</date>
<level>Medium</level>
</metadata>
*/
//Time: O(m * n log n) Space: O(n)
class Solution {

    // Checks if the given array can be rearranged into an arithmetic sequence
    public boolean check(int[] arr) {

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        // Store all elements for O(1) lookup
        Set<Integer> set = new HashSet<>();

        // Find minimum, maximum and store elements
        for (int num : arr) {
            min = Math.min(min, num);
            max = Math.max(max, num);
            set.add(num);
        }

        int n = arr.length;

        // Difference between consecutive elements should be an integer
        if ((max - min) % (n - 1) != 0) {
            return false;
        }

        int diff = (max - min) / (n - 1);

        // Special case: all numbers are equal
        if (diff == 0) {
            return set.size() == 1;
        }

        // Check if every expected value exists
        for (int value = min; value <= max; value += diff) {
            if (!set.contains(value)) {
                return false;
            }
        }

        return true;
    }

    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {

        List<Boolean> answer = new ArrayList<>();

        for (int i = 0; i < l.length; i++) {

            int size = r[i] - l[i] + 1;
            int[] subArray = new int[size];

            // Copy the required subarray
            for (int j = 0; j < size; j++) {
                subArray[j] = nums[l[i] + j];
            }

            answer.add(check(subArray));
        }

        return answer;
    }
}

/**
//Time: O(m * n log n) Space: O(n)
class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> ans = new ArrayList<>();
        for (int i = 0; i < l.length; ++i) {
            int[] temp = new int[r[i] - l[i] + 1];
            int k = 0;
            for (int j = l[i]; j <= r[i]; ++j)
                temp[k++] = nums[j];
            ans.add(check(temp));
        }
        return ans;
    }

    boolean check(int[] arr) {
        if (arr.length <= 2)
            return true;
        Arrays.sort(arr);
        int diff = arr[1] - arr[0];
        for (int i = 2; i < arr.length; ++i) {
            if (arr[i] - arr[i - 1] != diff)
                return false;
        }
        return true;
    }
}*/