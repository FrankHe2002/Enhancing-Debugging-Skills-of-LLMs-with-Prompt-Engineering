class Solution {
    public String largestMerge(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int i=0;
        int j=0;
        char[] w1 = word1.toCharArray();
        char[] w2 = word2.toCharArray();
        
        int n1=w1.length;
        int n2=w2.length;
        
        while(i<n1 && j<n2){
            
            if(w1[i]==w2[j]){
                if(check(w1,i,w2,j)){
                    sb.append(w1[i++]);
                }else{
                    sb.append(w2[j++]);
                }
            }
            
            else if(w1[i]>w2[j]){
                sb.append(w1[i++]);
            }else{
                sb.append(w2[j++]);
            }
        }
        
        if(i<n1){
            sb.append(word1.substring(i));
        }
        
        if(j<n2){
            sb.append(word2.substring(j));
        }
		
        return sb.toString();
    }
    
    private boolean check(char[] w1, int i, char[] w2, int j){
        
        while(i<w1.length && j<w2.length){
            if(w1[i]==w2[j]){
                i++;
                j++;
            }
            else if(w1[i]>w2[j]){
                return true;
            }else{
                return false;
            }
        }
        
        if(i<w1.length){
            return true;
        }
        return false;
    }
}