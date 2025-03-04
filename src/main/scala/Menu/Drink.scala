package Menu

case class Drink(override val name: String, override val price: Double) extends MenuItem(name, MenuItem.Drink, price, 1)