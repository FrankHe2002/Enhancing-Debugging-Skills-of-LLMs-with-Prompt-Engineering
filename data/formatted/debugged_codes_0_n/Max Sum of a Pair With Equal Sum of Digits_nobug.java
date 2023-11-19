```java
// Runtime: 2 ms (Top 89.67%) | Memory: 47.7 MB (Top 95.18%)
class Solution {
    public int maximumSum(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int result = -1;

        for (int item : nums) {
            int key = getNumberTotal(item);

            if (!map.containsKey(key))
                map.put(key, item);
            else {
                result = Math.max(result, map.get(key) + item);
                map.put(key, Math.max(map.get(key), item));
            }
        }

        return result;
    }

    int getNumberTotal(int num) {
        int result = 0;
        while (num != 0) {
            result += Math.abs(num % 10);
            num /= 10;
        }

        return result;
    }
}
```