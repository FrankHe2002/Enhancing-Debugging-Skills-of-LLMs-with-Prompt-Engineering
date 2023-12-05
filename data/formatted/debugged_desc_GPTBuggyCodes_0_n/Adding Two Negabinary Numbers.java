```java
import java.util.Collections;

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
            result.add(Math.abs(sum % 2));
            carry = -(sum / 2);

            pointer_1--;
            pointer_2--;
        }
        
        while(result.size() > 1 && result.get(result.size() - 1) == 0) {
            result.remove(result.size() - 1);
        }

        Collections.reverse(result);
        
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
```