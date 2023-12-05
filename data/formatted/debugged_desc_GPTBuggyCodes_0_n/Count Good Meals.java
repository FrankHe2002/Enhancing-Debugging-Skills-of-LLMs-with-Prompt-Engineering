```java
class Solution {
    int mod = 1000000007;

    public int countPairs(int[] deliciousness) {
        Map<Integer, Integer> map = new HashMap<>();
        long res = 0;
        for (int num : deliciousness) {
            for (int i = 0; i < 22; i++) {
                int power = 1 << i;
                if (map.containsKey(power - num)) {
                    res += map.get(power - num);
                    res %= mod;
                }
            }
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        return (int) (res % mod);
    }
}
```