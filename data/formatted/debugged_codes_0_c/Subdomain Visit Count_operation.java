The bug in this code is in the calculation of the frequency of each subdomain. On line 20, the code is using the modulus operator instead of the addition operator. This means that if a subdomain already exists in the HashMap, instead of adding the current count to the existing count, it is only keeping the remainder after dividing the existing count by the current count.

To fix this bug, we need to change the modulus operator (%) to the addition operator (+) on line 20.

Here is the fixed code:

```java
class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        List<String> result = new LinkedList<>();
        HashMap<String, Integer> hmap = new HashMap<>();
        
        for (int i = 0; i < cpdomains.length; i++) {
            String[] stringData = cpdomains[i].split(" ");
            String[] str = stringData[1].split("\\.");
            String subDomains = "";
            
            for (int j = str.length - 1; j >= 0; j--) {
                subDomains = str[j] + subDomains;
                
                if (! hmap.containsKey(subDomains)) {
                    hmap.put(subDomains, Integer.parseInt(stringData[0]));
                } else {
                    hmap.put(subDomains, hmap.get(subDomains) + Integer.parseInt(stringData[0]));
                }
                subDomains = "." + subDomains;
            }
            
        }
        
        for (Map.Entry<String, Integer> entry : hmap.entrySet()) {
            result.add(entry.getValue() + " " + entry.getKey());
        }
        
        return result;
    }
}
```