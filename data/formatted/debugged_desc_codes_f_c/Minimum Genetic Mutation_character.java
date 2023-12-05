There are several minor bug identification and fixes in the given codes. I will update the codes accordingly:

1) Missing semicolon

```java
public String repeatChar(char c, int times) {
        String result = "";
        for (int i = 0; i < times; i++) {
            result += c;
        }
        return result;
    }
```

2) Change addition to multiplication

```java
public int multiply(int a, int b) {
        return a * b;
    }
``` 

3) Change condition from `==1` to `==0`

```java
public boolean isEven(int num) {
        return num % 2 == 0;
    }
```

4) Adjust the condition

```java
public boolean isLeapYear(int year) {
        if ((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0)) {
            return true;
        }
        return false;
    }
```