import Menu.MenuItem

case class Order(order: List[(MenuItem, Int)]) {
  def simplifiedOrder(unsimplifiedList: List[(MenuItem, Int)] = order, currentList: List[(MenuItem, Int)] = List()): Either[String, List[(MenuItem, Int)]] = {
    if (unsimplifiedList.isEmpty) {
      if (currentList.isEmpty) Left("Can't have empty order")
      else Right(currentList)
    }
    else {
      val head = unsimplifiedList.head
        if (head._2 < 0) Left("Can't order negative of an item")
        else if (head._2 == 0) {
          simplifiedOrder(unsimplifiedList.tail, currentList)
        }
        else {
          if (currentList.exists(item => item._1 == head._1)) {
            val item = head._1
            val newList = currentList.map {case (item, quant) => (item, quant + head._2)}
            simplifiedOrder(unsimplifiedList.tail, newList)
        } else {
            val newList = currentList :+ head
            simplifiedOrder(unsimplifiedList.tail, newList)
          }
      }
    }
  }

  val size: Int = order.map(item => item._2).sum
  val serviceCharge: Double = order.map(item => item._1.serviceCharge).max
  val cost: Double = order.map(item => item._1.price * item._2).sum
}
