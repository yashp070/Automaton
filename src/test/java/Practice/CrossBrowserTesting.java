package Practice;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowserTesting {
	WebDriver driver;
	@BeforeTest
	@Parameters("browser")
	public void setup(String browser) throws Exception {
	if(browser.equalsIgnoreCase("firefox")) {
		driver = new FirefoxDriver();
	}
	else if (browser.equalsIgnoreCase("chrome")) {
		driver = new ChromeDriver();	
	}
	else if (browser.equalsIgnoreCase("edge")) {
		driver = new EdgeDriver();
	}
	else {
		//throw new Exception("Incoorect Browser");
	}
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	@Test
	public void verifyTitle() {
		driver.get("https://www.youtube.com/");
		String title = driver.getTitle();
		System.out.println(title);
		org.testng.Assert.assertEquals("YouTube", title);
		driver.quit();
}}