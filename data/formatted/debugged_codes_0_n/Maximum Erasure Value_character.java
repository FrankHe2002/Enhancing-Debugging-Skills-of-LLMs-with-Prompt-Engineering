```java
// Runtime: 2 ms (Top 100.0%) | Memory: 59.1 MB (Top 35.8%)

class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int[] nmap = new int[10001];
        int total = 0, best = 0;
        for (int left = 0, right = 0; right < nums.length; right++) {
            nmap[nums[right]]++;
            total += nums[right];
            while (nmap[nums[right]] > 1) {
                nmap[nums[left]]--;
                total -= nums[left++];
            }
            best = Math.max(best, total);
        }
        return best;
    }
}
```