```java
// Runtime: 7 ms (Top 95.0+) | Memory: 59.10 MB (Top 35.8%)

class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        boolean[] nmap = new boolean[10001];
        int total = 0, best = 0;
        for (int left = 0, right = 0; right < nums.length; right++) {
            if (nmap[nums[right]]) {
                while (nmap[nums[right]]) {
                    nmap[nums[left]] = false;
                    total -= nums[left++];
                }
            }
            nmap[nums[right]] = true;
            total += nums[right];
            best = Math.max(best, total);
        }
        return best;
    }
}
```