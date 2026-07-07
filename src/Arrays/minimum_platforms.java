/*
<metadata>
<name>Minimum Platforms</name>
<description>Given arrival arr[] and departure dep[] times of trains on the same day, find the minimum number of platforms needed so that no train waits. 

A platform cannot serve two trains at the same time; if a train arrives before another departs, an extra platform is needed.

Note: Time intervals are in the 24-hour format (HHMM) ,
 where the first two characters represent hour (between 00 to 23 ) and 
the last two characters represent minutes (this will be <= 59 and 
>= 0). Leading zeros for hours less than 10 are optional (e.g., 0900 is the same as 900).


Examples:
Input: arr[] = [900, 940, 950, 1100, 1500, 1800], dep[] = [910, 1200, 1120, 1130, 1900, 2000]
Output: 3
Explanation: There are three trains during the time 9:40 to 12:00. So we need a minimum of 3 platforms.

Input: arr[] = [900, 1235, 1100], dep[] = [1000, 1240, 1200]
Output: 1
Explanation: All train times are mutually exclusive. So we need only one platform.

Input: arr[] = [1000, 935, 1100], dep[] = [1200, 1240, 1130]
Output: 3
Explanation: All 3 trains have to be there from 11:00 to 11:30</description>
<url>https://www.geeksforgeeks.org/problems/minimum-platforms-1587115620/1</url>
<status>Completed</status>
<date>2026-07-07</date>
<level>Medium</level>
<notes>#### Brute Force

import java.util.;

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
}</notes>
<companies>Paytm:Amazon:Microsoft:Hike:Walmart:Adobe:Google:Atlassian:Npci</companies>
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