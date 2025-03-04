import Menu.MenuItem

case class Order(order: List[(MenuItem, Int)]) {
  val size = order.map(item => item._2).sum
  val serviceCharge = order.map(item => item._1.serviceCharge).max
  val cost = order.map(item => item._1.price * item._2).sum
}
