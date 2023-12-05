```java
// Runtime: 4 ms (Top 77.47%) | Memory: 46.1 MB (Top 81.31%)
public class NestedIterator implements Iterator<Integer> {
    List<Integer> list;
    int index;

    void flatten(List<NestedInteger> nestedList, List<Integer> result) {
        for (NestedInteger nested : nestedList) {
            if (nested.isInteger())
                result.add(nested.getInteger());
            else
                flatten(nested.getList(), result);
        }
    }

    public NestedIterator(List<NestedInteger> nestedList) {
        list = new ArrayList<>();
        flatten(nestedList, list);
        index = 0;
    }

    @Override
    public Integer next() {
        return list.get(index++);
    }

    @Override
    public boolean hasNext() {
        return index < list.size();
    }
}
```