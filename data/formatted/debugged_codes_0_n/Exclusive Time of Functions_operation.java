class Solution {

    public int[] exclusiveTime(int n, List<String> logs) {
        if (n == 0) {
            return new int[0];
        }

        int[] result = new int[n];

        Stack<Pair<Integer, Integer>> stack = new Stack<>();

        for (String s : logs) {
            String[] sArr = s.split(":");
            int functionId = Integer.parseInt(sArr[0]);
            String startOrEnd = sArr[1];
            int timestamp = Integer.parseInt(sArr[2]);

            if (startOrEnd.equals("start")) {
                if (! stack.empty()) {
                    Pair<Integer, Integer> pair = stack.peek();
                    int oldFunctionId = pair.getKey();
                    int oldTimestamp = pair.getValue();
                    result[oldFunctionId] += timestamp - oldTimestamp;
                }
                stack.push(new Pair(functionId, timestamp));
            } else {
                Pair<Integer, Integer> pair = stack.pop();
                int oldTimestamp = pair.getValue();

                result[functionId] += timestamp - oldTimestamp + 1;
                if (! stack.empty()) {
                    pair = stack.peek();
                    int replacementTimestamp = pair.getValue();
                    stack.pop();
                    stack.push(new Pair(pair.getKey(), timestamp + 1));
                }
            }
        }

        return result;
    }
}