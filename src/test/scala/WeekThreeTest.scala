import org.scalatest.{Matchers, FlatSpec}

class WeekThreeTest extends FlatSpec with Matchers {

  "simple logic" should "return boolean answers" in {
    // Logic operators look the same in Scala as elsewhere. Fill in the blanks:

    3 > 1 should be(???)
    3 < 1 should be(???)
    1 >= 1 should be (???)
    1 <= 1 should be (???)

    !true should be(???)
    1 == 1 should be (???)
    1 != 0 should be (???)

    true && false should be(???)
    true || false should be(???)
  }

  "Scala" should "not allow you to compare non-alike types" in {
    // yeah, this only works in Javascript, not here.
//    true && 1 should be (true)
  }

  "If-blocks" should "be able to use the boolean results to make decisions" in  {
    def isBiggerThan3(input: Int) = {
      if (input > 3) {
        "yes it is"
      } else if (input == 3) {
        "actually, it's the same size"
      } else {
        "no it isn't"
      }
    }

    isBiggerThan3(2) should be("no it isn't")

  }

  "simple if-blocks" should "allow you to write in a single line" in {
    val result = if (3 > 1) "yep" else "nope"
    result should be ("yep")
  }

  "case matchers" should "make it easier to write long if-elseif-else blocks" in {
    def collectiveNounForProgrammers(q: Int) = {
      q match {
        case 1 => "a"
        case 2 => "a pair of"
        case _ => "a conflict of" // the underscore is a catch-all
      }
    }

    collectiveNounForProgrammers(1) should be("a")
    collectiveNounForProgrammers(2) should be("a pair of")
    collectiveNounForProgrammers(5) should be("a conflict of")
  }

}
