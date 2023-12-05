```java
class RandomizedCollection {
    List<Integer> multiSet;
    HashMap<Integer, ArrayList<Integer>> map;
    Random random;

    public RandomizedCollection() {
        map = new HashMap<>();
        multiSet = new ArrayList<>();
        random = new Random();
    }

    public boolean insert(int val) {
        multiSet.add(val);
        ArrayList<Integer> indexes = map.getOrDefault(val, new ArrayList<>());
        indexes.add(multiSet.size() - 1);
        map.put(val, indexes);
        return indexes.size() == 1;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        ArrayList<Integer> indexes = map.get(val);
        int indexToRemove = indexes.remove(indexes.size() - 1);
        int lastIndex = multiSet.size() - 1;
        if (indexToRemove != lastIndex) {
            int lastVal = multiSet.get(lastIndex);
            ArrayList<Integer> lastValIndexes = map.get(lastVal);
            lastValIndexes.remove(Integer.valueOf(lastIndex));
            lastValIndexes.add(indexToRemove);
            multiSet.set(indexToRemove, lastVal);
        }
        multiSet.remove(lastIndex);

        if (indexes.isEmpty()) {
            map.remove(val);
        }
        return true;
    }

    public int getRandom() {
        return multiSet.get(random.nextInt(multiSet.size()));
    }
}
```