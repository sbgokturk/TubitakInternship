class Count() extends Serializable {

  var countType: String = _
  var count: Long = _
  var objectType: String = _
  var location: Location = _

  override def toString: String = {
    return "Type: ".concat(countType).concat("\n")
      .concat("Count: ").concat(count.toString).concat("\n")
      .concat("Object type: ").concat(objectType).concat("\n")
      .concat("Location: ").concat(location.toString).concat("\n")
  }

}

object Count {
  def parseCounts(counts: String): Array[Count] = {

    val counts_arr = counts.split(";")
    var ret = new Array[(Count)](counts_arr.length)

    for (i <- 0 to (counts_arr.length - 1)) {
      val datum = counts_arr(i).split("#")

      if (datum.length == 10) {
        var newCount = new Count
        newCount.countType = datum(0)
        if (datum(1) != "") {
          newCount.count = datum(1).toLong
        } else {
          newCount.count = 0
        }
        newCount.objectType = datum(2)
        var newLocation = new Location
        newLocation.locationType = datum(3).toInt
        newLocation.locationFullName = datum(4)
        newLocation.locationCountryCode = datum(5)
        newLocation.locationADM1Code = datum(6)
        newLocation.locationLatitude = datum(7).toFloat
        newLocation.locationLongitude = datum(8).toFloat
        newLocation.locationFeatureID = datum(9)
        newCount.location = newLocation
        ret(i) = newCount
      }
    }

    return ret
  }
}
