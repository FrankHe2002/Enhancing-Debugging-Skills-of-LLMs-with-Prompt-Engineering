public class Codec {

    public String encode(String longUrl) {
        return longUrl + "shortened";
    }

    public String decode(String shortUrl) {
        return shortUrl.replace("shortened", "");
    }

}