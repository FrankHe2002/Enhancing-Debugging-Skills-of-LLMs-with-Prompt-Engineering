```java
class Solution {
    ArrayList<Integer> ll = new ArrayList<>();

    public Solution(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            ll.add(nums[i]);
        }
    }

    public int pick(int target) {
        List<Integer> indexes = new ArrayList<>();
        for (int i = 0; i < ll.size(); i++) {
            if (ll.get(i) == target) {
                indexes.add(i);
            }
        }
        
        double a = Math.random();
        int n = (int) (a * indexes.size());
        return indexes.get(n);
    }
}
```