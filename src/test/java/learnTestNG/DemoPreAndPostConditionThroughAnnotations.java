package learnTestNG;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DemoPreAndPostConditionThroughAnnotations {
WebDriver driver;
@BeforeClass
	public void executeBeforeClass() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
@AfterClass
	public void executeAfterClass() {
		driver.manage().window().minimize();
		driver.quit();
	}
@Test(priority = 1)
public void loginToActiTime() throws InterruptedException {
	driver.get("https://demo.actitime.com/login.do");
	WebElement userNameTextField = driver.findElement(By.id("username"));
	userNameTextField.sendKeys("admin");
	WebElement PasswordTextField = driver.findElement(By.name("pwd"));
	PasswordTextField.sendKeys("manager");
	Thread.sleep(2000);
	WebElement loginOption = driver.findElement(By.id("loginButton"));
	loginOption.click();
	Thread.sleep(4000);
}
@Test(priority = 2)
public void loginToVtiger() {
	driver.get("https://demo.vtiger.com/vtigercrm/");
	WebElement userNameTextField = driver.findElement(By.id("username"));
	userNameTextField.clear();
	userNameTextField.sendKeys("admin");
	WebElement passwordTextField = driver.findElement(By.id("password"));
	passwordTextField.clear();
	passwordTextField.sendKeys("Test@123");
	WebElement signInButton = driver.findElement(By.xpath("//button[text()='Sign in']"));
	signInButton.submit();
}
}
