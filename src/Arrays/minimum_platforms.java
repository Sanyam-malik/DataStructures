/*
<metadata>
<name>Minimum Platforms</name>
<url>https://www.geeksforgeeks.org/problems/minimum-platforms-1587115620/1</url>
<status>Completed</status>
<date>2026-07-07</date>
<level>Medium</level>
<notes>#### Brute Force

import java.util.*;

class Solution {
    static int findPlatform(int arr[], int dep[]) {

        int n = arr.length;
        int answer = 0;

        for (int i = 0; i < n; i++) {

            int platforms = 1; // current train itself

            for (int j = 0; j < n; j++) {

                if (i != j) {

                    // Check if train j overlaps with train i
                    if (arr[j] <= dep[i] && arr[i] <= dep[j]) {
                        platforms++;
                    }
                }
            }

            answer = Math.max(answer, platforms);
        }

        return answer;
    }
}
</notes>
<companies>Paytm:Amazon:Microsoft:Hike:Walmart:adobe:Google:Atlassian:NPCI</companies>
</metadata>
*/
import java.util.*;

class Solution {
    static int findPlatform(int arr[], int dep[]) {

        int n = arr.length;
        int answer = 0;

        for (int i = 0; i < n; i++) {

            int platforms = 1; // current train itself

            for (int j = 0; j < n; j++) {

                if (i != j) {

                    // Check if train j overlaps with train i
                    if (arr[j] <= dep[i] && arr[i] <= dep[j]) {
                        platforms++;
                    }
                }
            }

            answer = Math.max(answer, platforms);
        }

        return answer;
    }
}