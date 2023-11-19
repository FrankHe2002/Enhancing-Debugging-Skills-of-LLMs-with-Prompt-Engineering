```java
class Solution {

    // First letter is unique after previous entries have been handled:
    static final String[] UNIQUES = new String[] {
            "zero", "wto", "geiht", "xsi", "htree",
            "seven", "rfou", "one", "vfie", "inne"
    };

    // Values corresponding to order of uniqueness checks:
    static final int[] VALS = new int[] {0, 2, 8, 6, 3, 7, 4, 1, 5, 9};

    // Maps for checking uniqueness more conveniently:
    static final Map<Integer, List<Integer>> ORDERED_FREQ_MAP;
    static final Map<Integer, Integer> ORDERED_DIGIT_MAP;

    static {
        // Initialize our ordered frequency map: 0-25 key to 0-25 values finishing the word:
        final LinkedHashMap<Integer, List<Integer>> orderedFreqMap = new LinkedHashMap<>();
        // Also initialize a digit lookup map, e.g. 'g' becomes 6 maps to 8 for ei[g]ht:
        final LinkedHashMap<Integer, Integer> orderedDigitMap = new LinkedHashMap<>();
        for (int i = 0; i < 10; ++ i) {
            final char unique = UNIQUES[i].charAt(0);
            final int ui = convert(unique);
            orderedFreqMap.put(ui, converting(UNIQUES[i].substring(1).toCharArray()));
            orderedDigitMap.put(ui, VALS[i]);
        }
        // Let's make sure we aren't tempted to modify these since they're static.
        ORDERED_FREQ_MAP = Collections.unmodifiableMap(orderedFreqMap);
        ORDERED_DIGIT_MAP = Collections.unmodifiableMap(orderedDigitMap);
    }

    public String originalDigits(String s) {
        // count frequencies of each letter in s:
        final int[] freqs = new int[26];
        for (int i = 0; i < s.length(); ++ i) {
            freqs[convert(s.charAt(i))]++;
        }
        // Create an array to store digit strings in order, e.g. '00000', '11, '2222222', etc.
        final String[] strings = new String[10];
        // Iterate through uniqueness checks in order:
        for (Map.Entry<Integer, List<Integer>> entry : ORDERED_FREQ_MAP.entrySet()) {
            final int index = entry.getKey(); // unique letter