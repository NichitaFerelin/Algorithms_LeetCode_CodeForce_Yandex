package problems

/**
 * Design a parking system for a parking lot. The parking lot has three kinds of parking spaces:
 * big, medium, and small, with a fixed number of slots for each size.
 * Implement the ParkingSystem class:
 * ParkingSystem(int big, int medium, int small) Initializes object of the ParkingSystem class.
 * The number of slots for each parking space are given as part of the constructor.
 * bool addCar(int carType) Checks whether there is a parking space of carType for the car that wants to get
 * into the parking lot. carType can be of three kinds: big, medium, or small, which are represented by 1, 2,
 * and 3 respectively. A car can only park in a parking space of its carType. If there is no space available,
 * return false, else park the car in that size space and return true.
 * */

class LeetCode_1603 {

    class ParkingSystem(big: Int, medium: Int, small: Int) {

        private companion object {
            // Container keys
            const val sBigKey = "big"
            const val sMediumKey = "medium"
            const val sSmallKey = "small"

            // TypeKeys
            const val sTypeBig = 1
            const val sTypeMedium = 2
            const val sTypeSmall = 3
        }

        private val mParkContainer = hashMapOf(
            sBigKey to big,
            sMediumKey to medium,
            sSmallKey to small
        )

        private val mKeysContainer = hashMapOf(
            sTypeBig to sBigKey,
            sTypeMedium to sMediumKey,
            sTypeSmall to sSmallKey
        )

        fun addCar(carType: Int): Boolean {
            val key = mKeysContainer[carType]!!
            val value = mParkContainer[key]!!

            return if (value > 0) {
                mParkContainer[key] = value - 1
                true
            } else false
        }
    }
}