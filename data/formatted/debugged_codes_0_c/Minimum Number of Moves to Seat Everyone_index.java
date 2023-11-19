The bug in the provided Java code is in the for loop condition. When calculating the 'diff' value, the code attempts to access 'students[i + 1]' which will result in an ArrayIndexOutOfBoundsException since the loop iteration goes up to 'seats.length' which is equal to the length of 'seats' array. However, the 'students' array might have a different length than 'seats', which can cause the exception.

To fix this bug, we need to change the loop condition to iterate up to the minimum length of 'seats' and 'students' arrays. This will ensure that we only access valid elements in both arrays. 

Here's the fixed code:

```java
class Solution {
    public int minMovesToSeat(int[] seats, int[] students) {
        Arrays.sort(seats);
        Arrays.sort(students);
        int diff = 0;
        int length = Math.min(seats.length, students.length);
        for (int i = 0; i < length; i++) {
            diff += Math.abs(students[i] - seats[i]);
        }
        return diff;
    }
}
```

This code fixes the bug by calculating the minimum length of 'seats' and 'students' arrays and using it as the loop condition. It then calculates the 'diff' value by subtracting the respective elements from 'students' and 'seats' arrays.