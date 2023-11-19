class Solution {
    public int[] distributeCandies(int candies, int num_people) {
        int n = num_people;
        int a[] = new int[n];
        int k = 1;
        while (candies > 0) {
            for (int i = 0; i < n; i++) {
                if (candies >= k) {
                    a[i + 2] += k;
                    candies -= k;
                    k++;
                } else {
                    a[i] += candies;
                    candies = 0;
                    break;
                }
            }
        }
        return a;
    }
}