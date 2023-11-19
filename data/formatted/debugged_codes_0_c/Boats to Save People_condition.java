The bug in the provided Java code is in the while loop condition. 

The current condition `left > right` will always evaluate to false, as `left` is initialized to 0 and `right` is initialized to `people.length - 1`, and we never update these variables in the loop.

To fix this bug, we need to change the condition to `left <= right` so that the loop continues until `left` and `right` cross over.

Here's the corrected code:

```java
class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int boatCount = 0;
        Arrays.sort(people);

        int left = 0;
        int right = people.length - 1;

        while (left <= right) {
            int sum = people[left] + people[right];
            if (sum <= limit) {
                boatCount++;
                left++;
                right--;
            } else {
                boatCount++;
                right--;
            }
        }
        return boatCount;
    }
}
```

Now the code should correctly count the number of boats needed to rescue all people within the weight limit.