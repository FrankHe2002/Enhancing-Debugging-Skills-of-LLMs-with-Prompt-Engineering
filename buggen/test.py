import bugs

CODE_1 = """
public class Test {
    public static void main(String[] args) {
        int[] arr = new int[10];
        int x = 3, y = 2;
        int tmp = -1;
        double z = 0.1;
        for (int i = 0; i < 10; i++) {
            arr[i] = i;
            System.out.println(arr[i]);
        }
    }
}
"""

CODE_2 = """
public class Test {
    public static void main(String[] args) {
        for (int i = 1; i <= 100; i++) {
            if (i % 3 == 0) System.out.print("Fizz");
            if (i % 5 == 0) System.out.print("Buzz");
            System.out.println();
        }
    }
}
"""

def test_find_variables():
    """Test find_variables()"""
    arr = bugs.find_variables(CODE_1)
    arr.sort()
    assert arr == ['System', 'Test', 'args', 'arr', 'i', 'out', 'tmp', 'x', 'y', 'z']

def test_find_variables_int():
    """Test find_variables_int()"""
    arr = bugs.find_variables_int(CODE_1)
    arr.sort()
    print(arr)
    assert arr == ['x', 'y']

def main():
    """Run all tests"""
    test_find_variables()
    test_find_variables_int()

if __name__ == '__main__':
    main()