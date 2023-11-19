There doesn't seem to be any syntax errors or obvious logical errors in the provided code. However, the bug in this code lies in how the email address is being processed. The code is not correctly ignoring characters after the '+' symbol.

To fix this bug, we need to update the logic inside the switch case for the '+' symbol. Instead of setting the `ignore` variable to true, we need to find the index of the '@' symbol and substring the email address up to that index. This will effectively remove any characters after the '+' symbol.

Here's the corrected code:

```java
class Solution {
    public int numUniqueEmails(String[] emails) {

        Set<String> finalEmails = new HashSet<>();
        for (String email : emails) {
            StringBuilder name = new StringBuilder();
            boolean ignore = false;
            for (int i = 0; i < email.length(); i++) {
                char c = email.charAt(i);
                switch (c) {
                    case '.':
                        break;
                    case '+':
                        int index = email.indexOf('@');
                        name.append(email.substring(index));
                        i = email.length();
                        break;
                    case '@':
                        name.append(email.substring(i));
                        i = email.length();
                        break;
                    default:
                        if (!ignore) name.append(c);
                }
            }
            finalEmails.add(name.toString());
        }
        finalEmails.forEach(System.out::println);
        return finalEmails.size();
    }
}
```

With this fix, the code should now correctly ignore characters after the '+' symbol and return the correct number of unique email addresses.