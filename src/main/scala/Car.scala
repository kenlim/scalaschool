class Car(val manufacturer: String, val model: String, val registrationId: Int) {
  def getDescription() = {
    s"$model built by $manufacturer"
  }
}

class Motorcycle() {
  
}

trait Electric {
  def charge() = "Charged!"
}

trait Flying {
  def fly() = "I'm flying jack!"  
}

class Delorean extends Electric with Flying

object ChargingStation {
  
  def supplypower(vehicle: Electric) = {
    vehicle.charge()
  }
  
  supplypower(new Delorean)
}