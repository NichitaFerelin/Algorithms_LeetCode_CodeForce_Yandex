package problems.medium

class LeetCode_1396 {

    private val mCompletedTravels = HashMap<String, MutableList<Travel>>()
    private val mCheckInContainer = HashMap<Int, Pair<String, Int>>()

    class Travel(val time: Int, val from: String = "", val to: String = "")

    fun checkIn(id: Int, stationName: String, time: Int) {
        mCheckInContainer[id] = Pair(stationName, time)
    }

    fun checkOut(id: Int, stationName: String, time: Int) {
        val dataAtCheckIn = mCheckInContainer[id]!!
        val fromStation = dataAtCheckIn.first
        val timeAtStart = dataAtCheckIn.second
        val newTravel = Travel(time - timeAtStart, fromStation, stationName)

        if (mCompletedTravels[fromStation] == null) {
            mCompletedTravels[fromStation] = mutableListOf(newTravel)
        } else mCompletedTravels[fromStation]!!.add(newTravel)
    }

    fun getAverageTime(startStation: String, endStation: String): Double {
        val travelsFromStation = mCompletedTravels[startStation]!!
        var totalTime = 0
        var totalTravels = 0
        travelsFromStation.forEach { travel ->
            if (travel.to == endStation) {
                totalTime += travel.time
                totalTravels++
            }
        }

        return totalTime.toDouble() / totalTravels
    }
}