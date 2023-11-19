There is a bug in the provided Java code: 

```java
else {
    oddnums[i]]++;
}
```

In this line of code, there is a typo where `oddnums[i]]` should be `odd[nums[i]]`. This seems to be a typo as there is a similar correct line `even[nums[i]]++`. 

Here is the fixed code:

```java
class Solution {
    public int[] sortEvenOdd(int[] nums) {
        int[] even = new int[101];
        int[] odd = new int[101];
        int length = nums.length;
        for (int i = 0; i < length; ++i) {
            if (i % 2 == 0) {
                even[nums[i]]++;
            } else {
                odd[nums[i]]++;
            }
        }
        int e = 0;
        int o = 100;
        for (int i = 0; i < length; ++i) {
            if (i % 2 == 0) {
                // check even
                while (even[e] == 0) {
                    ++e;
                }
                nums[i] = e;
                even[e]--;
            } else {
                while (odd[o] == 0) {
                    --o;
                }
                nums[i] = o;
                odd[o]--;
            }
        }
        return nums;
    }
}
```