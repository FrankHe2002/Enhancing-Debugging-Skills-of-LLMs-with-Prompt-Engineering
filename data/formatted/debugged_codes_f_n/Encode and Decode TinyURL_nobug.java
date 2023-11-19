Fixed Code:
```java
public class Codec {

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        return longUrl.substring(0, longUrl.length() - 2);
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return shortUrl + "xx";
    }
}
```