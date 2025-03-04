import Menu.{ColdFood, Drink, HotFood}
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class OrderSpec extends AnyWordSpec with Matchers {

  val nuggets = HotFood.apply("Chicken Nuggets", 4.5)
  val crisps = ColdFood.apply("Crisps", 1.5)
  val coke = Drink.apply("Coca Cola", 2)
  val pizza = HotFood.apply("Pizza", 8, true)
  val cake = ColdFood.apply("Crisps", 5, true)
  val smoothie = Drink.apply("Berry Smoothie", 3, true)

  "Order.size" should {

    "return the number of items in the order" when {

      "there is 1 of each item" in {
        val singlesOrder = Order.apply(List((crisps, 1), (nuggets, 1), (coke, 1)))
        singlesOrder.size shouldBe 3
      }

      "there are multiples of an item" in {
        val multiplesOrder = Order.apply(List((crisps, 2), (nuggets, 4), (coke, 7)))
        multiplesOrder.size shouldBe 13
      }

      "there is none of an item" in {
        val emptyOrder = Order.apply(List((crisps, 0), (nuggets, 0), (coke, 0)))
        emptyOrder.size shouldBe 0
        val someEmptyOrder = Order.apply(List((crisps, 1), (nuggets, 0), (coke, 3)))
        someEmptyOrder.size shouldBe 4
      }

    }

  }

}
