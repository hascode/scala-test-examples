package com.hascode
import org.scalatest.GivenWhenThen
import org.scalatest.FlatSpec
import org.scalatest.matchers.MustMatchers
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

class BDDSyntaxExample extends FlatSpec with MustMatchers with GivenWhenThen {
  "A HashMap" should "allow an item to be added" in {
    Given("an empty hashmap of type Int->String")
    val map = collection.mutable.Map[Int, String]()

    When("an item is added")
    map += (1 -> "Joe")

    Then("the map should have size 1")
    map must have size (1)

    And("the map must contain the item added")
    map must (contain key (1) and contain value ("Joe"))

    info("Adding items seems to be working")
  }
}
