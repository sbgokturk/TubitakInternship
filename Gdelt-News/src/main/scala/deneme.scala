class deneme (a:String){
  var this.a = a;

  override def toString: String = {
    return a;
  }
}

object Main3{
  def main(args: Array[String]): Unit = {
    val b = new deneme("Atakan")

    println(b)
  }
}