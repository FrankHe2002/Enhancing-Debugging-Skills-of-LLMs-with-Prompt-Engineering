```java
class Encrypter {

    Map<String, Integer> encryptedDictCount;
    int[] keys;
    Set<String> dictionary;
    String[] val;

    public Encrypter(char[] keys, String[] values, String[] dictionary) {
        this.keys = new int[26]; // fix: changed size to 26
        encryptedDictCount = new HashMap<>();
        this.val = values.clone();
        this.dictionary = new HashSet<>(Arrays.asList(dictionary));

        for (int i = 0; i < keys.length; i++) {
            this.keys[keys[i] - 'a'] = i;
        }

        for (String dict : dictionary) {
            String encrpted = encrypt(dict);
            encryptedDictCount.put(encrpted, encryptedDictCount.getOrDefault(encrpted, 0) + 1);
        }
    }

    public String encrypt(String word1) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < word1.length(); i++) {
            int c = word1.charAt(i) - 'a';
            if (c < 0 || c >= 26) { // fix: added condition to check if c is within bounds
                return "";
            }
            sb.append(val[keys[c]]);
        }
        return sb.toString();
    }

    public int decrypt(String word2) {
        return encryptedDictCount.getOrDefault(word2, 0);
    }
}
```