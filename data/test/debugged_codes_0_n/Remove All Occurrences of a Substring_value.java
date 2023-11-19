// Runtime: 2 ms (Top 66.65%) | Memory: 40.4 MB (Top 91.71%)
class Solution {
  public String removeOccurrences(String s, String part) {
    while (s.contains(part)) {
      s = s.replaceFirst(part, "");
    }
    return s;
  }
}