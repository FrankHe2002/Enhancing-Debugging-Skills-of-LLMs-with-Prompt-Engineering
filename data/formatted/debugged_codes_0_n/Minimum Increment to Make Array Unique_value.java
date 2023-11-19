```java
import java.util.Arrays;

class Solution {
    public int minIncrementForUnique(int[] nums) {

        //Approach - 1 : Using a Count array

        // TC : O(N)
        // SC : O(N)

        int max = 0;
        for (int i : nums)
            max = Math.max(max, i);

        int count[] = new int[nums.length + max];

        for (int c : nums)
            count[c]++;

        int answer = 0, chosen = 0;
        int len = count.length;

        for (int i = 0; i < len; i++) {
            if (count[i] >= 2) {
                chosen += count[i] - 1;
                answer -= i * (count[i] - 1);
            } else if (chosen > 0 && count[i] == 0) {
                answer += i;
                chosen--;
            }
        }
        
        //Approach - 2:

        // TC : O(nlogn)
        // SC : O(1)

        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] >= nums[i]) {
                answer += nums[i - 1] - nums[i] + 1;
                nums[i] = nums[i - 1] + 1;
            }
        }
        return answer;
    }
}
```