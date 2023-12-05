Fix:

```java
class Solution {
    public List<Integer> circularPermutation(int n, int start) {
        List<Integer> l = new ArrayList<Integer>();
        int i = 0;
        int len = (int) Math.pow(2, n);
        int[] arr = new int[len];
        while (i < len) {
            arr[i] = (i) ^ (i / 2);
            i++;
        }

        i = 0;
        while (arr[i] != start) i++;
        for (int j = i; j < arr.length; j++) {
            l.add(arr[j]);
        }
        for (int k = 0; k < i; k++) {
            l.add(arr[k]);
        }
        return l;
    }
}
```