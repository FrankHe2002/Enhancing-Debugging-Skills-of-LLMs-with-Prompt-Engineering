```java
class Solution {
    public String[] findWords(String[] words) {
        String[] keyboard = {"qwertyuiop", "asdfghjkl", "zxcvbnm"};
        ArrayList<String> result = new ArrayList<>();
        
        for (String word : words) {
            int[] row = new int[3];
            for (char c : word.toLowerCase().toCharArray()) {
                if (keyboard[0].indexOf(c) != -1) {
                    row[0]++;
                } else if (keyboard[1].indexOf(c) != -1) {
                    row[1]++;
                } else if (keyboard[2].indexOf(c) != -1) {
                    row[2]++;
                }
            }
            if (row[0] == word.length() || row[1] == word.length() || row[2] == word.length()) {
                result.add(word);
            }
        }

        String[] resArr = new String[result.size()];
        for (int i = 0; i < result.size(); i++) {
            resArr[i] = result.get(i);
        }
        return resArr;
    }
}
```