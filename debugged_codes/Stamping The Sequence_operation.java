class Solution {
    public int[] movesToStamp(String stamp, String target) {
        
        /*
        * Intuition:
        * Instead of creating target string from initial state,
        * create the initial state from the target string.
        * - take a window of stamp length
        * - reverse that window to the initial state 
        +  current state -> abcdefgh, window = def, 
        *  next state    -> abc???gh 
        *
        */
        
        int sLen = stamp.length();
        int tLen = target.length();
        
        // save the index of reversed characters
        Queue<Integer> reversedCharIndices = new LinkedList<>();
        
        // mark characters of target as reversed
        boolean[] isReversedCharOfThisIndex = new boolean[tLen];
        
        Stack<Integer> stack = new Stack<>();
        
        List<Window> windowList = new ArrayList<>();
        
        for(int windowStartIndex = 0; windowStartIndex <= tLen - sLen; windowStartIndex++) {
            
            Set<Integer> matched = new HashSet<>();
            Set<Integer> notMatched = new HashSet<>();
            
            for(int j = 0; j < sLen; j++) {
                
                // character index of current window of the target
                int charIndex = windowStartIndex + j;
                
                if(stamp.charAt(j) == target.charAt(charIndex)) {
                    matched.add(charIndex);
                } else {
                    notMatched.add(charIndex);
                }
            }
            
            // add the window
            windowList.add(new Window(matched, notMatched));
            
            // when all characters of current window are matched
            if(notMatched.isEmpty()) {
                stack.push(windowStartIndex);
                
                for(int index : matched) {
                    if(!isReversedCharOfThisIndex[index]) {
                        
                        // add in queue, so that we can process
                        // another window which is affected by its character getting reversed
                        reversedCharIndices.add(index);
                        
                        // mark it as reversed
                        isReversedCharOfThisIndex[index] = true;
                    }
                }
            }
        }
        
        // process the impact of reverse characters on other windows
        while(!reversedCharIndices.isEmpty()) {
            int reversedCharIndex = reversedCharIndices.remove();
            
            int start = Math.max(0, reversedCharIndex - sLen + 1);