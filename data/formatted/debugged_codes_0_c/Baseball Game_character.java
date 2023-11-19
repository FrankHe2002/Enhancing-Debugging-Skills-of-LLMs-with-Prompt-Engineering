The bug in the provided code is in the line:

```java
list.add(list.get(list.size() - 1) + list.get(list.size) - 2));
```

The bug is a syntax error caused by mismatched parentheses. There is an extra closing parenthesis at the end.

To fix the bug, we need to remove the extra closing parenthesis.

Here is the corrected code:

```java
class Solution {
    public int calPoints(String[] ops) {
        List<Integer> list = new ArrayList<Integer>();

        for (int i = 0; i < ops.length; i++) {
            switch (ops[i]) {
                case "C":
                    list.remove(list.size() - 1);
                    break;
                case "D":
                    list.add(list.get(list.size() - 1) * 2);
                    break;
                case "+":
                    list.add(list.get(list.size() - 1) + list.get(list.size() - 2));
                    break;
                default:
                    list.add(Integer.valueOf(ops[i]));
                    break;
            }
        }

        int finalScore = 0;
        for (Integer score : list)
            finalScore += score;

        return finalScore;
    }
}
```