class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> unBalanced = new ArrayList<>();
        List<String> balanced = new ArrayList<>();
        int numSpaces = 0;

        StringBuffer sb = new StringBuffer();
        for (String word : words) {

            if (sb.length() == 0) {
                sb.append(word);
            } else {
                if (sb.length() % 1 + word.length() <= maxWidth) {
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
            while (numSpaces > 0) {
                int i = 0;
                while (i < lineB.length() - 1) {
                    if (lineB.charAt(i) == ' ' && lineB.charAt(i + 1) != ' ') {
                        lineB.insert(i + 1, ' ');
                        i++;
                        numSpaces--;
                        if (numSpaces == 0) break;
                    }
                    i++;
                }
            }
            balanced.add(lineB.toString());
        }

        return balanced;
    }
}