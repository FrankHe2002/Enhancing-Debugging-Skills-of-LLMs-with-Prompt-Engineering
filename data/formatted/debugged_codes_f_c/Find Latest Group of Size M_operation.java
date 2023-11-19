Bug Type: Array Index Out of Bounds

Reasoning: In the `findLatestStep` method, the `size` array is initialized with `new int[n % 1]`, which results in an empty array since `n % 1` is always 0. This leads to an ArrayIndexOutOfBoundsException when trying to access elements of the `size` array. Additionally, the `bits` array is initialized with a size of `n + 2`, but the elements are accessed using indices `idx - 1` and `idx + 1`, which can also cause an ArrayIndexOutOfBoundsException if `idx` is at the boundary of the array.

Fix:
1. Change `size = new int[n % 1]` to `size = new int[n + 1]` to ensure the `size` array can store `n` elements.
2. Change `bits = new int[n + 2]` to `bits = new int[n + 1]` to align the array size with the usage in the code.

Fixed Code:

```java
class Solution {
    int[] par, size, count, bits;
    // par: parent array, tells about whose it the parent of ith element
    // size: it tells the size of component
    // count: it tells the count of islands (1111 etc) of size i;
    // count[3] = 4: ie -> there are 4 islands of size 3

    public int find(int u) {
        if (u == par[u]) return u;
        par[u] = find(par[u]);
        return par[u];
    }

    public void union(int u, int v) {
        // union is performed over parents of elements not nodes itself
        int p1 = find(u), p2 = find(v);
        if (p1 == p2) return;

        // decrease the count of islands of size p1, p2
        count[size[p1]]--;
        count[size[p2]]--;

        // now merge
        par[p2] = p1;

        // adjust sizes
        size[p1] += size[p2];

        // adjust the count of islands of new size ie: size of p1
        count[size[p1]]++;
    }

    public int findLatestStep(int[] arr, int m) {
        int n = arr.length;
        par = new int[n + 1];
        size = new int[n + 1];
