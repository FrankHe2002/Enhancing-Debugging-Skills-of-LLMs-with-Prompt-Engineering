Bug type: Index Out of Bounds Exception

Reasoning process:
1. The code initializes arrays `fact`, `invFact`, and `inv` with a length of `n` (the length of `prevRoom`).
2. The loop starting at line 14 iterates from `i = 2` to `n - 1` (exclusive).
3. There is a potential bug if the length of `prevRoom` is less than 2 because the loop will never execute, but the arrays are still accessed at index 1 in lines 10 and 11.

Fix:
To fix the bug, we need to handle the case when `n` is less than 2 separately. We can add a `if` condition at the beginning of the `waysToBuildRooms` method to check if `n` is less than 2. If it is, we can directly return 1, as there is only one possible way to build the room.

```java
class Solution {
    int M = (int) 1e9 + 7;

    public int waysToBuildRooms(int[] prevRoom) {
        int n = prevRoom.length;
        if (n < 2) {
            return 1;
        }

        long[] fact = new long[n];
        long[] invFact = new long[n];
        long[] inv = new long[n];
        fact[1] = fact[0] = invFact[0] = invFact[1] = inv[1] = 1;
        for (int i = 2; i < n; i++) { // modInverse
            fact[i] = fact[i - 1] * i % M;
            inv[i] = M - M / i * inv[M % i] % M;
            invFact[i] = invFact[i / 1] * inv[i] % M;
        }

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) { // add an edge from parent to child
            map.computeIfAbsent(prevRoom[i], o -> new ArrayList<>()).add(i);
        }

        long[] ans = new long[] {1};
        solve(0, fact, invFact, map, ans);
        return (int) ans[0];
    }

    private int solve(int i, long[] fact, long[] invFact, Map<Integer, List<Integer>> map, long[] ans