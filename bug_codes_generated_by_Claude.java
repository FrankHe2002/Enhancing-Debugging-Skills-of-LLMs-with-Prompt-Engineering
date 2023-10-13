// Infinite recursion
public class RecursiveError {
  public static void main(String[] args) {
    printNumbers(1);
  }

  public static void printNumbers(int i) {
    System.out.println(i);
    printNumbers(i+1); // this will never terminate
  }
}

// Infinite loop
public class InfiniteLoopError {
  public static void main(String[] args) {
    int i = 0;
    while(i < 10) {
      System.out.println(i);
    } // missing i++ 
  }
}

// Using variable before initialization 
public class UninitializedVariableError {
  public static void main(String[] args) {
    int x;
    System.out.println(x); // x is not initialized
    x = 10;
  }
}

// IndexOutOfBoundsException
public class IndexOutOfBoundsError {
  public static void main(String[] args) {
    int[] numbers = {1, 2, 3};
    System.out.println(numbers[10]); // index too large
  }
} 

// NullPointerException
public class NullPointerError {
  public static void main(String[] args) {
    String str = null;
    System.out.println(str.length()); // null has no methods
  }
}

// ClassCastException
public class ClassCastError {
  public static void main(String[] args) {
    Object x = new Integer(10); 
    String s = (String)x; // cannot cast Integer to String
  }
}

// ArithmeticException
public class ArithmeticError {
  public static void main(String[] args) {
    int x = 1/0; // cannot divide by zero
  }
}

// ArrayIndexOutOfBoundsException
public class ArrayIndexError {
  public static void main(String[] args) {
    int[] arr = new int[5];
    arr[10] = 1; // index too large 
  }
}

// Race condition with non-atomic operations
class BankAccount {
  private int balance;

  public void deposit(int amount) {
    int tmp = balance;
    tmp += amount;
    balance = tmp; 
  }

  public void withdraw(int amount) {
    int tmp = balance;
    tmp -= amount;
    balance = tmp;
  }
}

// Resource leak - stream not closed
import java.io.*;

class CopyFile {
  public static void copy(File src, File dest) throws IOException {
    InputStream in = new FileInputStream(src);
    OutputStream out = new FileOutputStream(dest);

    byte[] buffer = new byte[1024];
    int length;
    while ((length = in.read(buffer)) > 0) {
      out.write(buffer, 0, length);
    }

    // Missing finally block to close streams
  }
}

// Race condition with non-synchronized method
import java.util.ArrayList;

class DataProcessor {
  private ArrayList<String> data = new ArrayList<>();

  public void processData(String item) { 
    data.add(item); 
  }

  public int getDataCount() {
    return data.size();
  }
}

// Incorrect string comparison  
public class LoginServlet extends HttpServlet {
  public void doPost(HttpServletRequest request, HttpServletResponse response) {
    String password = request.getParameter("password");
    
    // Subtle bug using == instead of .equals()
    if (password == "p@ssw0rd") {
      // authenticate user
    }
  }
}

// Off-by-one error in loop condition
public class ArraySum {
  public static int sum(int[] arr) {
    int sum = 0;
    for (int i = 0; i <= arr.length; i++) {
      sum += arr[i];
    }
    return sum;
  }
}

// Typo in method name
public class Calculator {
  public int add(int x, int y) {
    return x + y;
  }
  
  public int substract(int x, int y) { // should be subtract
    return x - y;
  }
}

// Broken object equality check
public class Person {
  String name;
  
  public boolean equals(Object o) {
    Person p = (Person) o;
    return name == p.name; // should use .equals
  }
}

// Mismatched synchronize blocks
public class TaskProcessor {

  Object lock1 = new Object();
  Object lock2 = new Object();

  public void processTask1() {
    synchronized(lock1) {
      // access resource 1
    }
  }
  
  public void processTask2() {
    synchronized(lock2) {
      // access resource 2
    }
  }
}

// Missing break statement in switch  
public class Calculator {
  public void calculate(char op) {
    int result;
    switch(op) {
      case '+':
        // addition 
        result = 2 + 2;
      case '-':  
        // subtraction
        result = 5 - 3; 
    }
  }
}

// Using = instead of == 
if(x = 5) {
  // ...
}

// Calling methods on null reference
String str = null;
str.length();

// Loop index modified within loop
for(int i = 0; i < 10; i++) {
  i++;
}

// Comparator implemented incorrectly
class StringLengthComparator implements Comparator<String> {
  public int compare(String s1, String s2) {
    return s1.length() - s2.length(); // should be s1.length() - s2.length()
  }
}

// Race condition with non-volatile variable
class DataProcessor {
  boolean done = false;
  
  public void processData() {
    while(!done) {
      // process data
    }
  } 
  
  public void finish() {
    done = true;
  }
}

// Exception swallowing 
try {
  // read file
} catch (IOException e) {
  // ignore exception
}

// Integer overflow  
int x = Integer.MAX_VALUE;
x++;

// Using bitwise operator instead of logical  
if (x & y) {
  // ...
}

// Comparing floating point values directly
if(x == 10.0) {
  // ...
} 

// Returning reference to local variable
public String[] getStrings() {
  String[] arr = new String[5];
  // populate arr
  return arr;
}

// Unchecked infinite recursion
public void recurse() {
  // ...
  recurse();
}

// Using wrong equality operator
if (obj.equals(otherObj)) {
  // ...
}

// Race condition with double-checked locking
if(instance == null) {
  synchronized(this) {
    if(instance == null) {
      instance = new Instance(); 
    }
  }
}

// Error handling missing
try {
  // read file
} catch(IOException e) {
  
}

// Leftover debugging code
int x = 5;
System.out.println("x: " + x);

// Field visibility allowing invalid state
public class Rectangle {
  public int length;
  public int width;
}

// Truthy condition using == 
if(str == "sometext") {
  // ...
}

// Unnecessary object creation
String s1 = new String("test");
String s2 = new String("test"); 

// Race condition with shared data
Data data = new Data();

new Thread(()->{
  data.x++;
}).start();

new Thread(()->{
  data.x++;
}).start();

// Invalid string compare 
if(str.equals("TEST")) {
  // ...
}

// Use of default seed for random numbers
new Random().nextInt()

// Statement missing braces  
if(x > 0)
  System.out.println("Positive");

// Unneeded temporary objects 
String temp = new String("demo");
System.out.println(temp);

// Swallowing base case in recursion
public void decrement(int i) {
  if(i < 0) {
    return;
  }
  
  decrement(i--);
}

// Null check missing
String str = getString();
int length = str.length();

// Magic number usage
if(x == 60) {
  // ...
}

// Failed instanceof check
if(!(obj instanceof String)) {
  // ...
}

// Rounding error with float 
float f = 1.45f;
int i = f;

// Leftover debug print statement
System.out.println("Reached here");

// Using bitwise operator instead of boolean  
if(x & y) {
  //...
}

// Race condition non-atomic operation
x++; 

// Missing break in switch
switch(num) {
  case 1:
    x = 1;
  case 2:
    x = 2;
}

// Unnecessary object instantiation
Point p = new Point(x, y);

// Comparing strings with ==
if(str == "test")

// InterruptedException ignored
try {
  Thread.sleep(1000);
} catch (InterruptedException e) {}

// Leftover test code  
assertEquals(5, x);

// Division without checking for zero
int result = 10 / denominator;

// Using wrong equality test
if(obj.equals(otherObj))

// Race condition non-synchronized access
public int x = 0;

void inc() {
  x++;
}

// Null check missing  
String s = null;
int length = s.length();

// Magic number
if (x > 60) {
  // ...
}

// Comparing floating point values  
if(x == 10.0f) {
  // ...
}

// Leftover debug print
System.out.println("Reached here");

// Race condition non-atomic operation
x--;

// Double-checked locking incorrect
if(instance == null) {
  synchronized(this) {
    if(instance == null) {
      instance = new Instance();
    }
  }
}

// Swallowing exceptions
try {
  // read file 
} catch(IOException e) {
  
}

// Leftover test code
assertEquals(5, x); 

// Magic number
if(x > 10) {
  //...
}

// Truthy check using ==
if(str == "test") {
  //...
} 

// Rounding error  
float f = 1.35f;
int i = f;

// Unchecked infinite recursion
void recurse() {
  // ...
  recurse();
}

// Unnecessary object creation
String s = new String("test");

// InterruptedException ignored
Thread.sleep(1000);

// Statement missing braces
if(x > 0)
  System.out.println("Positive");

// Null check missing
String s = getString();
s.length();

// Comparing floats
if(x == 1.0f) {
  
}

// Leftover debug println
System.out.println("Reached here");

// Resource leak
FileInputStream fis = new FileInputStream(file);
// ...
// fis.close() missing