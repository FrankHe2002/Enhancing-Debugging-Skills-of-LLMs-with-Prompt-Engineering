The bug in the given Java code is in the `beginsWithConsonant` method. The method is designed to return true if a word begins with a consonant (i.e., not a vowel). However, the logic is reversed; it incorrectly returns true if a word begins with a vowel and false if it begins with a consonant. 

To fix this bug, the logic in the `beginsWithConsonant` method needs to be reversed so that it returns true if a word begins with a consonant.

Here is the fixed code:
```java
class Solution {
    public String toGoatLatin(String sentence) {
        StringBuffer sb = new StringBuffer();
        StringBuffer temp = new StringBuffer("a"); // temporary stringbuffer

        for (String str : sentence.split(" ")) {
            if (!beginsWithConsonant(str)) {
                sb.append(str); // append the word as it is
            } else {
                sb.append(str.substring(1)); // removing the first letter
                sb.append(str.charAt(0)); // appending it to the end
            }

            sb.append("ma"); // appending "ma" to the end of the word (common operation)
            sb.append(temp); // adding one letter 'a' to the end of each word

            // the first word gets "a" added to the end,
            // the second word gets "aa" added to the end,
            // and so on.
            temp.append("a"); // increasing the a's for every word
            sb.append(" "); // to put space between words
        }

        return sb.toString().trim(); // using trim() to remove the one extra space from the end of string.
    }

    public boolean beginsWithConsonant(String str) {
        return "aeiou".indexOf(str.toLowerCase().charAt(0)) == -1;
    }
}
```