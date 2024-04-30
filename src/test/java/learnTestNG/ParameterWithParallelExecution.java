package learnTestNG;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterWithParallelExecution {
	WebDriver driver;
@Parameters({"browser","url","username","password"})
@Test
	public void loginToActiTime(String browser, String url, String username, String password) {
	if(browser.equals("chrome")) {
		driver = new ChromeDriver();
	}else if (browser.equals("firefox")) {
		driver = new FirefoxDriver();
	}
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	driver.get(url);
	WebElement usernameTextField = driver.findElement(By.id("username"));
	usernameTextField.sendKeys(username);
	WebElement passwordTextField = driver.findElement(By.name("pwd"));
	passwordTextField.sendKeys(password);
	driver.findElement(By.id("loginButton")).click();
	driver.manage().window().minimize();
	driver.quit();
	
}
}
