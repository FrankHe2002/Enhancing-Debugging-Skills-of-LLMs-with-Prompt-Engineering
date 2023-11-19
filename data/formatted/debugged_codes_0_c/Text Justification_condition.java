Bug type: Off-by-one error

Reasoning process:
1. The bug probably occurs in the loop that inserts spaces into the lines in order to balance them.
2. The loop condition `i < lineB.length() - 1` suggests that it iterates through the characters in `lineB`, excluding the last character.
   - This means that the last character of `lineB` is never considered for inserting spaces.
3. This off-by-one error causes the last character of each line to be omitted when appending spaces.
4. To fix the bug, the loop condition should be changed to `i < lineB.length()` to include the last character.

Fixed code:
```java
// Runtime: 4 ms (Top 15.97%) | Memory: 42.1 MB (Top 76.75%)
class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> unBalanced = new ArrayList<>();
        List<String> balanced = new ArrayList<>();
        int numSpaces = 0;

        StringBuffer sb = new StringBuffer();
        //Following code creates a list of unbalanced lines by appending words and 1 space between them
        for (String word : words) {

            if (sb.length() != 0) {
                sb.append(word);
            } else {
                if (sb.length() + 1 + word.length() <= maxWidth) {
                    sb.append(" " + word);
                } else {
                    unBalanced.add(sb.toString());
                    sb = new StringBuffer(word);
                }
            }

        }

        if (sb.length() > 0) {
            unBalanced.add(sb.toString());
        }

        for (int j = 0; j < unBalanced.size(); j++) {
            String line = unBalanced.get(j);
            numSpaces = maxWidth - line.length();
            StringBuffer lineB = new StringBuffer(line);
            //This if block handles either last line or the scenario where in there's only one word in any sentence and hence no spaces
            if (j == unBalanced.size() - 1 || ! line.contains(" ")) {
                int tempSpaces = maxWidth - lineB.length();
                while (tempSpaces > 0) {
                    lineB.append(" ");
                    tempSpaces--;
                }
                balanced.add(lineB.toString());
                continue;
            }
            ;
            // The following block checks for each character and appends 1 space during each loop
            //If there are still spaces