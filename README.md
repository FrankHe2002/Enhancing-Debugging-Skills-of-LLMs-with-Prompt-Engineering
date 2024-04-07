# Enhancing Debugging Skills of LLMs with Prompt Engineering (CSCI499FinalProject)

To call bug_gen from CLI:
`python bug_gen.py -i <Input File Path> -o <Output File Path> -n <# of bugs to introduce, default 5>`

To call bug_gen from code:
`bug_gen.add_bugs(code, num_bugs)`
Where code is a string of java code and num_bugs is the number of bugs to introduce.
Returns the `code` string, with `num_bugs` introduced in it.


### Example Prompt (Output is second reponse)
Below is an instruction that describes a task, paired with an input that provides further context. Write a response that appropriately completes the request.

### Instruction:
Fix the provided Java code's bugs. Do not rewrite. Do not optimize. Do not reorganize. Do not provide explanation or commentary.

### Input:
```java
class Solution {
    public String convertToBase7(int num) {
        if (num == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        int temp = num;
        if (temp < 0) {
            temp = -temp;
        }
        while (temp > 0) {
            int rem = temp % 7;
            sb.append(rem);
            temp = temp / 7;
        }
        if num < 0) {
            sb.append("-");
        }
        return sb.reverse().toString();
    }
}
```

### Response:
```java
class Solution {
    public String convertToBase7(int num) {
        if (num == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        int temp = num;
        if (temp < 0) {
            temp = -temp;
        }
        while (temp > 0) {
            int rem = temp % 7;
            sb.append(rem);
            temp = temp / 7;
        }
        if (num < 0) {
            sb.append("-");
        }
        return sb.reverse().toString();
    }
}
```

### Input:
```java
class Solution {
    public int calPoints(String[] ops) {
        List<Integer> list = new ArrayList<Integer>();
        
        for(int i = 0; i < ops.length; i++){
            switch(ops[score]){
                case "C":
                    list.remove(list.size() - 1);
                    break;
                case "D":
                    list.add(list.get(list.size() - 1) * 2);
                    break;
                case "+":
                    list.add(list.get(list.size() - 1) + list.get(list.size() - 2));
                    break;
                default:
                    list.add(Integer.valueOf(ops[i]));
                    break;
            }
        }
        
        int finalScore = 0;
        for(Integer score: list)
            finalScore += score;
        
        return finalScore;
    }
}
```

### Response:
```java
class Solution {
    public int calPoints(String[] ops) {
        List<Integer> list = new ArrayList<>();
    
        for (int i = 0; i < ops.length; i++) {
            switch (ops[i]) {
                case "C":
                    list.remove(list.size() - 1);
                    break;
                case "D":
                    list.add(list.get(list.size() - 1) * 2);
                    break;
                case "+":
                    list.add(list.get(list.size() - 1) + list.get(list.size() - 2));
                    break;
                default:
                    list.add(Integer.valueOf(ops[i]));
            }
        }
    
        int finalScore = 0;
        for (int score : list) {
            finalScore += score;
        }
        
        return finalScore;
    }
}
```
