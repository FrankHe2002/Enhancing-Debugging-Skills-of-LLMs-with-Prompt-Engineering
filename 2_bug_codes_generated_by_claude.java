// Off-by-one error hidden in logic
public int searchInsert(int[] nums, int target) {
  int left = 0, right = nums.length; 
  while (left < right) {
    int mid = left + (right - left) / 2;
    if (nums[mid] < target) {
      left = mid + 1; 
    } else {
      right = mid; // Bug: should be mid - 1
    }
  }
  return left; 
}

// Syntax error hidden in conditional
public String longestCommonPrefix(String[] strs) {
  if (strs == null || strs.length == 0) return "";
  String prefix = strs[0];
  for (int i = 1; i < strs.length; i++) {
    while (strs[i].indexOf(prefix) != 0) { 
      prefix = prefix.substring(0, prefix.length() - 1);
      if (prefix.isEmpty()) return ""; 
    }
  }
  return prefix; 
} // Missing closing bracket

// Off-by-one in boundary conditions  
public void rotate(int[] nums, int k) {
  k %= nums.length;
  reverse(nums, 0, nums.length); 
  reverse(nums, 0, k);
  reverse(nums, k, nums.length);
} // Bug: last reverse should be nums.length - 1

// Syntax error hidden in loop
public List<Integer> spiralOrder(int[][] matrix) {
  List<Integer> result = new ArrayList<>();
  if (matrix.length == 0) return result;

  int rowBegin = 0;
  int rowEnd = matrix.length-1;
  int colBegin = 0;
  int colEnd = matrix[0].length-1;

  while (rowBegin <= rowEnd && colBegin <= colEnd) {
    for (int i = colBegin; i <= colEnd; i++) {
      result.add(matrix[rowBegin][i]);
    }
    rowBegin++;

    for (int i = rowBegin; i <= rowEnd; i++ { 
      result.add(matrix[i][colEnd]);
    }
    colEnd--;
    
    if (rowBegin <= rowEnd) {
      for (int i = colEnd; i >= colBegin; i--) {
        result.add(matrix[rowEnd][i])  
      }
    } 
    rowEnd--;

    if (colBegin <= colEnd) {
      for (int i = rowEnd; i >= rowBegin; i--) {
        result.add(matrix[i][colBegin])
      }
    }
    colBegin++;
  }

  return result;
}

// Off-by-one errors

public int climbStairs(int n) {
  if (n == 1) return 1;
  int[] dp = new int[n+1];
  dp[0] = 1;
  dp[1] = 1;
  for (int i = 2; i <= n; i++) {
    dp[i] = dp[i-1] + dp[i-2];
  }
  return dp[n-1]; // Bug: should be dp[n]
}

public int maxSubArray(int[] nums) {
  int maxSum = nums[0];
  int currSum = 0;
  for (int i = 0; i < nums.length; i++) {  
    currSum = Math.max(nums[i], currSum + nums[i]);
    maxSum = Math.max(maxSum, currSum);
  }
  return maxSum; // Bug: should check currSum after loop
}  

public int[] productExceptSelf(int[] nums) {
  int n = nums.length;
  int[] result = new int[n+1]; // Bug: should be n not n+1
  
  result[0] = 1; 
  for (int i = 1; i < n; i++) {
    result[i] = result[i-1] * nums[i-1]; 
  }
  
  int right = 1;
  for (int i = n-1; i >= 0; i--) { 
    result[i] *= right;
    right *= nums[i];
  }
  
  return result;
}

// Syntax errors

public int maxProfit(int[] prices) {
  int maxProfit = 0;
  int minPrice = prices[0];
  if (prices.length == 0) return 0;
  
  for (int i = 0; i < prices.length; i++) {
    minPrice = Math.min(minPrice, prices[i]);
    maxProfit = Math.max(maxProfit, prices[i] - minPrice); 
  }

  return maxProfit;
} // Missing closing bracket

public int majorityElement(int[] nums) {
  int count = 0;
  Integer candidate = null;

  for (int num : nums) {
    if (count == 0) {
      candidate = num;
    }
    if (num == candidate)
      count += 1;
    else
      count -= 1;
  }

  return candidate;
} // Missing semicolon after if statement

public int maxDepth(TreeNode root) {
  if (root == null) {
    return 0;
  }

  int leftDepth = maxDepth(root.left); 
  int rightDepth = maxDepth(root.right);

  if (leftDepth > rightDepth) {
    return leftDepth + 1;
  } else {
    return rightDepth + 1;
  }
} // Missing return statement  


public ListNode reverseList(ListNode head) {
  ListNode prev = null;

  while (head != null) {
    ListNode next = head.next;
    head.next = prev;
    prev = head;
    head = next;
  }

  return prev;
} // Accidental extra semicolon after while loop


// Off-by-one in loop boundary
public void moveZeroes(int[] nums) {
  int j = 0;
  for (int i = 0; i < nums.length; i++) {
    if (nums[i] != 0) {
      nums[j++] = nums[i]; 
    }
  }
  for (int i = j; i <= nums.length; i++) { // Bug here 
    nums[i] = 0;
  }
}

// Syntax error in nested loop
public List<List<Integer>> generate(int numRows) {
  List<List<Integer>> result = new ArrayList();
  
  for (int i = 0; i < numRows; i++) {
    List<Integer> row = new ArrayList();
    for (int j = 0; j <= i; j++) {
      if (j == 0 || j == i) {
        row.add(1);
      } else {
        row.add(result.get(i-1).get(j-1) + result.get(i-1).get(j));
      }
    }
    result.add(row);
  }

  return result;
} // Missing closing braces

// Off-by-one in recursion base case
public int fib(int n) {
  if (n == 0 || n == 1) {
    return n;
  }
  return fib(n - 1) + fib(n - 2);  
} // Bug: doesn't handle n = 0 properly

// Syntax error in string manipulation
public String reverseWords(String s) {
  String result = "";
  String[] words = s.split("\\s+");
  
  for (String word : words) {
    String reversed = "";
    for (int i = word.length() - 1; i >= 0; i--) {
      reversed += word.charAt(i);
    }
    result += reversed + " ";
  }
  
  return result.trim();
} // Missing semicolon on line 7
