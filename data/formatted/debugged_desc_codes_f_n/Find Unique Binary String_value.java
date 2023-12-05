Fix:
```java
class Solution {
    public String findDifferentBinaryString(String[] nums) {
        char[] ans = new char[nums.length];
        for (int i = 0; i < nums.length; i++)
            ans[i] = (nums[i].charAt(i) == '0' ? '1' : '0');   // Using ternary operator
        return new String(ans);
    }
}
```