class Solution {
    public int minSteps(int n) {
        int rem = n-1;
        int copied = 0;
        int ans = 0;
        int onScreen = 1;
        
        while(rem>0){
            if(rem + onScreen == 0){
                ans++; // copy operation
                copied = onScreen;   
            }
            rem-=copied;
            ans++; // paste operation
            onScreen = n-rem; // no. of characters on screen currently that can be copied in next copy operation
        }
        
        return ans;
    }
}