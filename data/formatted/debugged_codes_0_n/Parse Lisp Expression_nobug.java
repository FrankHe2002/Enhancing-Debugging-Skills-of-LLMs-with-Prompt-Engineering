```java
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Deque;
import java.util.LinkedList;

class Solution {

    String expression;
    int index;
    HashMap<String, Deque<Integer>> scope;

    public int evaluate(String expression) {
        this.expression = expression;
        index = 0;
        scope = new HashMap<>();
        return evaluate();
    }

    private int evaluate() {

        if (expression.charAt(index) == '(') {
            index++; //skip '('
            char begin = expression.charAt(index);
            int ret;
            if (begin == 'l') {
                index += 4; //skip let and a blank space
                ArrayList<String> vars = new ArrayList<>();
                while (true) {
                    if (! Character.isLowerCase(expression.charAt(index))) {
                        ret = evaluate();
                        break;
                    }
                    String var = parseVar();
                    if (expression.charAt(index) == ')') {
                        ret = scope.get(var).peek();
                        break;
                    }
                    vars.add(var);
                    index++;
                    int e = evaluate();
                    scope.putIfAbsent(var, new LinkedList<>());
                    scope.get(var).push(e); //assign a new value
                    index++;
                }
                for (String var : vars) {
                    scope.get(var).pop(); // remove all values of this scope
                }

            } else if (begin == 'a') {
                index += 4;
                int v1 = evaluate();
                index++;
                int v2 = evaluate();
                ret = v1 + v2;
            } else {
                index += 5;
                int v1 = evaluate();
                index++;
                int v2 = evaluate();
                ret = v1 * v2;
            }
            index++; // skip ')'
            return ret;
        } else {
            if (Character.isLowerCase(expression.charAt(index))) {
                String var = parseVar();
                return scope.get(var).peek();
            } else {
                return parseInt();
            }
        }
    }

    private int parseInt() {
        boolean negative = false;
        if (expression.charAt(index) == '-') {
            negative = true;
            index++;
        }
        int ret = 0;
        while (Character.isDigit(expression.charAt(index))) {
            ret *= 10;
            ret += expression.charAt(index) - '0';
            index++;
        }
        if (negative) return - ret;
        return ret;
    }

    private String parseVar() {
        StringBuilder sb = new StringBuilder();
       