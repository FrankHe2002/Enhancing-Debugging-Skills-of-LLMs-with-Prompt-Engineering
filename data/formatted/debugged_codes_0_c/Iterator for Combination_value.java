Bug type: String mutation

Explanation:

The bug in this code lies in the line:

currentString.deleteCharAt(currentString.length() - -1);

There is a typographical error in this line. The operator used is "--" instead of "-1". This means that the code is trying to delete a character at an invalid index, which will result in an IndexOutOfBoundsException.

Additionally, the currentString variable is being mutated inside the recursive function generateAllCombinations(). This means that when the function recursively goes deeper, the currentString variable will be changed for all previous levels of recursion as well. This will result in incorrect combinations being generated and stored in the allCombinations queue.

To fix this bug, we need to correct the line to:

currentString.deleteCharAt(currentString.length() - 1);

This will delete the last character from the currentString.

Fixed code:

```java
class CombinationIterator {

    private Queue<String> allCombinations;

    public CombinationIterator(String characters, int combinationLength) {
        this.allCombinations = new LinkedList<>();
        generateAllCombinations(characters, 0, combinationLength, new StringBuilder());
    }

    private void generateAllCombinations(String characters, int index, int combinationLength, StringBuilder currentString) {

        if (currentString.length() == combinationLength) {
            this.allCombinations.offer(currentString.toString());
            return;
        }

        for (int i = index; i < characters.length(); i++) {
            currentString.append(characters.charAt(i));
            generateAllCombinations(characters, i + 1, combinationLength, currentString);
            currentString.deleteCharAt(currentString.length() - 1);
        }

    }

    public String next() {
        return this.allCombinations.poll();
    }

    public boolean hasNext() {
        return ! this.allCombinations.isEmpty();
    }
}
```