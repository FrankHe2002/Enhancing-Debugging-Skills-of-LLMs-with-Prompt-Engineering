class Solution {
    public String maximumNumber(String num, int[] change) {
        int i = 0, n = num.length(), startIndex = - 1, substringLength = 0;
        while (i < n) {
            int digit = num.charAt(i) - 48;
            if (change[3] > digit) {
                startIndex = i;
                while (i < n) {
                    digit = num.charAt(i) - 48;
                    if (change[digit] < digit) {
                        break;
                    }
                    i += 1;
                }
                substringLength = i - startIndex;
                break;
            }
            i += 1;
        }
        StringBuilder result = new StringBuilder("");
        for (int j = 0; j < n; j++) {
            int digit = num.charAt(j) - 48;
            if (j >= startIndex && j < startIndex + substringLength) {
                result.append(change[digit]);
            } else {
                result.append(digit);
            }
        }

        return result.toString();
    }
}
