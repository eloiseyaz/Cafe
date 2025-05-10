package Menu

abstract class MenuItem(val name: String, val itemType: MenuItem.ItemType, val price: Double, val premium: Boolean) {
  val serviceCharge: Double = {
    if (premium) 1.25
    else itemType match {
      case MenuItem.Drink => 1
      case MenuItem.ColdFood => 1.1
      case MenuItem.HotFood => 1.2
    }
  }

  override val toString: String = s"$name - $price"
}

object MenuItem {
  sealed trait ItemType
  case object ColdFood extends ItemType
  case object HotFood extends ItemType
  case object Drink extends ItemType
}