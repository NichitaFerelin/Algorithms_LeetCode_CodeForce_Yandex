package problems.easy

class LeetCode_303(nums: IntArray) {

    private val mNums = nums
    private var mSum = mNums.sum()
    private var mLeftCursor = 0
    private var mRightCursor = mNums.lastIndex

    fun sumRange(left: Int, right: Int): Int {
        when {
            mLeftCursor == left -> Unit
            mLeftCursor < left -> {
                while (mLeftCursor != left) {
                    mSum -= mNums[mLeftCursor]
                    mLeftCursor++
                }
            }
            else -> {
                while (mLeftCursor != left) {
                    mLeftCursor--
                    mSum += mNums[mLeftCursor]
                }
            }
        }

        when {
            mRightCursor == right -> Unit
            mRightCursor > right -> {
                while (mRightCursor != right) {
                    mSum -= mNums[mRightCursor]
                    mRightCursor--
                }
            }
            else -> {
                while (mRightCursor != right) {
                    mRightCursor++
                    mSum += mNums[mRightCursor]
                }
            }
        }

        return mSum
    }
}