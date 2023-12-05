Fix:
```java
class Solution {
    public boolean validUtf8(int[] data) {
        for (int i = 0; i < data.length; i++) {
            int number = data[i];
            if ((number & 128) == 0) {
                continue; // 1 byte
            } else if ((number & 224) == 192) {
                if (i + 1 >= data.length) {
                    return false;
                }
                number = data[++i];
                if ((number & 192) != 128) {
                    return false;
                }
            } else if ((number & 240) == 224) {
                if (i + 2 >= data.length) {
                    return false;
                }
                number = data[++i];
                if ((number & 192) != 128) {
                    return false;
                }
                number = data[++i];
                if ((number & 192) != 128) {
                    return false;
                }
            } else if ((number & 248) == 240) {
                if (i + 3 >= data.length) {
                    return false;
                }
                number = data[++i];
                if ((number & 192) != 128) {
                    return false;
                }
                number = data[++i];
                if ((number & 192) != 128) {
                    return false;
                }
                number = data[++i];
                if ((number & 192) != 128) {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }
}
```