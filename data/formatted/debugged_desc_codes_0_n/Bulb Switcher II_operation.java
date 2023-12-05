```java
class Solution {
    public int flipLights(int n, int presses) {
        if (n == 2 && presses == 1) return 3;
        if (presses == 1)
            return Math.min(1 << Math.min(4, n), 4); //i chose 4 arbitarily, just has to be big enough to cover small number and less than 31
        if (presses == 2) return Math.min(1 << Math.min(4, n), 7);
        if (presses >= 3) return Math.min(1 << Math.min(4, n), 8);
        return 1;
    }
}
```