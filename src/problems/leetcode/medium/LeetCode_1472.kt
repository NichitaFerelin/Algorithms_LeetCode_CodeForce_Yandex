package problems.leetcode.medium

class LeetCode_1472(homepage: String) {

    private val mHistory = mutableListOf<String>(homepage)
    private var mCurrentPosition = 0

    fun visit(url: String) {
        var toRemove = mHistory.size - mCurrentPosition - 1
        while (toRemove-- > 0) mHistory.removeAt(mHistory.lastIndex)
        mHistory.add(url)
        mCurrentPosition = mHistory.lastIndex
    }

    fun back(steps: Int): String {
        var stepsCounter = steps
        var historyCursor = mCurrentPosition
        while (historyCursor > 0 && stepsCounter > 0) {
            historyCursor--
            stepsCounter--
        }
        mCurrentPosition = historyCursor
        return mHistory[mCurrentPosition]
    }

    fun forward(steps: Int): String {
        var stepsCounter = steps
        var historyCursor = mCurrentPosition
        while (historyCursor < mHistory.size - 1 && stepsCounter > 0) {
            historyCursor++
            stepsCounter--
        }
        mCurrentPosition = historyCursor
        return mHistory[mCurrentPosition]
    }
}