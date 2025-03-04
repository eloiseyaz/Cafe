package Menu

case class Drink(override val name: String, override val price: Double, override val premium: Boolean = false) extends MenuItem(name, MenuItem.Drink, price, premium) {
  val serviceCharge: Double = {
    if (premium) 1.25
    else 1
  }
}