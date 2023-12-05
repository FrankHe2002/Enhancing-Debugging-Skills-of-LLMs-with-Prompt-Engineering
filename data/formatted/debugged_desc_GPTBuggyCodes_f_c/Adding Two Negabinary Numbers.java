The bug in the provided code is the logic used to calculate the carry value and current sum value. It's not in line with the definition of negabinary (a number is expressed in base -2, so sum can be 0, 1, -1, -2, 3) and should be corrected.

Fix:
```java
class Solution {
    public int[] addNegabinary(int[] arr1, int[] arr2) {

        List<Integer> result = new ArrayList();
        int pointer_1 = arr1.length - 1;
        int pointer_2 = arr2.length - 1;

        int carry = 0;

        while (pointer_1 >= 0 || pointer_2 >= 0 || carry != 0) {
            int val1 = pointer_1 >= 0 ? arr1[pointer_1] : 0;
            int val2 = pointer_2 >= 0 ? arr2[pointer_2] : 0;

            int sum = val1 + val2 + carry;

            result.add(0, Math.abs(sum) % 2);

            if (sum >= 2) {
                carry = -(sum / 2);
            } else if (sum == 1) {
                carry = 0;
            } else if (sum == -1) {
                carry = 1;
            } else if (sum <= -2) {
                carry = -(Math.abs(sum) / 2);
            }

            pointer_1--;
            pointer_2--;
        }

        while (result.size() > 1 && result.get(0) == 0)
            result.remove(0);

        int[] negaBinary = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            negaBinary[i] = result.get(i);
        }

        return negaBinary;
    }
}
```