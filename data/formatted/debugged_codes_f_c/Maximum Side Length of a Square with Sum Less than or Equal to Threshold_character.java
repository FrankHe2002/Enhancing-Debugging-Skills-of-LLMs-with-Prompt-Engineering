Bug Type: Syntax Error

Reasoning: In the `fun` method, there is a syntax error in the line `int sum = preSum[r][c] - preSum[r - size][c] - preSum[r][c - size] + preSumr - size][c - size];`. The closing bracket for `preSum` is missing, causing a syntax error. Additionally, there is a typo in `preSumr - size]`, the `r` is missing in `preSum`.

Fix: Add the missing closing bracket after `preSum[r - size][c - size]`, and correct the `preSumr` typo to `preSum[r]`.