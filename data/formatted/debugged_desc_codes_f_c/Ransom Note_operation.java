# Code Description:
The canConstruct function in the Solution class is designed to determine if the ransomNote can be constructed using the letters from the magazine. It returns true if ransomNote can be constructed and false otherwise.
Constraints:
	1 <= ransomNote.length, magazine.length <= 105
	ransomNote and magazine consist of lowercase English letters.

# Modified Code:
```java
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        for (int i = 0; i < ransomNote.length(); i++) {
            String t = ransomNote.substring(i, i + 1);
            int idx = magazine.indexOf(t);
            if (idx == -1) return false;
            magazine = magazine.substring(0, idx) + magazine.substring(idx + 1);
        }
        return true;
    }
}
```