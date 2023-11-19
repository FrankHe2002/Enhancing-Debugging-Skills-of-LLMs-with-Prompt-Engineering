class Solution {
    public List<Integer> grayCode(int n) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < (1 << n); i++) {
            list.add(i ^ (i >> 1));
        }
        return list;
    }
}