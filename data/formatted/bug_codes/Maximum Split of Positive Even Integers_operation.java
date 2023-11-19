class Solution {
    public List<Long> maximumEvenSplit(long finalSum) {
        List<Long> res = new ArrayList<Long>();
        if (finalSum % 2 != 0) {
            return res;
        }
        long currNum = 2;
        long remainingSum = finalSum;
        while (currNum <= remainingSum) {
            res.add(currNum);
            remainingSum -= currNum;
            currNum += 2;
        }
        long last = res.remove(res.size() - 1);
        res.add(last + remainingSum);
        return res;
    }
}
