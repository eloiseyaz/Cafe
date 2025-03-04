package Menu

case class HotFood(override val name: String, override val price: Double) extends MenuItem(name, MenuItem.HotFood, price, 1.2)

