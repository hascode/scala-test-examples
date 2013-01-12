package it
import org.junit.runner.RunWith
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.WebDriver
import org.scalatest.junit.JUnitRunner
import org.scalatest.matchers.ShouldMatchers
import org.scalatest.selenium.WebBrowser
import org.scalatest.FlatSpec
import org.scalatest.GivenWhenThen
import org.openqa.selenium.htmlunit.HtmlUnitDriver

class WebsiteSpec extends FlatSpec with GivenWhenThen with ShouldMatchers with WebBrowser {
  implicit val webDriver: WebDriver = new HtmlUnitDriver

  "My Website" should "search for a given term" in {
    go to ("http://www.hascode.com/")
    title should be("hasCode.com")
    click on id("s")
    textField("s").value = "lucene"
    submit()
    title should include regex ("hasCode.com.+Search Results.+lucene")
    pageSource should include("Lucene Snippets: Index Stats")
    pageSource should include("Lucene Snippets: Faceting Search")
    pageSource should include("Hibernate Search Faceting: Discrete and Range Faceting by Example")
  }
}