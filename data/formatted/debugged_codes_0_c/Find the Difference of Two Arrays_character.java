There is a missing closing brace for one of the for loops in the provided Java code, which is causing a compilation error. 

To fix this bug, we need to add a closing brace for the second for loop. 

Here is the corrected code:

```java
class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int num : nums1) {
            set1.add(num);
        }
        for (int num : nums2) {
            set2.add(num);
        }
        
        List<List<Integer>> resultList = new ArrayList<>(); // Initialize result list with 2 empty sublists that we will return
        resultList.add(new ArrayList<>());
        resultList.add(new ArrayList<>());

        for (int num : set1) {
            if (! set2.contains(num)) {
                resultList.get(0).add(num);
            }
        }
        for (int num : set2) {
            if (! set1.contains(num)) {
                resultList.get(1).add(num);
            }
        }
        return resultList;
    }
}
```