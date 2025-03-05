import Menu.{ColdFood, Drink, HotFood, MenuItem}

import java.security.Provider.Service

object CafeLogic extends App{
  val nuggets = HotFood.apply("Chicken Nuggets", 4.5)
  val crisps = ColdFood.apply("Crisps", 1.5)
  val coke = Drink.apply("Coca Cola", 2)
  val cake = ColdFood.apply("Cake", 4, true)
  val newOrder = Order.apply(List((crisps, 2), (coke, 1)))
  val regMenu: List[MenuItem] = List(nuggets, crisps, coke)

  //  def placeOrder(order: Order): Either[String, Order] = {
  //  }

  def getBill(order: Order, serviceCharge: Option[Double] = None): List[(String, Int, Double)] = {
    val sCharge = serviceCharge.getOrElse(order.serviceCharge)
    order.order.map(item => (item._1.name, item._2, (item._1.price * item._2 * sCharge * 100).round.toDouble / 100))
  }

  def getTotalCost(order: Order, serviceCharge: Option[Double] = None): Double = {
    (order.cost * serviceCharge.getOrElse(order.serviceCharge) * 100).round.toDouble / 100
  }

}
