The bug in the provided code is a typo in the loop condition: `i < arr.length - -1`. The double minus sign (`- -`) is incorrect syntax and results in a compilation error.

To fix the bug, we need to change the loop condition to `i < arr.length - 1`, which correctly iterates through the array indices.

Fixed Code:
```java
class Solution {
    public String[] findOcurrences(String text, String first, String second) {
        List<String> list = new ArrayList<>();
        String[] arr = text.split(" ");
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i].equals(first) && arr[i + 1].equals(second)) {
                list.add(arr[i + 2]);
            }
        }
        String[] result = list.toArray(new String[0]);
        return result;
    }
}
```