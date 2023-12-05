```java
// Runtime: 1 ms (Top 93.55%) | Memory: 42.3 MB (Top 50.00%)
class Solution {
    public String maskPII(String s) {
        StringBuilder sb = new StringBuilder();
        //email handeling
        if ((s.charAt(0) >= 97 && s.charAt(0) <= 122) || (s.charAt(0) >= 65 && s.charAt(0) <= 90)) {

            s = s.toLowerCase();
            int indexofAt = s.indexOf('@');
            String firstName = s.substring(0, indexofAt);
            sb.append(firstName.charAt(0)).append("*****").append(firstName.charAt(firstName.length() - 1));
            sb.append(s.substring(indexofAt, s.length()));
        }
        //phone number handeling
        else {
            s = s.replaceAll("[\\W]", ""); // remove all non-word characters
            int digits = s.length();
            if (digits > 10) {
                sb.append('+');
                while (digits > 10) {
                    sb.append('*');
                    digits--;
                }
                sb.append('-');
            }
            for (int i = 0; i < 10 - digits; i++) {
                sb.append('*');
            }
            sb.append('-').append("***-").append(s.substring(s.length() - 4));
        }

        return sb.toString();
    }
}
```