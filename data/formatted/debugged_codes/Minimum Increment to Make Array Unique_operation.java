class Solution {
    public int minIncrementForUnique(int[] nums) {

        int max = 0;
        for (int i : nums)
            max = Math.max(max, i);

        int count[] = new int[max + nums.length];

        for (int c : nums)
            count[c]++;

        int answer = 0, choosen = 0;
        int len = count.length;

        for (int i = 0; i < len; i++) {
            if (count[i] >= 2) {
                choosen += count[i] - 1;
                answer -= i * (count[i] - 1);
            } else if (choosen > 0 && count[i] == 0) {
                answer -= i;
                choosen--;
            }
        }

        return answer;

    }
}