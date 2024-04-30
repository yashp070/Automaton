package learnTestNG;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

 
public class BeforeMethodAfterMethodAnnotation {
	public WebDriver driver;
@BeforeMethod
	public void executeBeforeMethod() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
@AfterMethod
	public void executeAfterMethod() {
		driver.manage().window().minimize();
		driver.quit();
	}
@Test(priority = 1)
	public void loginToActiTime() {
		driver.get("https://demo.actitime.com/login.do");
		WebElement userNameTextField = driver.findElement(By.id("username"));
		userNameTextField.sendKeys("admin");
		WebElement PasswordTextField = driver.findElement(By.name("pwd"));
		PasswordTextField.sendKeys("manager");
		WebElement loginOption = driver.findElement(By.id("loginButton"));
		loginOption.click();
	}
@Test(priority = 2, dependsOnMethods = "loginToActiTime")
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
