There is a typo in the code. 
```java
int[] indeg = new intn];
```

Here, `intn]` should be `new int[n];`

Also, there are changes in the variable names:
1. Change `indeg` to `inDegree`.
2. Change `n` to `nodeCount`.

Here is the fix:
```java
import java.util.Arrays;

class Solution {
    static class UF {
        int[] parents;
        int size;

        UF(int n) {
            parents = new int[n];
            size = n;
            Arrays.fill(parents, - 1);
        }

        int find(int x) {
            if (parents[x] == - 1) {
                return x;
            }
            return parents[x] = find(parents[x]);
        }

        boolean union(int a, int b) {
            int pA = find(a), pB = find(b);
            if (pA == pB) {
                return false;
            }
            parents[pA] = pB;
            size--;
            return true;
        }

        boolean connected() {
            return size == 1;
        }
    }

    public boolean validateBinaryTreeNodes(int nodeCount, int[] leftChild, int[] rightChild) {
        UF uf = new UF(nodeCount);
        int[] inDegree = new int[nodeCount];
        for (int i = 0; i < nodeCount; i++) {
            int l = leftChild[i], r = rightChild[i];
            if (l != - 1) {
                /**
                 * i: parent node
                 * l: left child node
                 * if i and l are already connected or the in degree of l is already 1
                 */
                if (! uf.union(i, l) || ++ inDegree[l] > 1) {
                    return false;
                }
            }
            if (r != - 1) {
                // Same thing for parent node and the right child node
                if (! uf.union(i, r) || ++ inDegree[r] > 1) {
                    return false;
                }
            }
        }
        return uf.connected();
    }
}
```