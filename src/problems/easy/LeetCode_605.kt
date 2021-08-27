package problems.easy

class LeetCode_605 {

    fun canPlaceFlowers(flowerbed: IntArray, n: Int): Boolean {
        if (n == 0) return true

        var flowersCanBeSet = 0
        var arrCursor = 0
        while (arrCursor < flowerbed.size) {
            if (flowerbed[arrCursor] == 1) {
                arrCursor++
                continue
            }

            if ((arrCursor - 1 < 0 || flowerbed[arrCursor - 1] == 0)
                && (arrCursor + 1 >= flowerbed.size || flowerbed[arrCursor + 1] == 0)
            ) {
                flowerbed[arrCursor] = 1
                flowersCanBeSet++
                arrCursor += 2

                if (flowersCanBeSet == n) return true
            } else arrCursor++
        }
        return false
    }
}