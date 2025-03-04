package Menu

case class ColdFood(override val name: String, override val price: Double) extends MenuItem(name, MenuItem.ColdFood, price, 1.1)

