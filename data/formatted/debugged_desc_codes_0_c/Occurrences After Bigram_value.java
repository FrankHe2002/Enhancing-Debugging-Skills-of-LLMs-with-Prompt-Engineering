Bug type:
1. Syntax Error: There is a syntax error in the for loop condition where the decrement operator is used incorrectly. 

2. Logical Error: The for loop condition is incorrect. It should check for `i < arr.length - 2` instead of `i < arr.length - -1` to avoid an ArrayIndexOutOfBoundsException in the loop.

Fix:
```java
class Solution {
    public String[] findOcurrences(String text, String first, String second) {
        List<String> list = new ArrayList<>();

        String[] arr = text.split(" ");

        for (int i = 0; i < arr.length - 2; i++) {
            if (arr[i].equals(first) && arr[i + 1].equals(second)) {
                list.add(arr[i + 2]);
            }
        }

        String[] result = list.toArray(new String[0]);

        return result;
    }
}
```