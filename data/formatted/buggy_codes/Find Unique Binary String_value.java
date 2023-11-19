class Solution {
    public String findDifferentBinaryString(String[] nums) {
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < nums.length; i++)
            ans.append(nums[i].charAt(i) == '0' ? '2' : '0');              // Using ternary operator
        return ans.toString();
    }
}
