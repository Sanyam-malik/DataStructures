/*
<metadata>
<name>Count Inversions</name>
<description>Given an array of integers arr[]. 

You have to find the Inversion Count of the array. Note : Inversion count is the number of pairs of elements (i, j) such that i < j and arr[i] > arr[j].

Examples:

Input: arr[] = [2, 4, 1, 3, 5]
Output: 3
Explanation: The sequence 2, 4, 1, 3, 5 has three inversions (2, 1), (4, 1), (4, 3).

Input: arr[] = [2, 3, 4, 5, 6]
Output: 0
Explanation: As the sequence is already sorted so there is no inversion count.

Input: arr[] = [10, 10, 10]
Output: 0
Explanation: As all the elements of array are same, so there is no inversion count.</description>
<url>https://www.geeksforgeeks.org/problems/inversion-of-array-1587115620/1</url>
<status>Completed</status>
<date>2026-07-07</date>
<level>Medium</level>
<notes># Brute Force Approach

## Idea
- Compare every element with every element to its right.
- If `arr[i] > arr[j]`, it forms an inversion.
- Increment the inversion count.

## Code Logic

```java
for (int i = 0; i < n; i++) {
    for (int j = i + 1; j < n; j++) {
        if (arr[i] > arr[j]) {
            count++;
        }
    }
}
```

## Why it Results in TLE

- The solution uses **two nested loops**.
- The outer loop runs `n` times.
- For each iteration, the inner loop runs approximately `(n - i - 1)` times.

Total number of comparisons:

```
(n - 1) + (n - 2) + ... + 2 + 1
= n(n - 1) / 2
```

Therefore, the time complexity is:

- **Time Complexity:** `O(n²)`
- **Space Complexity:** `O(1)`

### Example

If `n = 100000`:

```
Comparisons ≈ 100000 × 99999 / 2
            ≈ 5,000,000,000 (5 billion)
```

Executing billions of comparisons takes too long, causing the solution to exceed the time limit and resulting in a **Time Limit Exceeded (TLE)** error.

## Optimization

Instead of comparing every pair, use **Merge Sort** to count inversions while merging two sorted halves.

- **Optimized Time Complexity:** `O(n log n)`
- **Space Complexity:** `O(n)`</notes>
<companies>Flipkart:Amazon:Microsoft:Adobe:MakeMyTrip:Myntra</companies>
</metadata>
*/
class Solution {
    static int inversionCount(int arr[]) {
        return mergeSort(arr, 0, arr.length - 1);
    }

    static int mergeSort(int[] arr, int left, int right) {
        int count = 0;

        if (left < right) {
            int mid = left + (right - left) / 2;

            count += mergeSort(arr, left, mid);
            count += mergeSort(arr, mid + 1, right);
            count += merge(arr, left, mid, right);
        }

        return count;
    }

    static int merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];

        int i = left;
        int j = mid + 1;
        int k = 0;
        int count = 0;

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
                count += (mid - i + 1); // Count inversions
            }
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= right) {
            temp[k++] = arr[j++];
        }

        for (i = left, k = 0; i <= right; i++, k++) {
            arr[i] = temp[k];
        }

        return count;
    }
}