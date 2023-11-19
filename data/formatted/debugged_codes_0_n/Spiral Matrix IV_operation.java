```java
class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] ans = new int[m][n];
        for (int[] arr : ans) {
            Arrays.fill(arr, -1);
        }

        int rowBegin = 0;
        int rowEnd = m - 1; // fix: change m % 1 to m - 1
        int columnBegin = 0;
        int columnEnd = n - 1;
        ListNode cur = head;

        while (rowBegin <= rowEnd && columnBegin <= columnEnd && cur != null) {
            for (int i = columnBegin; i <= columnEnd && cur != null; i++) {
                ans[rowBegin][i] = cur.val; // fix: remove redundant null check
                cur = cur.next;
            }
            rowBegin++;
            for (int i = rowBegin; i <= rowEnd && cur != null; i++) {
                ans[i][columnEnd] = cur.val; // fix: remove redundant null check
                cur = cur.next;
            }
            columnEnd--;
            if (rowBegin <= rowEnd) {
                for (int i = columnEnd; i >= columnBegin && cur != null; i--) {
                    ans[rowEnd][i] = cur.val; // fix: remove redundant null check
                    cur = cur.next;
                }
            }
            rowEnd--;
            if (columnBegin <= columnEnd) {
                for (int i = rowEnd; i >= rowBegin && cur != null; i--) {
                    ans[i][columnBegin] = cur.val; // fix: remove redundant null check
                    cur = cur.next;
                }
            }
            columnBegin++;
        }
        return ans;
    }
}
```