class Site(val address: String, val foundationYear: Int)

fun makeReddit(): Site {
    val reddit = Site("reddit.com",2005)
    return reddit
}