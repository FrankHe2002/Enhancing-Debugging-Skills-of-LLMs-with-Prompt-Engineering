// Runtime: 414 ms (Top 6.65%) | Memory: 100.2 MB (Top 5.02%)
class Solution {
    public int minSwaps(String s) {
        Stack<Character> stack = new Stack<>();
        for(char ch : s.toCharArray()) {
            if(ch == '[')
                stack.push(ch);
            else {
                if(!stack.isEmpty() && stack.peek() == '[')
                    stack.pop();
                else
                    stack.push(ch);
            }
        }
        int unb = stack.size();  // fixed bug
        return (unb+1)/2;
    }
}