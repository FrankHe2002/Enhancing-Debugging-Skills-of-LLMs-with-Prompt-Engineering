```java
class Solution {

    private static final int[] INT_NUMBERS = {
            10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
    private static final String[] STRING_NUMBERS = {
            "Ten", "Nine", "Eight", "Seven", "Six", "Five", "Four", "Three", "Two", "One", ""};

    private static final int BILLION = 1_000_000_000;
    private static final int MILLION = 1_000_000;
    private static final int THOUSAND = 1000;
    private static final int HUNDRED = 100;

    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        return numberToWordsHelper(num);
    }

    private String numberToWordsHelper(int num) {
        if (num >= BILLION) {
            return numberToWordsHelper(num / BILLION) + " Billion" + ((num % BILLION > 0) ? " " + numberToWordsHelper(num % BILLION) : "");
        } else if (num >= MILLION) {
            return numberToWordsHelper(num / MILLION) + " Million" + ((num % MILLION > 0) ? " " + numberToWordsHelper(num % MILLION) : "");
        } else if (num >= THOUSAND) {
            return numberToWordsHelper(num / THOUSAND) + " Thousand" + ((num % THOUSAND > 0) ? " " + numberToWordsHelper(num % THOUSAND) : "");
        } else if (num >= HUNDRED) {
            return numberToWordsHelper(num / HUNDRED) + " Hundred" + ((num % HUNDRED > 0) ? " " + numberToWordsHelper(num % HUNDRED) : "");
        } else if (num >= 20) {
            return STRING_NUMBERS[num/10 + 8] + ((num % 10 > 0) ? " " + numberToWordsHelper(num % 10) : "");
        } else {
            return STRING_NUMBERS[num];
        }
    }
}
```