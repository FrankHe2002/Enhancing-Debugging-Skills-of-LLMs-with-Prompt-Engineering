```java
class Solution {
    public int countCollisions(String directions) {
        int left = 0, right = directions.length() - 1;

        while (left < directions.length() && directions.charAt(left) == 'L') {
            left++;
        }

        while (right >= 0 && directions.charAt(right) == 'R') {
            right--;
        }

        int count = 0;
        for (int i = left; i < right; i++) {
            if (directions.charAt(i) == 'L' && directions.charAt(i + 1) == 'R') {
                count += 2;
            } else if (directions.charAt(i) != 'S' && directions.charAt(i + 1) == 'S') {
                count++;
            }
        }

        return count;
    }

    public boolean isCollision(int speed, int time) {
        return speed == 0 && time > 0;
    }
}
```