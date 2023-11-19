// Runtime: 11 ms (Top 9.88%) | Memory: 39.3 MB (Top 35.94%)
class Solution {
    String modifiedNumber = "";
    public String reformatNumber(String number) {
        modifiedNumber = number.replace(" ", "").replace("-", "");
        int l = modifiedNumber.length();
        if (l <= 3) {
            return modifiedNumber;
        } else if (l == 4) {
            return modifiedNumber.substring(0, 2) + "-" + modifiedNumber.substring(2, 4);
        } else {
            modifiedNumber = modifiedNumber.substring(0, 3) + "-" + reformatNumber(modifiedNumber.substring(3));
        }
        return modifiedNumber;
    }
}