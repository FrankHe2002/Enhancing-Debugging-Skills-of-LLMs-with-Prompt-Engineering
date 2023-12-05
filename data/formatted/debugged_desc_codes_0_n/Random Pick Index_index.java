```java
import java.util.ArrayList;

class Solution {
    ArrayList<Integer> ll = new ArrayList<>();

    public Solution(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            ll.add(nums[i]);
        }
    }

    public int pick(int target) {
        ArrayList<Integer> indices = new ArrayList<>();
        for (int i = 0; i < ll.size(); i++) {
            if (ll.get(i) == target) {
                indices.add(i);
            }
        }
        double a = Math.random();
        int n = (int) (a * indices.size());
        return indices.get(n);
    }
}
```