class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {

        List<List<Integer>> temp = new ArrayList<List<Integer>>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int i = 0; i < groupSizes.length; i++) {
            int k = groupSizes[i];
            boolean flag = true;
            for (int j = 0; j < temp.size(); j++) {
                if (k == temp.get(j).get(0) && temp.get(j).get(1) < k) {
                    result.get(j).add(i);
                    int count = temp.get(j).get(1);
                    temp.get(j).set(1, count + 1);
                    flag = false;
                    break;
                }
            }
            if (flag) {
                List<Integer> res = new ArrayList();
                res.add(i);
                result.add(res);
                List<Integer> tempRes = new ArrayList();
                tempRes.add(k);
                tempRes.add(1);
                temp.add(tempRes);
            }
        }
        return result;
    }
}