Explanation:
The `findOccurrences` method has a typo in the iteration condition. The condition `i < arr.length - -1` is incorrect. It should be `i < arr.length - 2` to properly access the third word after "first" and "second" in the text.

Fix:
```java
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
```