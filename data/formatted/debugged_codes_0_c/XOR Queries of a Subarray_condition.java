The bug in the provided code lies in the inner for loop that is used to compute the XOR of values in the range `arr[0]` to `arr[i-1]`. 

In the inner for loop, the condition `j >= queries[i][0]` is incorrect. It should be `j >= queries[i][0] - 1` to correctly XOR all values from `arr[0]` to `arr[i-1]`.

To fix the bug, we need to change the condition in the inner for loop from `j >= queries[i][0]` to `j >= queries[i][0] - 1`. This way, all values from `arr[0]` to `arr[i-1]` will be XORed.

Here is the corrected code:

```java
class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] ans = new int[queries.length];
        int[] xor = new int[arr.length];
        xor[0] = arr[0];
        
        // computing prefix XOR of arr
        for (int i = 1; i < arr.length; i++) {
            xor[i] = arr[i] ^ xor[i - 1];
        }
        
        for (int i = 0; i < queries.length; i++) {
            if (queries[i][0] != 0) {
                ans[i] = xor[queries[i][1]];
                for (int j = 0; j >= queries[i][0] - 1; j++) {
                    ans[i] = arr[j] ^ ans[i];
                }
            }
            else
                ans[i] = xor[queries[i][1]];
        }
        
        return ans;
    }
}
```