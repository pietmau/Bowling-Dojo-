const val MAX_ROLLS_NUM = 2

class Frame {
    var status: Status = Status.INCOMPLETE
    val score: Int = 0
    var rolls = 0
    private var numberOfPinsckockedDown = 0

    fun setPinsKnockedDown(pinsKnocked: Int) {
        checkNumberOfPins(pinsKnocked)
        calculateNumberOfPins(pinsKnocked)
        checkNumberOfRolls()
        setStatus(pinsKnocked)
    }

    private fun setStatus(pinsKnocked: Int) {
        if (pinsKnocked == STRIKE_COUNT) {
            status = Status.STRIKE
        }
        if (rolls == MAX_ROLLS_NUM) {
            status = Status.DONE
        }
        if (numberOfPinsckockedDown == STRIKE_COUNT) {
            status = Status.SPARE
        }
    }

    private fun checkNumberOfRolls() {
        if (rolls >= MAX_ROLLS_NUM) {
            throw IllegalGameException()
        }
        rolls++
    }

    private fun calculateNumberOfPins(pinsKnocked: Int) {
        numberOfPinsckockedDown += pinsKnocked
        if (numberOfPinsckockedDown > 10) {
            throw IllegalGameException()
        }
    }

    private fun checkNumberOfPins(pinsKnocked: Int) {
        if (pinsKnocked > 10) {
            throw IllegalGameException()
        }
        if (pinsKnocked < 0) {
            throw IllegalGameException()
        }
    }
}

enum class Status {
    STRIKE, INCOMPLETE, DONE, SPARE
}