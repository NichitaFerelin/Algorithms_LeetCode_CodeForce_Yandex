package problems.easy

class LeetCode_1869 {

    fun checkZeroOnes(s: String): Boolean {
        var zeroMaxSequence = 0
        var unitMaxSequence = 0

        var zeroStepSequence = 0
        var unitStepSequence = 0
        s.forEach { symbol ->
            if (symbol == '0') {
                zeroStepSequence++

                if (unitStepSequence > unitMaxSequence) {
                    unitMaxSequence = unitStepSequence
                }
                unitStepSequence = 0
            } else {
                unitStepSequence++

                if (zeroStepSequence > zeroMaxSequence) {
                    zeroMaxSequence = zeroStepSequence
                }
                zeroStepSequence = 0
            }
        }

        if (unitStepSequence > unitMaxSequence) {
            unitMaxSequence = unitStepSequence
        }

        if (zeroStepSequence > zeroMaxSequence) {
            zeroMaxSequence = zeroStepSequence
        }

        return unitMaxSequence > zeroMaxSequence
    }
}