import TimeInterval.*

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int)

// Supported intervals that might be added to dates:
enum class TimeInterval { DAY, WEEK, YEAR }

operator fun MyDate.plus(timeInterval: TimeInterval): MyDate =
        this.addTimeIntervals(timeInterval, 1)

operator fun TimeInterval.times(n: Int): Pair<TimeInterval, Int> = Pair(this, n)

operator fun MyDate.plus(timeIntervals: Pair<TimeInterval, Int>): MyDate =
        this.addTimeIntervals(timeIntervals.first, timeIntervals.second)

fun task1(today: MyDate): MyDate {
    return today + YEAR + WEEK
}

fun task2(today: MyDate): MyDate {
    return today + YEAR * 2 + WEEK * 3 + DAY * 5
}
