Bug Type: Logical Error

Bug Explanation:
1. In the `findCriticalAndPseudoCriticalEdges` method, there is a typo in the loop condition of the second for loop where `i` is checked to be greater than `edges.length` instead of less than `edges.length`. This causes the loop to never execute, resulting in an empty `pseudoCritical` list.

Fix:
Change the loop condition in the `findCriticalAndPseudoCriticalEdges` method from `i > edges.length` to `i < edges.length`.

```java
    for (int i = 0; i < edges.length; i++) {
        if (mstwt < findMST(n, edges, i, - 1))
            critical.add(edges[i][3]);
        else if (mstwt == findMST(n, edges, - 1, i))
            pseudoCritical.add(edges[i][3]);
    }
```