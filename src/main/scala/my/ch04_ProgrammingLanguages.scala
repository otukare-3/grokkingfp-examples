package my

object ch04_ProgrammingLanguages extends App{
  private case class ProgrammingLanguages(name: String, year: Int)
  private val javaLang = ProgrammingLanguages("Java", 1995)
  private val scalaLang = ProgrammingLanguages("Scala", 2004)

  {
    assert(javaLang.name == "Java")
    assert(javaLang.year == 1995)
    assert(scalaLang.name.length == 5)
    assert((scalaLang.year + javaLang.year) / 2 == 1999)
  }

  {
    val languages = List(javaLang, scalaLang)
    assert(languages.map(lang => lang.name) == List("Java", "Scala"))
    assert(languages.filter(lang => lang.year > 2000) == List(ProgrammingLanguages("Scala", 2004)))
    assert(languages.map(_.name) == List("Java", "Scala"))
    assert(languages.filter(_.year > 2000) == List(ProgrammingLanguages("Scala", 2004)))
  }
}
