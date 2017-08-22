class New(date: myDate, sourceName: String, documentIdent: String, counts1: Array[Count], counts2: Array[Count], themes1: Array[String]
          , themes2: Array[String], locations1: Array[Location], locations2: Array[Location], persons1: Array[String], organizations1: Array[String]
          , organizations2: Array[String], tones: Array[Tone], gcam: Array[String], image: String, relatedImages: Array[String]
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
  var this.organizations1 = organizations1
  var this.organizations2 = organizations2
  var this.tones = tones
  var this.gcam = gcam
  var this.image = image
  var this.relatedImages = relatedImages
  var this.socialImages = socialImages
  var this.socialVideos = socialVideos

}
