data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int) : Comparable<MyDate> {
    override fun compareTo(other: MyDate): Int {
        return year.compareTo(other.year).let { yearComp ->
            if (yearComp != 0) yearComp else month.compareTo(other.month).let { monthComp ->
                if (monthComp != 0) monthComp else dayOfMonth.compareTo(dayOfMonth)
            }
        }
    }
}

fun test(date1: MyDate, date2: MyDate) {
    // this code should compile:
    println(date1 < date2)
}
