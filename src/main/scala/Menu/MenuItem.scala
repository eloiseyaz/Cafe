package Menu

abstract class MenuItem(val name: String, val itemType: MenuItem.ItemType, val price: Double, val premium: Boolean) {
  val serviceCharge: Double
}

object MenuItem {
  sealed trait ItemType
  case object ColdFood extends ItemType
  case object HotFood extends ItemType
  case object Drink extends ItemType
}