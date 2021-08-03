package problems.medium

class LeetCode_535 {

    private var mLastEncoded: String = ""

    // Encodes a URL to a shortened URL.
    fun encode(longUrl: String): String {
        mLastEncoded = longUrl
        return "http://tinyurl.com/${longUrl.hashCode()}"
    }

    // Decodes a shortened URL to its original URL.
    fun decode(shortUrl: String): String {
        return mLastEncoded
    }
}