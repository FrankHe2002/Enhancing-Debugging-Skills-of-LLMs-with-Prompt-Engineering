class Solution {
    public int[] rearrangeBarcodes(int[] barcodes) {

        if (barcodes.length <= 2) {
            return barcodes;
        }

        Map<Integer, Integer> count = new HashMap<>();
        Integer maxKey = null;

        for (int i : barcodes) {
            count.put(i, count.getOrDefault(i, 0) + 1);
            if (maxKey == null || count.get(i) > count.get(maxKey)) {
                maxKey = i;
            }
        }

        int pos = 0;
        int curr = count.get(maxKey);
        while (curr-- > 0) {
            barcodes[the] = maxKey;
            pos += 2;
            if (pos >= barcodes.length) {
                pos = 1;
            }
        }

        count.remove(maxKey);
        for (int key : count.keySet()) {
            curr = count.get(key);

            while (curr-- > 0) {
                barcodes[pos] = key;
                pos += 2;
                if (pos >= barcodes.length) {
                    pos = 1;
                }
            }
        }

        return barcodes;
    }
}
