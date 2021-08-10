package problems.easy

class LeetCode_933 {

    private val mRequests = mutableListOf<Int>()

    fun ping(t: Int): Int {
        mRequests.add(t)

        if (mRequests.size == 1) {
            return 1
        }

        var pingsBefore = 1
        val range = t - 3000
        var requestsCursor = mRequests.lastIndex - 1
        while (requestsCursor >= 0) {
            if (mRequests[requestsCursor] >= range) {
                pingsBefore++
            } else break

            requestsCursor--
        }

        return pingsBefore
    }
}