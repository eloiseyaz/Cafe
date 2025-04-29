import Menu.{ColdFood, Drink, HotFood, MenuItem}

import java.security.Provider.Service

object CafeLogic extends App{
  val nuggets = HotFood.apply("Chicken Nuggets", 4.5)
  val crisps = ColdFood.apply("Crisps", 1.5)
  val coke = Drink.apply("Coca Cola", 2)
  val cake = ColdFood.apply("Cake", 4, true)s
  val regMenu: List[MenuItem] = List(nuggets, crisps, coke)

  //  def placeOrder(order: Order): Either[String, Order] = {
  //  }

  def getBill(order: Order, serviceCharge: Option[Double] = None) = {
    //val sCharge = serviceCharge.getOrElse(order.serviceCharge)
    val simplified = order.simplifiedOrder()
    simplified match {
      case Left(x) => None
      case Right(x: List[(MenuItem, Int)]) => {
        val billList: List[String] = x.map(item => (s"${item._1.name} - ${item._2} - £${item._1.price * item._2}"))
        Some(billList)
      }
    }

  }

  def getTotalCost(order: Order, serviceCharge: Option[Double] = None): Double = {
    (order.cost * serviceCharge.getOrElse(order.serviceCharge) * 100).round.toDouble / 100
  }

}
