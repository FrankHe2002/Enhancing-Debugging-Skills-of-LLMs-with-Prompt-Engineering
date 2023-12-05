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
            current = sum & 1;
            carry = -(sum >> 1);

            result.add(current);
            pointer_1--;
            pointer_2--;
        }

        // Removing leading zeros
        while (result.size() > 1 && result.get(result.size() - 1) == 0)
            result.remove(result.size() - 1);
        
        Collections.reverse(result);
        
        // converting the list and adding the result to an array
        int[] negaBinary = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            negaBinary[i] = result.get(i);
        }

        return negaBinary;
    }
}
```