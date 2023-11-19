Bug Type: Syntax Error

Reasoning: The code is missing a semicolon at the end of the line `sb.append(word)` inside the loop.

Fix: Add a semicolon at the end of the line `sb.append(word)`.

Fixed Code:
```java
// Runtime: 4 ms (Top 15.97%) | Memory: 42.1 MB (Top 76.75%)
class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> unBalanced = new ArrayList<>();
        List<String> balanced = new ArrayList<>();
        int numSpaces = 0;

        StringBuffer sb = new StringBuffer();
        // Following code creates a list of unbalanced lines by appending words and 1 space between them
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
            // This if block handles either last line or the scenario where in there's only one word in any sentence and hence no spaces
            if (j == unBalanced.size() - 1 || ! line.contains(" ")) {
                int tempSpaces = maxWidth - lineB.length();
                while (tempSpaces > 0) {
                    lineB.append(" ");
                    tempSpaces--;
                }
                balanced.add(lineB.toString());
                continue;
            }
            // The following block checks for each character and appends 1 space during each loop
            // If there are still spaces left at the end of the String, again start from beginning and append spaces after each word
            while (numSpaces > 0) {
                int i = 0;
                while (i < lineB.length() - 1) {
                    if (lineB.charAt(i) == ' ' && lineB.charAt(i + 1) != ' ') {
                        lineB.insert(i + 1, ' ');
                        i++;
