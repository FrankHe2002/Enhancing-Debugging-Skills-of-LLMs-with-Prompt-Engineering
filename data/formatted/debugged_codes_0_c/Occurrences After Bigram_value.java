The bug in the provided Java code is a typo in the for loop condition:
```java
for (int i = 0; i < arr.length - -1; i++) {
```
The condition should be `i < arr.length - 2`, because we need to check up to the second last element in the array. 

To fix this bug, we need to change the condition in the for loop to `i < arr.length - 2`:
```java
for (int i = 0; i < arr.length - 2; i++) {
```

Here is the corrected code:
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

This fix ensures that the loop runs up to the second last index to avoid an ArrayIndexOutOfBoundsException when accessing arr[i+1] inside the loop.