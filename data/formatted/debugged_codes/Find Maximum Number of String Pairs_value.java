import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public int maximumNumberOfStringPairs(String[] words) {
        ArrayList<String> obj = new ArrayList<String>();
        Collections.addAll(obj, words);
        int count = 0;
        for (int i = 0; i < words.length; i++) {
            String str = words[i];
            int n = str.length();
            String ktr = "";
            for (int k = 0; k < n; k++) {
                ktr = str.charAt(k) + ktr;
            }
            if (ktr.equals(str)) {
                obj.remove(ktr);
                continue;
            }
            if (obj.contains(ktr)) {
                obj.remove(str);
                count++;
            }
        }
        return count;
    }
} 