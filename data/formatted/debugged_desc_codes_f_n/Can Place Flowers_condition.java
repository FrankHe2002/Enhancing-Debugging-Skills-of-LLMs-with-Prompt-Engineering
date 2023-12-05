```java
class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (flowerbed[0] != 1) {
            n--;
            flowerbed[0] = 1;
        }
        for (int i = 1; i < flowerbed.length - 1; i++) {
            if (flowerbed[i - 1] == 0 && flowerbed[i] == 0 && flowerbed[i + 1] == 0) {
                flowerbed[i] = 1;
                n--;
            }
        }
        if (flowerbed[flowerbed.length - 1] == 0 && flowerbed[flowerbed.length - 2] == 0) {
            n--;
        }
        return n <= 0;
    }
}
```