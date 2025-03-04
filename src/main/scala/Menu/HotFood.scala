package Menu

case class HotFood(override val name: String, override val price: Double, override val premium: Boolean = false) extends MenuItem(name, MenuItem.HotFood, price, premium) {
  val serviceCharge: Double = {
    if (premium) 1.25
    else 1.2
  }
}

