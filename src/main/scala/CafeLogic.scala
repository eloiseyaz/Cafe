import Menu.{ColdFood, Drink, HotFood, MenuItem}

import java.security.Provider.Service

object CafeLogic extends App{
  val nuggets = HotFood.apply("Chicken Nuggets", 4.5)
  val crisps = ColdFood.apply("Crisps", 1.5)
  val coke = Drink.apply("Coca Cola", 2)
  val cake = ColdFood.apply("Cake", 4, true)
  val newOrder = Order.apply(List((crisps, 2), (coke, 1)))
  val regMenu: List[MenuItem] = List(nuggets, crisps, coke)

}
