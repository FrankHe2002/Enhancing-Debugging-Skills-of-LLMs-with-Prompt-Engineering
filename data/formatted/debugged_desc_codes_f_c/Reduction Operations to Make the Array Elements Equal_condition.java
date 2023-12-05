The bug types found in the examples are:
Example #1: Off-by-one error (loop condition)
Example #2: Syntax error (missing semicolon)
Example #3: Logical error (operation) 
Example #4: Logical error (condition)
Example #5: Logical error (condition)

Fixing the code identified and explained in the examples, the final fixed code is presented below in markdown format:

```java
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

class Solution {
    public int findMax(int[] nums) {
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        return max;
    }
}

class Solution {
    public String repeatChar(char c, int times) {
        String result = "";
        for (int i = 0; i < times; i++) {
            result += c;
        }
        return result;
    }
}

class Solution {
    public int multiply(int a, int b) {
        return a * b;
    }
}

class Solution {
    public boolean isEven(int num) {
        return num % 2 == 0;
    }
}

class Solution {
    public boolean isLeapYear(int year) {
        if ((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0)) {
            return true;
        }
        return false;
    }
}

class Solution {
    public int reductionOperations(int[] nums) {
        Map<Integer, Integer> valMap = new TreeMap<>(Collections.reverseOrder());

        for (int i = 0; i < nums.length; i++) {
            valMap.put(nums[i], valMap.getOrDefault(nums[i], 0) + 1);
        }

        int mapSize = valMap.size();
        int opsCount = 0;
        for (Map.Entry<Integer, Integer> entry : valMap.entrySet()) {
            opsCount += entry.getValue() * (--mapSize);
        }
        return opsCount;
    }
}
```