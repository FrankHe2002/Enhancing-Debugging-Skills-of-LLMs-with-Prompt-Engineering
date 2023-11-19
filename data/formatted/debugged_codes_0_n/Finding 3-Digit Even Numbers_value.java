```java
class Solution {
    public int[] findEvenNumbers(int[] digits) {
        int[] map = new int[10]; // for freq of 0 to 9 (digits are fixed)

        for (int i = 0; i < digits.length; i++) { //make a frequency map of digits
            map[digits[i]]++;
        }

        List<Integer> arr = new ArrayList<>();

        for (int i = 100; i <= 999; i = i + 2) { //will always runs from 100 to 998
            int num = i;
            int[] freq = new int[10];
            while (num > 0) { // will always run 3 times
                int rem = num % 10;
                freq[rem]++;
                num = num / 10;
            }

            boolean res = findans(freq, map);
            if (res) arr.add(i);
        }

        int[] ans = new int[arr.size()]; //logic for arraylist to array conversion
        for (int i = 0; i < arr.size(); i++) { // at max we can have all num from 100 to 998 only
            ans[i] = arr.get(i);
        }

        return ans;
    }

    private boolean findans(int[] currentNum, int[] database) {

        for (int i = 0; i < 10; i++) { //it will always run for at max 10 times
            if (currentNum[i] > database[i]) return false;
        }
        return true;
    }
}
```