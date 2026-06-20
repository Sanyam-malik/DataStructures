/*
<metadata>
<name>Find All Numbers Disappeared in an Array</name>
<description>Given an array nums of n integers where nums[i] is in the range [1, n], return an array of all the integers in the range [1, n] that do not appear in nums.

 

Example 1:

Input: nums = [4,3,2,7,8,2,3,1]
Output: [5,6]

Example 2:

Input: nums = [1,1]
Output: [2]

 

Constraints:

n == nums.length
1 <= n <= 105
1 <= nums[i] <= n

 

Follow up: Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.</description>
<url>https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/description/</url>
<status>Completed</status>
<date>2026-05-19</date>
<level>Easy</level>
<notes>Solution 1

The solution doesn't meet follow-up question. But it's good idea to think about multiple solutions for real interviews.

In this problem, we are given an array of integers where each integer is in the range [1, n]. Our goal is to find all the integers that do not appear in the array.

When you first encounter this problem, the most straightforward (brute-force) method is to check every number from 1 to n and see if it exists in the input array. However, checking existence in a list results in O(n2) time complexity, which is too slow for large inputs.

To optimize, we ask: "How can we make the existence check faster?"

Leveraging Hash Sets: In Python, searching for an element in a set takes O(1) time on average.
The Trade-off: By converting the list into a set, 
we use a bit more memory (Space Complexity) to gain a massive boost in 
execution speed (Time Complexity).

2. How the Algorithm Works

The solution follows a simple two-step logic:

Create a Set: Convert the input list nums into a set called numbers. This removes duplicates and allows for near-instant lookups.
Iterate and Filter: Loop through the range of integers from 1 to n  (where is the length of the original array).

For each number, check: "Is this number in my set?"
If the answer is No, then this is a "disappeared" number, and we append it to our result list.

Complexity

Time complexity: O(n)

Space complexity: O(n)

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= nums.length; i++) {
            if (!numSet.contains(i)) {
                result.add(i);
            }
        }

        return result;        
    }
}

Solution 2

If you solve this problem using a Set, an interviewer might follow up with a deeper question: "Can you solve this without using extra memory?"

While the Set-based approach is intuitive, it requires additional space. This alternative solution achieves O(1)
 space complexity by using a technique called "In-place Marking," where 
we treat the input array itself as our record-keeping board.

The crucial hint in this problem is that the numbers in the array stay within the range of 1 to n. This perfectly corresponds to the array's indices from 0 to n - 1.

A Shift in Perspective: If we encounter the number 3, it corresponds to index 2. We can ask ourselves: "Can we mark the value at index 2 as 'seen' without losing the original data?"

My strategy is to make the original number negative.

How It Works

Let’s look at how this algorithm transforms the array using the input:

nums = [4, 3, 2, 7, 8, 2, 3, 1]

When i = 0: nums[0] is 4. The corresponding index is 4 - 1 = 3.

We mark nums[3] (which is 7) by making it negative

[4, 3, 2, -7, 8, 2, 3, 1]

When i = 1: nums[1] is 3. The corresponding index is 3 - 1 = 2.

We mark nums[2] (which is 2) by making it negative

[4, 3, -2, -7, 8, 2, 3, 1]

Everything looks good so far. However, when we get to i = 2, we hit a snag. The current value of nums[2] is -2, because we just made it negative in the previous step.

If we try to calculate the index normally, we get -2 - 1 = -3. This points to nums[-3] (the third element from the end), rather than the intended "value 2 at index 1." The algorithm breaks down here.

⭐️ Points

The problem is that once we overwrite a value with a negative sign, 
the original positive value seems to "disappear" for future iterations.

The Strategy: Using Absolute Values

How can we avoid this? My strategy is to use Absolute Values.

The issue is that when we reference values in the loop, they might 
have already been flipped to negative numbers. We are using the negative
 sign as a flag to check existence, but we aren't actually changing the 
underlying number (e.g., 2 becomes -2, 7 becomes -7).

By taking the absolute value of -2, we get back to the original 2. This allows us to retrieve the original data even after it has been marked.

Final Result

Continuing this algorithm to the end, the nums array eventually becomes:

[-4, -3, -2, -7, 8, 2, -3, -1]

Now the setup is complete. We can easily find the missing numbers between  1 and n.

We simply loop through nums one more time. Any index containing a number greater than 0 means that index was never "marked" (no number pointing to it appeared in the input).

In this case, the positive values are at index 4 and index 5:

index 4 + 1 = 5
index 5 + 1 = 6

return [5, 6]

Complexity

Time complexity: O(n)

Space complexity: O(1)

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int idx = Math.abs(nums[i]) - 1;
            if (nums[idx] > 0) {
                nums[idx] = -1;
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                result.add(i + 1);
            }
        }
        return result;        
    }
}</notes>
<companies>Apple:Amazon:Facebook:Microsoft</companies>
</metadata>
*/
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int idx = Math.abs(nums[i]) - 1;
            if (nums[idx] > 0) {
                nums[idx] *= -1;
            }
        }
        
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                result.add(i + 1);
            }
        }
        return result;        
    }
}