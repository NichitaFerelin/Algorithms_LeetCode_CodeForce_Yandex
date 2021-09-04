package problems.leetcode.medium

class LeetCode_1381(maxSize: Int) {

    private var mFreeSize = maxSize
    private var mMyStack = mutableListOf<Int>()

    fun push(x: Int) {
        if (mFreeSize != 0) {
            mMyStack.add(x)
            mFreeSize--
        }
    }

    fun pop(): Int {
        return if (mMyStack.isEmpty()) {
            -1
        } else {
            val last = mMyStack.last()
            mMyStack.removeAt(mMyStack.lastIndex)
            mFreeSize++
            last
        }
    }

    fun increment(k: Int, `val`: Int) {
        var stackCursor = 0
        while (stackCursor < k && stackCursor < mMyStack.size) {
            mMyStack[stackCursor] += `val`
            stackCursor++
        }
    }
}