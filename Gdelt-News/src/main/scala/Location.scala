class Location() extends Serializable {

  var locationType: Int = _
  var locationFullName: String = _
  var locationCountryCode: String = _
  var locationADM1Code: String = _
  var locationADM2Code: String = _
  var locationLatitude: Float = _
  var locationLongitude: Float = _
  var locationFeatureID: String = _

  override def toString: String = {
    return "Type: ".concat(locationType.toString).concat("\n")
      .concat("Full Name: ").concat(locationFullName).concat("\n")
      .concat("CountryCode: ").concat(locationCountryCode).concat("\n")
      .concat("ADM1: ").concat(locationADM1Code).concat("\n")
      .concat("Latitude: ").concat(locationLatitude.toString).concat("\n")
      .concat("Longitude: ").concat(locationLongitude.toString).concat("\n")
      .concat("FeatureID: ").concat(locationFeatureID).concat("\n")
  }
}

object Location {
  def parseLocation1(locationString: String): Array[Location] = {
    val locations = locationString.split(";")

    var ret = new Array[Location](locations.length)

    for (i <- 0 to (locations.length - 1)) {
      val features = locations(i).split("#")
      var newLocation = new Location

      if (features.length == 7) {
        newLocation.locationType = features(0).toInt
        newLocation.locationFullName = features(1)
        newLocation.locationCountryCode = features(2)
        newLocation.locationADM1Code = features(3)
        newLocation.locationLatitude = features(4).toFloat
        newLocation.locationLongitude = features(5).toFloat
        newLocation.locationFeatureID = features(6)

        ret(i) = newLocation
      }
    }

    return ret
  }

  def parseLocation2(locationString: String): Array[Location] = {
    val locations = locationString.split(";")

    var ret = new Array[Location](locations.length)

    for (i <- 0 to (locations.length - 1)) {
      val features = locations(i).split("#")
      var newLocation = new Location

      if (features.length == 8) {
        newLocation.locationType = features(0).toInt
        newLocation.locationFullName = features(1)
        newLocation.locationCountryCode = features(2)
        newLocation.locationADM1Code = features(3)
        newLocation.locationADM2Code = features(4)
        newLocation.locationLatitude = features(5).toFloat
        newLocation.locationLongitude = features(6).toFloat
        newLocation.locationFeatureID = features(7)

        ret(i) = newLocation
      }
    }

    return ret
  }
}
