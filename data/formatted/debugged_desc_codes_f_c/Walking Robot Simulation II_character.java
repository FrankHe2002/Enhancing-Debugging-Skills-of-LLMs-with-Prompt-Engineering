```java
// Runtime: 134 ms (Top 50.88%) | Memory: 98.9 MB (Top 12.28%)
class Robot {

    int x;
    int y;
    int width;
    int height;
    int direction;

    public Robot(int width, int height) {
        x = 0;
        y = 0;
        this.width = width;
        this.height = height;
        direction = 1;
    }

    public void step(int num) {
        while(num > 0){
            if(direction == 1){
                if(x + num < width){
                    x += num;
                    num = 0;
                } else {
                    num -= (width - x);
                    x = width;
                    direction = 2;
                }
            } else if(direction == 2){
                if(y + num < height){
                    y += num;
                    num = 0;
                } else {
                    num -= (height - y);
                    y = height;
                    direction = 4;
                }
            } else if(direction == 3){
                if(x - num >= 0){
                    x -= num;
                    num = 0;
                } else {
                    num -= x;
                    x = 0;
                    direction = 4;
                }
            } else { 
                if(y - num >= 0){
                    y -= num;
                    num = 0;
                } else {
                    num -= y;
                    y = 0;
                    direction = 1;
                }
            }
        }
    }

    public int[] getPos() {
        return new int[] {x, y};
    }

    public String getDir() {
        if(direction == 1){
            return "East";
        } else if(direction == 2){
            return "North";
        } else if(direction == 3){
            return "West";
        } else if (direction == 4){
            return "South";
        }
        return "";
    }
}
```