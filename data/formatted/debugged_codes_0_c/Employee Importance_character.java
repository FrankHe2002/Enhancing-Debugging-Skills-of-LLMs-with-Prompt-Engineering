The bug in the given code is a syntax error in the line:

```java
int currEmpIdx = idToIndex.getid);
```

The closing parenthesis is missing after `id` in the `get()` method call.

To fix this bug, we should add the missing closing parenthesis.

```java
int currEmpIdx = idToIndex.get(id);
```

Here's the corrected code:

```java
import java.util.*;

class Solution {

    private Map<Integer, Integer> idToIndex;

    private void populateIdToIndexMap(List<Employee> employees) {
        for (int idx = 0; idx < employees.size(); idx++) {
            idToIndex.put(employees.get(idx).id, idx);
        }
    }

    private int dfsGetImportance(List<Employee> employees, int id) {
        int currEmpIdx = idToIndex.get(id);
        Employee currEmp = employees.get(currEmpIdx);
        int totalImportance = currEmp.importance;
        for (int child : currEmp.subordinates) {
            totalImportance += dfsGetImportance(employees, child);
        }

        return totalImportance;
    }

    public int getImportance(List<Employee> employees, int id) {
        if (employees == null || employees.size() < 1) {
            return 0;
        }

        idToIndex = new HashMap<>();
        populateIdToIndexMap(employees);
        return dfsGetImportance(employees, id);
    }
}
```