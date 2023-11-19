class Solution {
    public String toGoatLatin(String sentence) {
        StringBuffer sb = new StringBuffer();
        StringBuffer temp = new StringBuffer("a");

        for (String str : sentence.split(" ")) {
            if (beginsWithConsonant(str)) {
                sb.append(str.substring(1));
                sb.append(str.charAt(0));
            } else {
                sb.append(str);
            }

            sb.append("ma");
            sb.append(temp);
            temp.append("a");
            sb.append(" ");
        }

        return sb.toString().trim();
    }

    public boolean beginsWithConsonant(String str) {
        return "aeiou".indexOf(str.toLowerCase().charAt(0)) == - 1;
    }
}