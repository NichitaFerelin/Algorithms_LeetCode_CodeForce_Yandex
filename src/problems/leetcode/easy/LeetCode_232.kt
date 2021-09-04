package problems.leetcode.easy

class LeetCode_232 {

    /** Initialize your data structure here. */
    private val mQueue = mutableListOf<Int>()

    /** Push element x to the back of queue. */
    fun push(x: Int) {
        mQueue.add(0, x)
    }

    /** Removes the element from in front of queue and returns that element. */
    fun pop(): Int {
        val item = mQueue[mQueue.lastIndex]
        mQueue.removeAt(mQueue.lastIndex)
        return item
    }

    /** Get the front element. */
    fun peek(): Int {
        return mQueue[mQueue.lastIndex]
    }

    /** Returns whether the queue is empty. */
    fun empty(): Boolean {
        return mQueue.isEmpty()
    }
}