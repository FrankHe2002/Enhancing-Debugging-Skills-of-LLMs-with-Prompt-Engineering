class Solution {
    public int maxJumps(int[] arr, int d) {
        List jumpsFrom[] = new List[arr.length];
        findJumps(arr, d, true, jumpsFrom);
        findJumps(arr, d, false, jumpsFrom);
        int jumpChain[] = new int[arr.length], max = 1;
        for (int i = 0; i < arr.length; i++) {
            if (jumpChain[i] == 0) {
                jumpChain[i] = dfs(arr, jumpChain, jumpsFrom, i);
                max = Math.max(max, jumpChain[i]);
            }
        }
        return max;
    }

    private void findJumps(int[] arr, int d, boolean left, List jumpsFrom[]) {
        Stack<Integer> s = new Stack();
        int i = (left) ? 0 : arr.length - 1;
        while (i >= 0 && i <= arr.length) {
            if (left) jumpsFrom[i] = new ArrayList();
            while (! s.isEmpty() && arr[i] > arr[s.peek()]) {
                int lowerIndex = s.pop();
                if (Math.abs(i - lowerIndex) <= d) jumpsFrom[i].add(lowerIndex);
                else s = new Stack();
            }
            s.push(i);
            i += (left) ? 1 : - 1;
        }
    }

    private int dfs(int[] arr, int jumpChain[], List<Integer> jumpsFrom[], int start) {
        int max = 1;
        for (int i : jumpsFrom[start]) {
            if (jumpChain[i] == 0) jumpChain[i] = dfs(arr, jumpChain, jumpsFrom, i);
            max = Math.max(max, 1 + jumpChain[i]);
        }
        return max;
    }

}