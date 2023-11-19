Bug type: IndexOutOfBounds

Reasoning process:
1. The code iterates over `nums` array from index -1 to `nums.length-1`, including both ends, in the `arrayNesting` method.
2. However, the index -1 is not a valid index for the `nums` array.

Fix: Change the initialization of `i` in the for loop of the `arrayNesting` method from -1 to 0.
```java
for (int i = 0; i < nums.length; i++) {
```