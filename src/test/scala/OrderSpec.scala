import Menu.{ColdFood, Drink, HotFood}
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class OrderSpec extends AnyWordSpec with Matchers {

  val nuggets = HotFood.apply("Chicken Nuggets", 4.5)
  val crisps = ColdFood.apply("Crisps", 1.5)
  val coke = Drink.apply("Coca Cola", 2)
  val fanta = Drink.apply("Fanta", 2)
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

  "Order.serviceCharge" should {

    "return 1" when {

      "the order is only non-premium drinks" in {
        val drinksOrder = Order.apply(List((coke, 1), (fanta, 2)))
        drinksOrder.serviceCharge shouldBe 1
      }

    }

    "return 1.1" when {

      "the order is only non-premium cold food" in {
        val drinksOrder = Order.apply(List((crisps, 2)))
        drinksOrder.serviceCharge shouldBe 1.1
      }

      "the order is only non-premium cold food and drinks" in {
        val drinksOrder = Order.apply(List((crisps, 1), (fanta, 2)))
        drinksOrder.serviceCharge shouldBe 1.1
      }

    }

    "return 1.2" when {

      "the order is only non-premium hot food" in {
        val drinksOrder = Order.apply(List((nuggets, 1)))
        drinksOrder.serviceCharge shouldBe 1.2
      }

      "the order is all non-premium and contains hot food" in {
        val drinksOrder = Order.apply(List((crisps, 1), (fanta, 2), (nuggets, 1)))
        drinksOrder.serviceCharge shouldBe 1.2
      }

    }

    "return 1.25" when {

      "the order is all premium" in {
        val drinksOrder = Order.apply(List((cake, 1), (pizza, 3), (smoothie, 4)))
        drinksOrder.serviceCharge shouldBe 1.25
      }

      "the order contains premium items" in {
        val drinksOrder = Order.apply(List((crisps, 1), (smoothie, 2), (nuggets, 1)))
        drinksOrder.serviceCharge shouldBe 1.25
      }

    }

  }

}
