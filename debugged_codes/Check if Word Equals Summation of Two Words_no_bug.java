class Solution {
    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        int sumfirst=0, sumsecond=0, sumtarget=0;
        for(char c : firstWord.toCharArray()){
            sumfirst = (sumfirst * 10) + (c-'a');
        }
        for(char c : secondWord.toCharArray()){
            sumsecond = (sumsecond * 10) + (c-'a');
        }
        for(char c : targetWord.toCharArray()){
            sumtarget = (sumtarget * 10) + (c-'a');
        }
       
        return (sumfirst + sumsecond) == sumtarget;
    }
}