class Solution {
    public int singleNumber(int[] nums) {

        int[] bitCount = new int[32];
        for (int i = 0; i < bitCount.length; i++) {
            for (int num : nums) {
                if ((num & 1 << i) != 0)
                    bitCount[i]++;
            }
        }
        int result = 0;
        for (int i = 0; i < bitCount.length; i++)
            result += (bitCount[i] % 3) * (1 << i);

        return result;
    }
}