class Solution {
    public String reverseParentheses(String s) {
        Stack<String> stack = new Stack<>();

        int j = 0;
        while (j < s.length()) {
            if (s.charAt(j) != ')')
                stack.push(s.charAt(j) + "");
            else {
                StringBuilder sb = new StringBuilder();
                while (! stack.isEmpty() && ! stack.peek().equals("(")) {
                    sb.append(stack.pop());
                }

                if (! stack.isEmpty()) {
                    stack.pop();
                    stack.push(sb.reverse().toString());
                } else {
                    stack.push(sb.toString());
                }
            }
            j++;
        }

        StringBuilder res = new StringBuilder();
        while (! stack.isEmpty())
            res.append(stack.pop());

        return res.reverse().toString();
    }
}