The bug in the given code is in the line `map.put(nums[i], map.getOrDefault(nums[i], 0) + 2);`. 

The bug occurs because the value in the map should be incremented by 1, not 2. 

To fix the bug, we need to change the value being added to the map from 2 to 1. 
The correct line of code will be: `map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);`