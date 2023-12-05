```java
class Solution {
    public int[] addNegabinary(int[] arr1, int[] arr2) {
        List<Integer> result = new ArrayList();
        int pointer_1 = arr1.length - 1;
        int pointer_2 = arr2.length - 1;
        int carry = 0;
        int current = 0;
        int sum = 0;

        while (pointer_1 >= 0 || pointer_2 >= 0 || carry != 0) {
            int a = (pointer_1 >= 0) ? arr1[pointer_1] : 0;
            int b = (pointer_2 >= 0) ? arr2[pointer_2] : 0;

            sum = a + b + carry;
            if (sum >= 2) {
                if (sum == 3) {
                    current = 1;
                } else {
                    current = 0;
                }
                carry = -1;
            } else {
                current = sum;
                carry = 0;
            }

            result.add(current);
            pointer_1--;
            pointer_2--;
        }

        while (result.size() > 1 && result.get(result.size() - 1) == 0) {
            result.remove(result.size() - 1);
        }

        int[] negaBinary = new int[result.size()];
        for (int i = result.size() - 1; i >= 0; i--) {
            negaBinary[result.size() - 1 - i] = result.get(i);
        }

        return negaBinary;
    }
}
```