package com.hascode
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.matchers.MustMatchers
import org.scalatest.FlatSpec
import java.io.File

@RunWith(classOf[JUnitRunner])
class DifferentMatcherExample extends FlatSpec with MustMatchers {
  "several matchers" must "all match the given values" in {
    // equality
    4 must equal(4)
    "foo" must equal("foo")
    List("foo", "bar", "baz") must equal(List("foo", "bar", "baz"))
    (1, "foo") must equal((1, "foo"))

    // size, length
    "foo" must have length (3)
    List(1, 2, 3, 4) must have length (4)
    Array('A', 'B') must have length (2)

    List(1, 2, 3, 4) must have size (4)
    Array('A', 'B') must have size (2)

    // string checks
    "foobarbaz" must startWith("foo")
    "foobarbaz" must endWith("baz")
    "foobarbaz" must include("bar")

    "foobarbaz" must startWith regex ("f[o]+")
    "foobarbaz" must endWith regex ("[ba]{2}z")
    "foobarbaz" must include regex ("foo[\\w]{3}baz")
    "foobarbaz" must fullyMatch regex ("\\w{1}oobarbaz")

    // checking numbers
    7 must be < (8)
    7 must be > (0)
    6 must be <= (7)
    7 must be >= (6)
    13.43 must equal(13.43)
    13.43 must be(13.4 plusOrMinus 0.4)

    // boolean properties check
    List[Int]() must be('empty) // calls list.isEmpty
    new File("/tmp") must be('directory) // calls file.isDirectory

    // object identity
    var foo = List(1, 2)
    var bar = foo
    bar must be theSameInstanceAs (foo)

    // collections
    List(1, 2, 3, 4) must contain(2)
    Array("foo", "bar", "baz") must contain("bar")
    var users = Map(1 -> "Joe", 2 -> "Lisa", 3 -> "Dr. Evil")
    users must contain key (2)
    users must contain value ("Dr. Evil")

    // negation
    7 must not be >(8)
    List(1, 2, 3, 4) must not be ('empty)

    // combined expressions with and / or
    users must (have size (3) and contain key (3))
    users must (contain value ("Mr. X") or contain value ("Joe"))
  }
}