
class Tone extends Serializable {

  var tone: Float = _
  var positiveScore: Float = _
  var negativeScore: Float = _
  var polarity: Float = _
  var activityReferenceDensity: Float = _
  var sgReferenceDensity: Float = _
  var wordCount: Long = _

  override def toString: String = {
    return "Tone: ".concat(tone.toString).concat("\n")
      .concat("Positive Score: ").concat(positiveScore.toString).concat("\n")
      .concat("Negative Score: ").concat(negativeScore.toString).concat("\n")
      .concat("Polarity: ").concat(polarity.toString).concat("\n")
      .concat("Activity Reference Density: ").concat(activityReferenceDensity.toString).concat("\n")
      .concat("Self/Group Reference Density: ").concat(sgReferenceDensity.toString).concat("\n")
      .concat("Word Count: ").concat(wordCount.toString).concat("\n")
  }
}

object Tone {
  def parseTone(toneString: String): Tone = {
    var ret = new Tone

    if (toneString != null) {
      var toneFeatures = toneString.split(",")

      if (toneFeatures.length == 6) {
        ret.tone = toneFeatures(0).toFloat
        ret.positiveScore = toneFeatures(1).toFloat
        ret.negativeScore = toneFeatures(2).toFloat
        ret.polarity = toneFeatures(3).toFloat
        ret.activityReferenceDensity = toneFeatures(4).toFloat
        ret.sgReferenceDensity = toneFeatures(5).toFloat
        ret.wordCount = toneFeatures(6).toLong
      }
    }
    return ret
  }
}
