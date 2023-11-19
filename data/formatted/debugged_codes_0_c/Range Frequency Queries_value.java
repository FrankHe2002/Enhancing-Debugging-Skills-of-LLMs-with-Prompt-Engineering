The bug in the provided code is in the constructor method, where the cummulative count of the values in the TreeMap is not being calculated correctly.

To fix this bug, we will need to modify the code inside the for loop in the constructor. Specifically, we need to change the line `tree.put(i, tree.size());` to `tree.put(i, tree.size() + 1);`. This change will ensure that the cummulative count is being calculated correctly.

Here is the fixed code:

```java
class RangeFreqQuery {
    //Use map's key to store arr's value, map's value to keep <value's location, cummulative arr's value count>
    HashMap<Integer, TreeMap<Integer, Integer>> map;

    public RangeFreqQuery(int[] arr) {
        //O(nlog(n))
        map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.putIfAbsent(arr[i], new TreeMap<>());
            TreeMap<Integer, Integer> tree = map.get(arr[i]);
            //i = value's location
            //tree.size() = cummulative arr's value count - 1
            tree.put(i, tree.size() + 1);
        }
    }

    public int query(int left, int right, int value) {
        //O(log(n))

        //check if value exist in map
        if (! map.containsKey(value)) {
            return 0;
        }
        TreeMap<Integer, Integer> tree = map.get(value);

        //check if there exist position >= left and position <= right
        //if not, return 0
        if (tree.ceilingKey(left) == null || tree.floorKey(right) == null) {
            return 0;
        }
        //get leftMost position's cummulative count
        int leftMost = tree.get(tree.ceilingKey(left));
        //get rightMost position's cummulative count
        int rightMost = tree.get(tree.floorKey(right));

        return rightMost - leftMost + 1;
    }
}

/**
 * Your RangeFreqQuery object will be instantiated and called as such:
 * RangeFreqQuery obj = new RangeFreqQuery(arr);
 * int param_0 = obj.query(left,right,value);
 */
```

This fix should properly calculate the cummulative count of the values in the TreeMap and resolve the bug in the code.