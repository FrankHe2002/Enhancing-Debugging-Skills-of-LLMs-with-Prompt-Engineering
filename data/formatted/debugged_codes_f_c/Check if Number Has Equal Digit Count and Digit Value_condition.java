The bug in the provided code is found in the third for loop's condition. The condition `i >= 10` causes the loop to never execute because it starts with `i = 0`, which is less than 10. The correct condition should be `i < 10` to iterate over the `freqArr` array.

Additionally, the second for loop incorrectly updates the `freqArr` array using the index `i`, which should instead be using the digit value `ch - '0'`.

Fixed Code:
```java
class Solution {
    public boolean digitCount(String num) {
        int[] freqArr = new int[10];  // n = 10 given in constraints;

        for (char ch : num.toCharArray()) {
            freqArr[ch - '0']++;
        }

        for (int i = 0; i < num.length(); i++) {
            int freq = num.charAt(i) - '0';  //freq of each indexValue;
            freqArr[freq] = freqArr[freq] - freq;
        }

        for (int i = 0; i < 10; i++) {
            if (freqArr[i] != 0) {
                return false;
            }
        }

        return true;
    }
}
```