```java
// Runtime: 39 ms (Top 41.79%) | Memory: 50.4 MB (Top 43.28%)
class Solution {
    // To Get the value of index traversed in a recursive call.
    int index = 0;

    public List<String> braceExpansionII(String expression) {
        List<String> result = util(0, expression);
        Set<String> set = new TreeSet<>();
        set.addAll(result);
        return new ArrayList<>(set);
    }

    List<String> util(int startIndex, String expression) {
        // This represents processed List in the current recursion.
        List<String> currentSet = new ArrayList<>();
        boolean isAdditive = false;
        String currentString = "";
        // This represents List that is being processed and not yet merged to currentSet.
        List<String> currentList = new ArrayList<>();

        for (int i = startIndex; i < expression.length(); ++i) {

            if (expression.charAt(i) == ',') {
                isAdditive = true;
                if (!currentString.equals("") && currentList.size() == 0) {
                    currentSet.add(currentString);
                } else if (currentList.size() > 0) {
                    for (var entry : currentList) {
                        currentSet.add(entry);
                    }
                }

                currentString = "";
                currentList = new ArrayList<>();
            } else if (expression.charAt(i) >= 'a' && expression.charAt(i) <= 'z') {
                if (currentList.size() > 0) {
                    List<String> tempStringList = new ArrayList<>();
                    for (var entry : currentList) {
                        tempStringList.add(entry + expression.charAt(i));
                    }
                    currentList = tempStringList;
                } else {
                    currentString = currentString + expression.charAt(i);
                }
            } else if (expression.charAt(i) == '{') {
                List<String> list = util(i + 1, expression);
                // System.out.println(list);
                // Need to merge the returned List. It could be one of the following.
                // 1- ..., {a,b,c}
                // 2- a{a,b,c}
                // 3- {a,b,c}{d,e,f}
                // 3- {a,b,c}d
                if (i > startIndex && expression.charAt(i - 1) == ',') {
                    // Case 1
                    currentList = list;
                } else {
                    if