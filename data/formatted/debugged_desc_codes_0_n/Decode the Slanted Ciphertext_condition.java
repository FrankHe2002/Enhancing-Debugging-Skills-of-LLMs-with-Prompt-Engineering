```java
class Solution {
    public String decodeCiphertext(String str, int rows) {

        //first find column size!!
        int cols = (str.length() / rows) + ((str.length() % rows) == 0 ? 0 : 1);
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < cols; i++) {

            //iterating diagonally!!
            for (int j = i; j < str.length(); j += cols)
                res.append(str.charAt(j));
        }

        //removing last spaces!!!
        int fg = 0;
        StringBuilder new_res = new StringBuilder();
        for (int i = res.length() - 1; i >= 0; i--) {

            if (fg == 0 && res.charAt(i) == ' ')
                continue;
            fg = 1;
            new_res.append(res.charAt(i));
        }
        return new_res.reverse().toString();
    }
}
```