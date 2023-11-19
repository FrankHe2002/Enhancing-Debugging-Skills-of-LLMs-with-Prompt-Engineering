Before identifying the bug, let's format the code properly:

```java
import java.util.ArrayList;

class Solution {
    public boolean isIsomorphic(String s, String t) {

        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            list1.add(s.lastIndexOf(s.charAt(i)));
            list2.add(t.lastIndexOf(t.charAt(i)));
        }

        if (list1.equals(list2)) {
            return true;
        } else {
            return false;
        }
    }
}
```

After formatting, we can see that there are two lines declaring `ArrayList<Integer>` with the variable name `list2`. This is a compilation error and the bug type in this code is a syntax error.

To fix the bug, we need to rename one of the `ArrayList` variables. We can choose to rename `list2` to `list1` since it is not being used after the loop.

Here is the fixed code:

```java
import java.util.ArrayList;

class Solution {
    public boolean isIsomorphic(String s, String t) {

        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            list1.add(s.lastIndexOf(s.charAt(i)));
            list2.add(t.lastIndexOf(t.charAt(i)));
        }

        if (list1.equals(list2)) {
            return true;
        } else {
            return false;
        }
    }
}
```