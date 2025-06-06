package my

object ch05_Points2d3d extends App {
  case class Point(x: Int, y: Int)

  {
    // 5.12
    val expected = List(Point(1, -2), Point(1, 7))
    val actual   = List(1).flatMap(x =>
      List(-2, 7).map(y =>
        Point(x, y)
      )
    )

    assert(expected == actual, actual)
  }

}
