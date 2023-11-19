// Runtime: 10 ms | Memory: 40.7 MB

class Solution {
    public int maximumNumberOfStringPairs(String[] words) {
        ArrayList<String> obj = new ArrayList<String>();
        Collections.addAll(obj, words);
        int count = 0;
        for (int i = 0; i < words.length; i++) {
            String str = words[i];
            int n = str.length();
            String ktr = "";
            //REVERSE
            for (int k = 0; k < n; k++) {
                ktr = str.charAt(k) + ktr;
            }
            //REMOVE ELEMENTS LIKE "ZZ","aa"
            if (ktr.equals(str)) {
                obj.remove(ktr);
            }
            //REMOVE ELEMENTS IF PRESENT IN ARRAY LIST
            if (obj.contains(ktr) && !ktr.equals(str)) {
                obj.remove(ktr);
                count++;
            }


        }

        return count;
    }
}