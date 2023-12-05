There is an issue with the code as the value is always being added using index 2:
```java
ll.add(nums[2]);
```
It should be using the loop index 'i':
```java
ll.add(nums[i]);
```

Here's the corrected code:

```java
class Solution {
    ArrayList<Integer> ll = new ArrayList<>();

    public Solution(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            ll.add(nums[i]);
        }
    }

    public int pick(int target) {
        double a = Math.random();
        int n = (int) (a * this.ll.size());
        while (this.ll.get(n) != target) {
            a = Math.random();
            n = (int) (a * this.ll.size());
        }
        return n;
    }
}
```