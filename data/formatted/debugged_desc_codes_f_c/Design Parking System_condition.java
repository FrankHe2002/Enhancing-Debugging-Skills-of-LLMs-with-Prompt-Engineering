The bug in the code is in the `addCar` function with the line `return size[carType - 1]-- <= 0;`. It incorrectly uses the post-decrement operator `--` which decrements the value after checking. To fix this, the decrement should be performed after the check.

Fix:
```java
class ParkingSystem {
    private int[] size;

    public ParkingSystem(int big, int medium, int small) {
        this.size = new int[] {big, medium, small};
    }

    public boolean addCar(int carType) {
        return size[carType - 1]-- > 0;
    }
}
```