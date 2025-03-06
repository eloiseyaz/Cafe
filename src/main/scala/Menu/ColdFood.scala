package Menu

case class ColdFood(override val name: String, override val price: Double, override val premium: Boolean = false) extends MenuItem(name, MenuItem.ColdFood, price, premium)

