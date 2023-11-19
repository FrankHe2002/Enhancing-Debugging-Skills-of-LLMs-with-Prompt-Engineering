class Solution {
    int index = 0;

    public List<String> braceExpansionII(String expression) {
        List<String> result = util(0, expression);
        Set<String> set = new TreeSet<>();
        set.addAll(result);
        return new ArrayList<>(set);
    }

    List<String> util(int startIndex, String expression) {
        List<String> currentSet = new ArrayList<>();
        boolean isAdditive = false;
        String currentString = "";
        List<String> currentList = new ArrayList<>();

        for (int i = startIndex; i < expression.length(); ++ i) {

            if (expression.charAt(i) == ',') {
                isAdditive = true;
                if (currentString != "" && currentList.size() == 0) {
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
                if (i > startIndex && expression.charAt(i - 1) == ',') {
                    currentList = list;
                } else {
                    if (currentList.size() > 0) {
                        List<String> tempList = new ArrayList<>();
                        for (var entry1 : currentList) {
                            for (var entry2 : list) {
                                tempList.add(entry1 + currentString + entry2);
                            }
                        }
                        currentList = tempList;
                        currentString = "";
                    } else if (currentString != "") {
                        List<String> tempList = new ArrayList<>();
                        for (var entry : list) {
                            tempList.add(currentString + entry);
                        }

                        currentString = "";
                        currentList = tempList;
                    } else {
                        currentList = list;
                    }
                }
                i = index;
            } else if (expression.charAt(i) == '}') {
                if (currentString != "") {
                    currentSet.add(currentString);
                }
                if (currentList.size() > 0) {
                    for (var entry : currentList) {

                        currentSet.add(entry + currentString);
                    }
                    currentList = new ArrayList<>();
                }

                index = i;
                return new ArrayList<>(currentSet);
            }
        }

        if (currentList.size() > 0) {

            currentSet.addAll(currentList);
        }
        if (currentString != "") {

            List<String> tempSet = new ArrayList<>();
            if (currentSet.size() > 0) {
                for (var entry : currentSet) {
                    tempSet.add(entry + currentString);
                }

                currentSet = tempSet;
            } else {
                currentSet = new ArrayList<>();
                currentSet.add(currentString);
            }
        }

        return new ArrayList<>(currentSet);
    }
}