import CafeLogic.getBill
import Menu.{ColdFood, Drink, HotFood}
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class CafeLogicSpec extends AnyWordSpec with Matchers {

  val nuggets = HotFood.apply("Chicken Nuggets", 4.5)
  val crisps = ColdFood.apply("Crisps", 1.5)
  val coke = Drink.apply("Coca Cola", 2)
  val fanta = Drink.apply("Fanta", 1.8)
  val pizza = HotFood.apply("Pizza", 8, true)
  val cake = ColdFood.apply("Crisps", 5, true)
  val smoothie = Drink.apply("Berry Smoothie", 3, true)

  "CafeLogic.getBill" should {

    "return a list of items with prices including service charge" when {

      "the default service charge is 1" in {
        val order: Order = Order.apply(List((coke, 1), (fanta, 1)))
        val expected: List[(String, Int, Double)] = List(("Coca Cola", 1, 2), ("Fanta", 1, 1.8))
        getBill(order) shouldBe expected
      }


      "the default service charge is 1.1" in {
        val order: Order = Order.apply(List((crisps, 1)))
        val expected: List[(String, Int, Double)] = List(("Crisps", 1, 1.65))
        getBill(order) shouldBe expected
      }

      "the default service charge is 1.2" in {
        val order: Order = Order.apply(List((nuggets, 2)))
        val expected: List[(String, Int, Double)] = List(("Chicken Nuggets", 2, 10.8))
        getBill(order) shouldBe expected
      }

      "the default service charge is 1.25" in {
        val order: Order = Order.apply(List((smoothie, 1), (coke, 1)))
        val expected: List[(String, Int, Double)] = List(("Berry Smoothie", 1, 3.75), ("Coca Cola", 1, 2.5))
        getBill(order) shouldBe expected
      }

      "the service charge is specified" in {
        val order: Order = Order.apply(List((smoothie, 1), (coke, 1), (crisps, 1)))
        val expected: List[(String, Int, Double)] = List(("Berry Smoothie", 1, 3.45), ("Coca Cola", 1, 2.3), ("Crisps", 1, 1.73))
        getBill(order, Some(1.15))

      }

    }

  }

}
