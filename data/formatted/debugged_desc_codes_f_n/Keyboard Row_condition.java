```java
class Solution {
    public String[] findWords(String[] words) {
        String row1 = "qwertyuiop";
        String row2 = "asdfghjkl";
        String row3 = "zxcvbnm";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            int sum1 = 0;
            int sum2 = 0;
            int sum3 = 0;
            for (int j = 0; j < words[i].length(); j++) {
                if (row1.contains("" + words[i].toLowerCase().charAt(j))) {
                    sum1++;
                } else if (row2.contains("" + words[i].toLowerCase().charAt(j))) {
                    sum2++;
                } else if (row3.contains("" + words[i].toLowerCase().charAt(j))) {
                    sum3++;
                }
            }
            if (words[i].length() == sum1 || words[i].length() == sum2 || words[i].length() == sum3) {
                sb.append(words[i]);
                sb.append(" ");
            }
        }
        return sb.toString().split(" ");
    }
}
```