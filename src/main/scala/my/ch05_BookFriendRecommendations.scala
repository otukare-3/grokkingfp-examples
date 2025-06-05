package my

object ch05_BookFriendRecommendations extends App {
  case class Book(title: String, authors: List[String])
  case class Movie(title: String)

  def recommendationFeed(books: List[Book]) = ???
  def bookAdaptations(author: String): List[Movie] = {
    if (author == "Tolkien") {
      List(
        Movie("An Unexpected Journey"),
        Movie("The Desolation of Smaug")
      )
    } else List.empty
  }

  def recommendedBooks(friend: String): List[Book] = {
    val scala = List(
      Book("FP in Scala", List("Chiusano", "Bjarnason")),
      Book("Get Programming with Scala", List("Sfregola")),
    )

    val fiction = List(
      Book("Harry Potter", List("Rowling")),
      Book("The Lord of the Rings", List("Tolkien")),
    )

    if (friend == "Alice") scala
    else if (friend == "Bob") fiction
    else List.empty
  }

  {
    val books = List(
      Book("FP in Scala", List("Chiusano", "Bjarnason")),
      Book("The Hobbit", List("Tolkien")),
      Book("Modern Java in Action", List("Urma", "Fusco", "Mycroft"))
    )

    val sut = books
      .map(_.title)
      .count(_.contains("Scala"))
    assert(1 == sut)
  }
  {
    val friends = List("Alice", "Bob", "Charlie")
    val authors = friends.flatMap(recommendedBooks).flatMap(_.authors)
    println(authors)
  }
  {
    val books = List(
      Book("FP in Scala", List("Chiusano", "Bjarnason")),
      Book("The Hobbit", List("Tolkien"))
    )

    println(
      books
        .flatMap(_.authors)
        .flatMap(bookAdaptations)
    )

    val expected = List(
      "You may like An Unexpected Journey, because you liked Tolkien's The Hobbit",
      "You may like The Desolation of Smaug, because you liked Tolkien's The Hobbit"
    )
    assert(expected == recommendationFeed(books))
  }
}
