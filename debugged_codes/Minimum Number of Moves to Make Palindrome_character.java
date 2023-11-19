class Solution {
  public int minMovesToMakePalindrome(String s) {
    int len = s.length();
    char[] strArr = s.toCharArray();        
    int steps = 0;
    int l = 0, r = len-1;

    while(l < r){            
      if(strArr[l] == strArr[r]){
        l++; r--;
      }else{
        int k = r;
        k = findKthIndexMatchingwithLthIndex(strArr, l, k);

        if(k == l){
          swap(strArr, l);
          steps++;   
        }else{                                                  
          while(k < r){                                           
            swap(strArr, k);
            steps++;
            k++;
          }
          l++; r--;
        }                
      }
    }
    return steps;
  }

  public int findKthIndexMatchingwithLthIndex(char[] strArr, int l, int k) {
    while(k > l) {
      if(strArr[k] == strArr[l]) {
        return k;
      }                    
      k--;
    }
    return k;
  }

  public void swap(char[] strArr, int l) {
    if(l+1 < strArr.length) {
      char tempCh = strArr[l];
      strArr[l] = strArr[l+1];
      strArr[l+1] = tempCh;
    }
  }
}