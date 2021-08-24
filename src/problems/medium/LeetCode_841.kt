package problems.medium

class LeetCode_841 {

    fun canVisitAllRooms(rooms: List<List<Int>>): Boolean {
        val visitedRooms = HashMap<Int, Unit>()
        exploreRoom(rooms, visitedRooms)
        return visitedRooms.size == rooms.size - 1
    }

    private fun exploreRoom(rooms: List<List<Int>>, visitedRooms: HashMap<Int, Unit>, roomIndex: Int = 0) {
        visitedRooms[roomIndex] = Unit

        val keysInRoom = rooms[roomIndex]
        keysInRoom.forEach { keyRoomIndex ->
            if (visitedRooms[keyRoomIndex] == null) {
                exploreRoom(rooms, visitedRooms, keyRoomIndex)
            }
        }
    }
}