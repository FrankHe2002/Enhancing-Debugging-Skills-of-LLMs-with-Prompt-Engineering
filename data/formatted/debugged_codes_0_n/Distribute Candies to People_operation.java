```java
class Solution {
    public int[] distributeCandies(int candies, int num_people) {
        int n = num_people;
        int a[] = new int[n];
        int k = 1;
        int i = 0;
        while (candies > 0) {
            if (candies >= k) {
                a[i] += k;
                candies -= k;
            } else {
                a[i] += candies;
                candies = 0;
            }
            
            i = (i + 1) % n;
            k++;
        }
        return a;
    }
}
```