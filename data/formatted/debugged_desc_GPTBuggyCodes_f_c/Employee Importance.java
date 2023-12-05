The bug in the provided Java code is a logic error as well as an `IndexOutOfBoundsException` in the `populateIdToIndexMap()` method. 

In the `populateIdToIndexMap()` method, the loop condition `idx <= employees.size()` is causing `IndexOutOfBoundsException` because the array index is accessed up to `size-1`. The condition should be `idx < employees.size()` instead.

Another logical error is present in the recursion method `dfsGetImportance()`. The for loop references `currEmpIdx` and `idToIndex` should be corrected to use the index `i` instead of `<=` in the for loop. 

The fix will involve replacing the `<=` condition with `<` in the `populateIdToIndexMap()` method and changing the for loop to iterate using index `i` instead of `currEmpIdx` in the recursive method `dfsGetImportance()`.

Here's the fixed code:

```java
class Solution {

    private Map<Integer, Integer> idToIndex;

    private void populateIdToIndexMap(List<Employee> employees) {
        idToIndex = new HashMap<>();
        for (int idx = 0; idx < employees.size(); idx++) {
            idToIndex.put(employees.get(idx).id, idx);
        }
    }

    private int dfsGetImportance(List<Employee> employees, int id) {
        int currEmpIdx = idToIndex.get(id);
        Employee currEmp = employees.get(currEmpIdx);
        int totalImportance = currEmp.importance;
        for (int i = 0; i < currEmp.subordinates.size(); i++) {
            int child = currEmp.subordinates.get(i);
            totalImportance += dfsGetImportance(employees, child);
        }

        return totalImportance;
    }

    public int getImportance(List<Employee> employees, int id) {
        if (employees == null || employees.size() < 1) {
            return 0;
        }

        populateIdToIndexMap(employees);
        return dfsGetImportance(employees, id);
    }
}
```