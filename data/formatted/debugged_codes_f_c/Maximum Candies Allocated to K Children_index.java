Bug Type: ArrayIndexOutOfBoundsException

Reasoning: In the method `canSplit`, the loop condition `i < candies.length` is correct, but inside the loop, the code attempts to access `candies[i + 2]`, which can cause an `ArrayIndexOutOfBoundsException`. This is because `i + 2` can exceed the array's bounds when `i` reaches the last two indices (`candies.length - 2` and `candies.length - 1`).

Fix: Change `candies[i + 2]` to `candies[i]` to correctly access the current element in the array.
