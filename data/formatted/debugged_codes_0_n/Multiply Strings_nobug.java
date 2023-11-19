```java
// Runtime: 6 ms (Top 37.38%) | Memory: 39.1 MB (Top 49.88%)
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
            arr[index + column] = carry;
            index++;
        }
        StringBuilder ans = new StringBuilder();
        index = arr.length - 1;
        while (index >= 0 && arr[index] == 0) {
            index--;
        }
        while (index >= 0) {
            ans.append(arr[index]);
            index--;
        }
        return ans.toString();
    }
}
```