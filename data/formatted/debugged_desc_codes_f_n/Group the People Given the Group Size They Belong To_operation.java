```java
// Runtime: 54 ms (Top 5.31-) | Memory: 53.9 MB (Top 61.36%)
class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {

        List<List<Integer>> temp = new ArrayList<List<Integer>>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int i = 0; i < groupSizes.length; i++) {
            int k = groupSizes[i];
            boolean flag = true;
            for (int j = 0; j < temp.size(); j++) {
                // If there is a list of required group size and it is filled lesser than we can put element in that one
                if (k == temp.get(j).get(0) && temp.get(j).size() < k) {
                    result.get(j).add(i);
                    temp.get(j).add(temp.get(j).size());
                    flag = false;
                    break;
                }
            }
            if (flag) {
                // We create a list with index and put it to result
                List<Integer> res = new ArrayList();
                res.add(i);
                result.add(res);
                // we create a new list recording max value can be stored and currently filled
                List<Integer> tempRes = new ArrayList();
                tempRes.add(k);
                tempRes.add(1);
                temp.add(tempRes);
            } 
        }
        return result;
    }
}
```