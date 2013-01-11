package com.hascode
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.FlatSpec
import org.scalatest.matchers.ShouldMatchers

/**
 * http://nimblepros.com/media/36628/string%20calculator%20kata.pdf
 */
@RunWith(classOf[JUnitRunner])
class StringCalculatorSpec extends FlatSpec with ShouldMatchers {

  "calc" should "return 0 given an emtpy string" in {
    calc("", "") should equal(0)
  }

  it should "return 1 given a string '1' solely" in {
    calc("1", "") should equal(1)
    calc("", "1") should equal(1)
  }

  it should "return a 2 given two strings '1'" in {
    calc("1", "1") should equal(2)
  }

  it should "return a 3 given a '1' and a string '2'" in {
    calc("1", "2") should equal(3)
  }

  it should "return a 8 given three strings '1', '3', '4'" in {
    calc("1", "3", "4") should equal(8)
  }

  it should "return 0 if all strings are empty" in {
    calc("", "") should equal(0)
    calc("", "", "") should equal(0)
    calc("", "", "", "") should equal(0)
    calc("", "", "", "", "") should equal(0)
  }

  it should "return a 64 given five strings '1','3','7','20','33'" in {
    calc("1", "3", "7", "20", "33") should equal(64)
  }

  def calc(in: String*): Int = {
    var ret = 0
    in.filter(_ != "").foreach(ret += _.toInt)
    ret
  }
}

