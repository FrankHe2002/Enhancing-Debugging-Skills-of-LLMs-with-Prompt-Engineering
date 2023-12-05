```java
class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        int lowSize = String.valueOf(low).length(), highSize = String.valueOf(high).length();
        List<Integer> output = new ArrayList<>();

        for (int size = lowSize; size <= highSize; size++) {
            int seedNumber = getSeedNumber(size);
            int limit = (int) Math.pow(10, size);
            while (seedNumber < limit) {
                if (seedNumber >= low && seedNumber <= high)
                    output.add(seedNumber);
                seedNumber = increment(seedNumber);
            }
        }
        Collections.sort(output);
        return output;
    }

    private int getSeedNumber(int size) {
        return (int) Math.pow(10, size - 1);
    }

    private int increment(int seed) {
        int lastDigit = seed % 10;
        if (lastDigit == 9) {
            seed = (seed / 10) + 1;
        } else {
            seed = (seed * 10) + (lastDigit + 1);
        }
        return seed;
    }
}
```