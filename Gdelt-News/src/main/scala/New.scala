class New(date: myDate, sourceName: String, documentIdent: String, counts1: Array[Count], counts2: Array[Count], themes1: Array[String]
          , themes2: Array[String], locations1: Array[Location], locations2: Array[Location], persons1: Array[String], persons2: Array[String], organizations1: Array[String]
          , organizations2: Array[String], tone: Tone, gcam: Array[String], image: String, relatedImages: Array[String]
          , socialImages: Array[String], socialVideos: Array[String]) extends Serializable {

  var this.date = date
  var this.sourceName = sourceName
  var this.documentIdent = documentIdent
  var this.counts1 = counts1
  var this.counts2 = counts2
  var this.themes1 = themes1
  var this.themes2 = themes2
  var this.locations1 = locations1
  var this.locations2 = locations2
  var this.persons1 = persons1
  var this.persons2 = persons2
  var this.organizations1 = organizations1
  var this.organizations2 = organizations2
  var this.tone = tone
  var this.gcam = gcam
  var this.image = image
  var this.relatedImages = relatedImages
  var this.socialImages = socialImages
  var this.socialVideos = socialVideos

  override def toString: String = {
    return "Date: ".concat(date.toString).concat("\n")
      .concat("Source Name: ").concat(sourceName).concat("\n")
      .concat("Document Identifier: ").concat(documentIdent).concat("\n")
      .concat("Counts-V1: ").concat(counts1.mkString).concat("\n")
      .concat("Counts-V2: ").concat(counts2.mkString).concat("\n")
      .concat("Themes-V1: ").concat(themes1.mkString).concat("\n")
      .concat("Themes-V2: ").concat(themes2.mkString).concat("\n")
      .concat("Locations-V1: ").concat(locations1.mkString).concat("\n")
      .concat("Locations-V2: ").concat(locations2.mkString).concat("\n")
      .concat("Persons-V1: ").concat(persons1.mkString).concat("\n")
      .concat("Persons-V2: ").concat(persons2.mkString).concat("\n")
      .concat("Organizations-V1: ").concat(organizations1.mkString).concat("\n")
      .concat("Organizations-V2: ").concat(organizations2.mkString).concat("\n")
      .concat("Tone: ").concat(tone.toString).concat("\n")
      .concat("GCAM: ").concat(gcam.mkString).concat("\n")
      .concat("Image: ").concat(image).concat("\n")
      .concat("Related Images: ").concat(relatedImages.mkString).concat("\n")
      .concat("Social Images: ").concat(socialImages.mkString).concat("\n")
      .concat("Social Videos: ").concat(socialVideos.mkString).concat("\n")

  }

}
