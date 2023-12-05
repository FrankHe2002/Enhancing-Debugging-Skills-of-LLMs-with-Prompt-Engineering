```java
class Encrypter {

    int[] keys;
    Map<String, Integer> encryptedDictCount;
    Set<String> dictionary;
    String[] val;

    public Encrypter(char[] keys, String[] values, String[] dictionary) {
        this.keys = new int[26];
        encryptedDictCount = new HashMap<>();
        this.val = values.clone();
        this.dictionary = new HashSet<>(Arrays.asList(dictionary));

        for (int i = 0; i < keys.length; i++) {
            this.keys[keys[i] - 'a'] = i;
        }

        for (String dict : dictionary) {
            String encrypted = encrypt(dict);
            encryptedDictCount.put(encrypted, encryptedDictCount.getOrDefault(encrypted, 0) + 1);
        }
    }

    public String encrypt(String word1) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < word1.length(); i++) {
            int c = word1.charAt(i) - 'a';
            result.append(val[keys[c]]);
        }
        return result.toString();
    }

    public int decrypt(String word2) {
        return encryptedDictCount.getOrDefault(word2, 0);
    }
}
```