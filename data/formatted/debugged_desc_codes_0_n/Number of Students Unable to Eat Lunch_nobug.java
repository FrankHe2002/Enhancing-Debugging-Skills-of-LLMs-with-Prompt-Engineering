```java
// Runtime: 0 ms (Top 100.00%) | Memory: 41.4 MB (Top 83.22%)
class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int ones = 0; //count of students who prefer type1
        int zeros = 0; //count of students who prefer type0

        for (int stud : students) {
            if (stud == 0) zeros++;
            else ones++;
        }

        // Iterate over each sandwich in sandwiches
        for (int sandwich : sandwiches) {
            if (sandwich == 0) { // if the sandwich is of type0
                if (zeros == 0) { // if no student wants a type0 sandwich
                    return ones;
                }
                zeros--;
            } else { // if the sandwich is of type1
                if (ones == 0) { // if no student wants a type1 sandwich
                    return zeros;
                }
                ones--;
            }
        }
        return 0;
    }
}
```