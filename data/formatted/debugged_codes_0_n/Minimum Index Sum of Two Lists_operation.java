```java
class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        List<String> l1 = Arrays.asList(list1);
        int least = Integer.MAX_VALUE;
        List<String> returnArray = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < list2.length; i++) {
            if (l1.contains(list2[i])) {
                int sum = l1.indexOf(list2[i]) + i;
                map.put(list2[i], sum);
                least = Math.min(least, sum);
            }
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == least) returnArray.add(entry.getKey());
        }

        if (returnArray.size() > 1) return returnArray.toArray(new String[0]);
        return new String[] {returnArray.get(0)};
    }
}
```