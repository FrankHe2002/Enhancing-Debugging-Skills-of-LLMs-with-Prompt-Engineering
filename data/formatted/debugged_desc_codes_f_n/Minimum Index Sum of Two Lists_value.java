```java
class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        List<String> l2 = Arrays.asList(list2);
        int least = Integer.MAX_VALUE;
        List<String> returnArray = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < list1.length; i++) {
            if (l2.contains(list1[i])) {
                map.put(list1[i], i + l2.indexOf(list1[i]));
            }
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() <= least) least = entry.getValue();
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == least) returnArray.add(entry.getKey());
        }

        if (returnArray.size() > 1) return returnArray.toArray(new String[returnArray.size()]);
        return new String[] {returnArray.get(0)};
    }
}
```