```java
    public int divisorSubstrings(int num, int k) {
        String str = String.valueOf(num); 
        int count = 0; 
        for (int i = 0; i <= str.length() - k; i++) 
        {
            String temp = str.substring(i, i + k); 
            int n1 = Integer.valueOf(temp); 
            if (n1 == 0) 
            {
                continue;
            }
            if (num % n1 == 0) 
            {
                count++;
            }
        }
        return count;
	}
```