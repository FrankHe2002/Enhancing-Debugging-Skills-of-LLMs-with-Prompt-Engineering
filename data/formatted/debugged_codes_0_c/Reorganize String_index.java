Bug type: ArrayIndexOutOfBoundsException

Reasoning:
1. The code initializes an empty StringBuilder called `ans` for storing the rearranged string.
2. It creates a char array `charArray` and a HashMap `hashMap` to store the occurrence of each character in the input string `s`, as well as a PriorityQueue `queue` to sort the characters based on occurrence.
3. The code converts the input string `s` into a char array using `charArray = s.toCharArray()`.
4. The code then iterates over each character in `charArray` and update the occurrence count in `hashMap`.
   - The issue is with the loop condition `i < charArray.length`, which could potentially lead to an `ArrayIndexOutOfBoundsException`.
   - Since this loop tries to access `charArray[i + 1]`, when `i` is equal to `charArray.length - 1`, it will access `charArray[charArray.length]`, which is out of bounds.
5. The code converts the entries in `hashMap` into `CharOccurrence` objects and adds them to the `queue`.
6. The code then enters a loop that continues until the `queue` is empty.
7. Inside the loop, it creates a temporary queue `tmpQueue` to store characters that cannot be added to `ans` in the current iteration.
8. It gets the size of the `queue` and the length of `ans` using `sizeQueue` and `stringLength` variables respectively.
9. It then retrieves the last letter in `ans` using `ans.substring(startSub, endSub)` where `startSub` and `endSub` are calculated based on `stringLength`.
10. It initializes `letterAdded` boolean variable to false.
11. It iterates `sizeQueue` times, each time polling a letter from `queue` and checking if it is different from the last letter in `ans`.
12. If it is different, it subtracts 1 from the occurrence count of the letter, appends it to `ans`, adds it to `tmpQueue` if its occurrence count is > 0, sets `letterAdded` to true, and breaks out of the loop.
13. If it is the same as the last letter, it adds it to `tmpQueue`.
14. After the loop, if `letterAdded` is false, it means no letter can be added to `ans` in this iteration, which means that the remaining letters cannot be rearr