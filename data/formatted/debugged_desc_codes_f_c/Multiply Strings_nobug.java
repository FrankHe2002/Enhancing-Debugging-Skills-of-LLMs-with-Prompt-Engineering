```java
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
                arr[index + column] += carry;
                carry = arr[index + column] / 10;
                arr[index + column] %= 10;
                column++;
            }
            index++;
        }
        StringBuilder ans = new StringBuilder();
        for (int i = arr.length - 1; i >= 0; i--) {
            if (ans.length() > 0 || arr[i] != 0) {
                ans.append(arr[i]);
            }
        }
        return ans.length() == 0 ? "0" : ans.toString();
    }
}
```