```java
class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        int max = 1;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int target = arr[i] - difference;
            int currAns = map.getOrDefault(target, 0) + 1;
            map.put(arr[i], currAns);
            max = Math.max(max, currAns);
        }
        return max;
    }
}
```