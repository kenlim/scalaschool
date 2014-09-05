import org.scalatest._

class WeekTwoTest extends FlatSpec with Matchers {

  object CarRegistrar {
    var number = 1

    def getNextRegistrationId(): Int = {
      // this is stuck returning the number 1
      // how would you make it increase?
      // HINT: you'll need a "var" not a "val" (can you remember why?)
      number = number + 1

      return number
    }

    def apply(manufacturer: String, model: String) = {
      new Car( manufacturer, model, getNextRegistrationId())
    }


    // You'll probably want to put some extra methods in here.
  }
  
  "Car Description" should "show the manufacturer and the model of the car" in {
    val car: Car = new Car("Ford", "Mustang", 1234)
    car.manufacturer should be ("Ford")
    car.getDescription() should be ("Mustang built by Ford")
  }

  "CarRegistrar" should "return an ever increasing registration id" in {

    val first = CarRegistrar.getNextRegistrationId
    val second = CarRegistrar.getNextRegistrationId
    val third = CarRegistrar.getNextRegistrationId

    CarRegistrar.getNextRegistrationId()
    third > second should be(true)
    second > first should be(true)
  }

  "Building cars with the car registrar" should "assign a default registration id" in {
    // the following line is broken because a method is missing.

    val registeredCar: Car = CarRegistrar("Toyota", "Supra")

    registeredCar.registrationId should be > 0
    // isn't this so incredibly readable? SCALA!
  }
}
