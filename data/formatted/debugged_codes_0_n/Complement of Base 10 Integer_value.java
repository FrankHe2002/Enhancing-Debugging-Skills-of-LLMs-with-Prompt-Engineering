```java
class Solution {
    public int bitwiseComplement(int n) {
        String bin = Integer.toBinaryString(n);
        StringBuilder res = new StringBuilder();
        for (char c : bin.toCharArray()) {
            if (c == '1')
                res.append("0");
            else
                res.append("1");
        }
        return Integer.parseInt(res.toString(), 2);
    }
}
```