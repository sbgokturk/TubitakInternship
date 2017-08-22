class myDate extends Serializable {
  var day: Int = _
  var month: Int = _
  var year: Int = _

  var hours: Int = _
  var minutes: Int = _
  var seconds: Int = _

  override def toString: String = {
    return "Year: ".concat(year.toString).concat("\n")
      .concat("Month: ").concat(month.toString).concat("\n")
      .concat("Day: ").concat(day.toString).concat("\n")
      .concat("Hours: ").concat(hours.toString).concat("\n")
      .concat("Minutes: ").concat(minutes.toString).concat("\n")
      .concat("Seconds: ").concat(seconds.toString).concat("\n")
  }
}

object myDate {
  def parseDate(date: String): myDate = {

    val dateFormat = "yyyyMMddHHmmss"
    val dtf = java.time.format.DateTimeFormatter.ofPattern(dateFormat)
    val dateString = date
    val d = java.time.LocalDateTime.parse(dateString, dtf)

    var newDate = new myDate
    newDate.day = d.getDayOfMonth
    newDate.month = d.getMonthValue
    newDate.year = d.getYear
    newDate.hours = d.getHour
    newDate.minutes = d.getMinute
    newDate.seconds = d.getSecond

    return newDate
  }
}
