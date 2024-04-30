package Practice;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.checkerframework.checker.calledmethods.qual.EnsuresCalledMethodsIf.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

public class ParallelTesting {
  WebDriver driver;
@BeforeTest
@Parameters("browser")
public void setup(String browser) {
	if (browser.equalsIgnoreCase("chrome")) {
		driver = new ChromeDriver();
	}
	else if(browser.equalsIgnoreCase("chrome")) {
		driver = new ChromeDriver();
	}
	else if (browser.equalsIgnoreCase("chrome")) {
		driver = new ChromeDriver();
	}
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
}
	@Test
  public void verifyTitle() {
	  driver.get("https://www.atlassian.com/software/jira");
     String title= driver.getTitle();
     System.out.println(title);
     Assert.assertEquals("ATLASSIAN", title);
     driver.quit();

}}
