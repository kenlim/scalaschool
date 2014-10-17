import org.scalatest.{FlatSpec, Matchers}

class WeekFourTest  extends FlatSpec with Matchers {
  case class Article(title: String, author: String)

  "case classes" should "work like regular classes " in {

    val article: Article = new Article("The iPhone6 is the best thing ever", "Stephen Fry")

    article.author should equal("Stephen Fry")
  }

  "case classes" should "have a companion Object" in {
    val article: Article = Article("No it's not", "Shrek")

    article.author should equal("Shrek")
  }

  "case matcher" should "match on requirements" in{
    def isWrittenByFry(article: Article): Int = {
      article match {
        case Article(_, name ) if name.endsWith("Fry") => 1
        case Article(_, "Stephen King") => 2
        case _ => 0
      }
    }

    val fry: Article = Article("Apple is scrumptious", "Stephen Fry")
    val notFry: Article = Article("Pears are evil", "Stephen King")

    isWrittenByFry(fry) should be(1)
    isWrittenByFry(notFry) should be (2)

  }

  "Lists" should "work as expected" in {
    val strings: List[Int] = List(4,6,3,8,7)

    strings.head should be(4)
    strings.last should be(7)
    strings.tail should be(List(6,3,8,7))
    strings.slice(0, 2) should be (List(4,6))
    strings.slice(0, 4) should be(List(4,6,3,8))
    strings.slice(2,4) should be (List(3,8))
    strings.take(2) should be(List(4,6))
    strings.takeRight(2) should be(List(8,7))
    strings.reverse should be(List(7,8,3,6,4))

    def isOdd(x: Int):Boolean = {
      x % 2 != 0
    }

    val numbers: List[Int] = List( 4,3,6,7,2,3,434,3,5,6,4)

    val filtered: List[Int] = numbers.filter( isOdd(_))
    filtered should be (List(3,7,3,3,5))

    List(2,4,6,8).find(isOdd(_)) should be(None)
    List(246,7).find(isOdd(_)) should be(Some(7))

    def honkIfYouSeeAnOddNumber(list: List[Int]): String = {
      val result: Option[Int] = list.find(isOdd(_))

      result match {
        case Some(_) => "Honk"
        case None => "Shhh..."
      }
    }

  }

  "This example" should "work" in  {
    case class Directory(containing: List[Directory], name: String)

    val lowest: Directory = Directory(Nil, "hello")
    val upper: Directory = Directory(List(lowest), "world")
    val middle = Directory (Nil, "alfdkjlfsajfld")
    val upperest = Directory(List(middle, upper), "nyah")

    def hasWorld(x: Directory): Boolean = {
      x match {
        case Directory(_, "world") => true
        case Directory(directories, _) => directories.exists(hasWorld(_) == true)
        case Directory(_, _) => false
      }
    }

    hasWorld(upper) should be(true)

    hasWorld(lowest) should be(false)

    hasWorld(upperest) should be(true)


  }
}
