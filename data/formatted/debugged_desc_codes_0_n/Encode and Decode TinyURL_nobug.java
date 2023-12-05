```java
public class Codec {

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        return "http://tinyurl.com/" + longUrl.hashCode();
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return shortUrl.replace("http://tinyurl.com/", "");
    }
}
```