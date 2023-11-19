```java
// Runtime: 624 ms (Top 51.93%) | Memory: 473.4 MB (Top 35.91%)

/**
 * Cases:
 * <p>
 * diff > 0 meaning we need to pick more chars in s1
 * diff < 0 meaning we need to pick more chars in s2
 * <p>
 * -1000 < diff < 1000 as there can be at most 3 digits in the string meaning largest digits are 999
 * <p>
 * 1. s1[i] == s2[j] and diff = 0
 * increment i+1 and j+1
 * <p>
 * 2. if s1[i] is not digit and diff > 0 then increment i i+1, diff
 * 3. if s2[j] is not digit and diff < 0 then increment j j+1, diff
 * 4. if s1[i] is digit then get digit value and decrement diff val as we have covered such chars in the s1 string
 * and increment i i+1, diff-val
 * 5. if s2[j] is digit then get digit value and increment diff val as we need to cover such chars in the s2 string and
 * increment j, j+1, diff+val
 * <p>
 * 01234
 * s1 = l123e
 * s2 = 44
 * <p>
 * i: 0
 * j: 0
 * diff: 0
 * // Wildcard matching on s2[j]
 * val = 4, diff = 0+4 j = 1
 * <p>
 * i: 0
 * j: 1
 * diff: 4
 * // Literal matching on s1[i]
 * increment ith pointer as ith is a literal and we can move on to next char in s1 and decrement diff
 * <p>
 * i: 1
 * j: 1
 * diff: 3
 * // Wildcard matching on s1[i]
 * val = 1 diff = 3-1 = 2 increment i
 * <p>
 * i: 2
 * j: 1
 * diff: 2
 * // Wildcard matching on s1[i]
 * val = 2 diff = 2-2 = 0 increment i
 * <p>
 * i