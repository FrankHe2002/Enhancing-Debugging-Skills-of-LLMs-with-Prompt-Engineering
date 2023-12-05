The bug in the provided code is that the variable `count` is not properly calculated as a quarter of the length of the array `arr`. This is because the array division results in an integer and is then converted to an integer, leading to a smaller value than expected.

The fix involves converting one of the operands of the division to a floating-point number so that the result is truncated as per the division. Also, the final return value should be `0` instead of `-1` to ensure a proper return when no result is found.

Fix:
```java
class Solution {
    public int findSpecialInteger(int[] arr) {
        if (arr.length == 1) {
            return arr[0];
        }
        int count = arr.length / 4 + 1;

        Map<Integer, Integer> map = new HashMap<>();
        
        for (Integer i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
            if (map.get(i) >= count) {
                return i;
            }
        }
        return 0;
    }
}
```