```java
// Runtime: 2 ms (Top 61.15%) | Memory: 41.9 MB (Top 65.96%)
class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0"))
            return "0";
        int[] arr = new int[num1.length() + num2.length()];

        int index = 0;
        for (int i = num1.length() - 1; i >= 0; i--) {
            int carry = 0;
            int column = 0;
            for (int j = num2.length() - 1; j >= 0; j--) {
                int a = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int temp = (arr[index + column] + carry + a);
                arr[index + column] = temp % 10;
                carry = temp / 10;
                column++;
            }
            while (carry != 0) {
                int temp = (arr[index + column] + carry);
                arr[index + column] = temp % 10;
                carry = temp / 10;
                column++;
            }
            index++;
        }
        StringBuilder sb = new StringBuilder();
        int i = arr.length - 1;
        while (i >= 0 && arr[i] == 0) {
            i--;
        }
        while (i >= 0) {
            sb.append(arr[i]);
            i--;
        }
        return sb.toString();
    }
}
```