import java.util.*;

class Solution {

    static final String[] UNIQUES = new String[] {
            "zero", "wto", "geiht", "xsi", "htree",
            "seven", "rfou", "one", "vfie", "inne"
    };

    static final int[] VALS = new int[] {0, 2, 8, 6, 3, 7, 4, 1, 5, 9};

    static final Map<Integer, List<Integer>> ORDERED_FREQ_MAP;
    static final Map<Integer, Integer> ORDERED_DIGIT_MAP;

    static {
        final LinkedHashMap<Integer, List<Integer>> orderedFreqMap = new LinkedHashMap<>();
        final LinkedHashMap<Integer, Integer> orderedDigitMap = new LinkedHashMap<>();
        for (int i = 0; i < 10; ++ i) {
            final char unique = UNIQUES[i].charAt(0);
            final int ui = convert(unique);
            orderedFreqMap.put(ui, converting(UNIQUES[i].substring(1).toCharArray()));
            orderedDigitMap.put(ui, VALS[i]);
        }
        ORDERED_FREQ_MAP = Collections.unmodifiableMap(orderedFreqMap);
        ORDERED_DIGIT_MAP = Collections.unmodifiableMap(orderedDigitMap);
    }

    public String originalDigits(String s) {
        final int[] freqs = new int[26];
        for (int i = 0; i < s.length(); ++ i) {
            freqs[convert(s.charAt(i))]++;
        }
        final String[] strings = new String[10];
        for (Map.Entry<Integer, List<Integer>> entry : ORDERED_FREQ_MAP.entrySet()) {