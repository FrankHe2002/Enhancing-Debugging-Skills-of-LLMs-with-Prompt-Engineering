class Solution {
  public boolean isPossible(int[] nums) {
    int[] freq = new int[2002], subEnd = new int[2002];
    for (int i : nums) {
      int num = i + 1001;
      freq[num]++;
    }
    for (int i : nums) {
      int num = i + 1001;
      if (freq[num] == 0) continue;
        freq[num]--;
        if (subEnd[num - 1] > 0) {
            subEnd[num - 1]--;
            subEnd[num]++;
        } else if (freq[num + 1] > 0 && freq[num + 2] > 0) {
            freq[num + 1]--;
            freq[num + 2]--;
            subEnd[num + 2]++;
        } else return false;
    }
    return true
  }
}
