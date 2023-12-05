```java
class RandomizedCollection {
    List<Integer> multiSet;
    HashMap<Integer, List<Integer>> map;
    Random random;

    public RandomizedCollection() {
        map = new HashMap<>();
        multiSet = new ArrayList<>();
        random = new Random();
    }

    public boolean insert(int val) {
        boolean contains = map.containsKey(val);
        multiSet.add(val);
        List<Integer> list;
        if (!contains) {
            list = new ArrayList<>();
            map.put(val, list);
        } else
            list = map.get(val);

        list.add(multiSet.size() - 1);
        return !contains;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val))
            return false;

        List<Integer> list = map.get(val);
        int indexToRemove = list.get(list.size() - 1);
        list.remove(list.size() - 1);
        if (list.isEmpty()) map.remove(val);
        
        int lastIndex = multiSet.size() - 1;
        if (indexToRemove != lastIndex) {
            int valLast = multiSet.get(lastIndex);
            List<Integer> temp = map.get(valLast);
            temp.replaceAll(e -> e == lastIndex ? indexToRemove : e);
            multiSet.set(indexToRemove, valLast);
        }
        multiSet.remove(lastIndex);
        return true;
    }

    public int getRandom() {
        int index = random.nextInt(multiSet.size());
        return multiSet.get(index);
    }
}
```