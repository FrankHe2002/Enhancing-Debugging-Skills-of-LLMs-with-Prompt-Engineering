```java
class Solution {
    public String countAndSay(int n) {
        if (n == 1) return "1";
        else {
            String say = "";
            say += countAndSay(n - 1);
            String count = "";
            int cache = Integer.parseInt(say.substring(0, 1));
            int cntr = 1;
            if (say.length() < 2) {
                count += "1" + Integer.toString(cache);
            } else {
                for (int i = 1; i < say.length(); i++) {
                    if (cache == Integer.parseInt(say.substring(i, i + 1))) {
                        cntr++;
                        if (i == say.length() - 1) {
                            count += Integer.toString(cntr) + Integer.toString(cache);
                            cntr = 1;
                        }
                    } else {
                        count += Integer.toString(cntr) + Integer.toString(cache);
                        if (i < say.length() - 1) {
                            cache = Integer.parseInt(say.substring(i, i + 1));
                            cntr = 1;
                        } else if (i == say.length() - 1) {
                            count += "1" + say.substring(i, i + 1);
                        }
                    }
                    if (i == say.length() - 1) {
                        count += "1" + say.substring(i, i + 1);
                    }
                }
            }
            return count;
        }
    }
}
```