```java
class Solution {

    public String getHappyString(int n, int k) {
        List<String> innerList = new ArrayList<>();
        getHappyStringUtil(n, k, new char[] {'a', 'b', 'c'}, new StringBuilder(), innerList);
        if (innerList.size() < k)
            return "";
        return innerList.get(k - 1);
    }

    public void getHappyStringUtil(int n, int k, char[] letter, StringBuilder tempString, List<String> innerList) {
        // Base case
        if (tempString.length() == n) {
            innerList.add(tempString.toString());
            return;
        }

        // Recursive call
        for (char ch : letter) {
            if (tempString.length() >= 1 && tempString.charAt(tempString.length() - 1) == ch)
                continue;
            tempString.append(ch);
            getHappyStringUtil(n, k, letter, tempString, innerList);
            tempString.deleteCharAt(tempString.length() - 1);
        }

    }
}
```