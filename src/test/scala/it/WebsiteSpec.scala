package it
import org.junit.runner.RunWith
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.WebDriver
import org.scalatest.junit.JUnitRunner
import org.scalatest.matchers.ShouldMatchers
import org.scalatest.selenium.WebBrowser
import org.scalatest.FlatSpec
import org.scalatest.GivenWhenThen

@RunWith(classOf[JUnitRunner])
class WebsiteSpec extends FlatSpec with GivenWhenThen with ShouldMatchers with WebBrowser {
  implicit val webDriver: WebDriver = new FirefoxDriver

  "My Website" should "load the start page correctly" in {
    given("a browser")

    when("the browser loads the home page")
    go to ("http://www.hascode.com/")

    then("the title should equal 'hasCode.com'")
    title should be("hasCode.com")
  }

  ignore should "search for a given term" in {
    given("we're on the start page")

    when("the 'jee' is entered in the search box")
    click on id("s")
    textField("s").value = "jee"
    submit()

    then("the search results page should be displayed")
    title should be("hasCode.com [» Search Results »] jee")
  }
}