```java
/* Intuition:
As the number of elements is 10^9 so we can't actually create the array
And by seeing the limit we can judge that the complexity should be O(logn)
So it will become obvious that binary search can only help to solve this prob

We have to put the maximum possible value in the index position and then all 
the values to its right and left should decrease by 1 until the value reaches 1
for Ex in n = 6, index = 1,  maxSum = 10

our index at 1 should be 3 and the array will look like
2  3  2 1 1
+ max - - same

means you have to make an array which is strictly increasing and it attains its max (which is answer)
then strictly decreasing till value becomes 1 and then continues it as 1. Like
1 ... 1, 2, 3, 4, 5, 6(if answer is 6), 5, 4, 3, 2, 1, .... 1

Why this solution?
Because our objective is to maximize our index position value i.e. ans. So to maximize it
we all the other elements other than index position should be as low as possible (so that sum of our array
is less than maxSum), which will lead to this solution of "Get the max element on index given and decrease strictly
on both sides of the array till our value is 1, and then continue it to 1"
*/

class Solution {
    public int maxValue(int n, int index, int maxSum) {
        // Setting the initial values is very important, our ans can never be 0 so set low as 1
        int low = 1, mid = 0, high = 1000000000;
        while (low <= high) {
            mid = (low + high) / 2;

            // If our ans (which is mid) is making the sum of array more than maxSum means we have to decrease our high
            if (calcAns(mid, index, n) < maxSum) {
                high = mid - 1;
            }

            // If our ans (which is mid) is so low that even ans + 1 (i.e. mid + 1) is giving better result that means increase our low
            else if (calcAns(mid + 1, index