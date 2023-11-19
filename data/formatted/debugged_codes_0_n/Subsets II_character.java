```java
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        return subset(new ArrayList<Integer>(), nums, 0);
    }

    public List<List<Integer>> subset(ArrayList<Integer> prefix, int[] nums, int start) {
        List<List<Integer>> result = new ArrayList<>();

        if (start == nums.length) {
            result.add(new ArrayList<>(prefix));
            return result;
        }

        ArrayList<Integer> withCurrent = new ArrayList<>(prefix);
        withCurrent.add(nums[start]);

        List<List<Integer>> left = subset(withCurrent, nums, start + 1);

        List<List<Integer>> right = new ArrayList<>();

        if (start > 0 && nums[start] == nums[start - 1]) {

        } else {
            right = subset(prefix, nums, start + 1);
        }

        left.addAll(right);
        return left;
    }
}
```