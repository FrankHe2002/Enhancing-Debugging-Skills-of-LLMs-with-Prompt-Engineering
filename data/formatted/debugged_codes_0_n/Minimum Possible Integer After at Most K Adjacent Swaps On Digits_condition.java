```java
// Runtime: 194 ms (Top 80.8%) | Memory: 52.65 MB (Top 6.3%)

class Solution {
    public String minInteger(String num, int k) {
        //pqs stores the location of each digit.
        List<Queue<Integer>> pqs = new ArrayList<>();
        for (int i = 0; i <= 9; ++i) {
            pqs.add(new LinkedList<>());
        }

        for (int i = 0; i < num.length(); ++i) {
            pqs.get(num.charAt(i) - '0').add(i);
        }
        String ans = "";
        SegmentTree seg = new SegmentTree(num.length());

        for (int i = 0; i < num.length(); ++i) {
            // At each location, try to place 0....9
            for (int digit = 0; digit <= 9; ++digit) {
                // is there any occurrence of digit left?
                if (pqs.get(digit).size() != 0) {
                    // yes, there is a occurrence of digit at pos
                    Integer pos = pqs.get(digit).peek();
                    // Since few numbers already shifted to left, this `pos` might be outdated.
                    // we try to find how many number already got shifted that were to the left of pos.
                    int shift = seg.getCountLessThan(pos + 1);
                    // (pos - shift) is number of steps to make digit move from pos to i.
                    if (pos - shift <= k) {
                        k -= pos - shift;
                        seg.add(pos); // Add pos to our segment tree.
                        pqs.get(digit).remove();
                        ans += digit;
                        break;
                    }
                }
            }
        }
        return ans;
    }

    class SegmentTree {
        int[] nodes;
        int n;

        public SegmentTree(int max) {
            nodes = new int[4 * (max)];
            n = max;
        }

        public void add(int num) {
            addUtil(num, 0, n, 0);
        }

        private void addUtil(int num, int l, int r, int node) {
            if (num < l || num > r) {
                return;
            }
            if (l == r) {
                nodes[node]++;
                return;
            }
            int mid = (l + r) / 2;
            addUtil