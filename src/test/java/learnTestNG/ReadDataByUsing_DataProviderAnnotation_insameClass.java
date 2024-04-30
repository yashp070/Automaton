package learnTestNG;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ReadDataByUsing_DataProviderAnnotation_insameClass {
	WebDriver driver;
@Test(dataProvider = "dataProviderMethod")
	public void readDataFromDataProvider_InSameClass(String url, String username, String password) throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get(url);
		WebElement usernameTextField = driver.findElement(By.id("username"));
		Thread.sleep(2000);
		usernameTextField.clear();
		Thread.sleep(2000);
		usernameTextField.sendKeys(username);
		WebElement passwordTextField = driver.findElement(By.id("password"));
		Thread.sleep(2000);
		passwordTextField.clear();
		Thread.sleep(2000);
		passwordTextField.sendKeys(password);
		driver.findElement(By.xpath("//button[normalize-space()='Sign in']")).click();
		Thread.sleep(2000);
		driver.manage().window().minimize();
		driver.quit();
	}
@DataProvider
	public Object[][] dataProviderMethod(){
		Object[][] obj = new Object[1][3];
		obj[0][0] = "https://demo.vtiger.com/vtigercrm/";
		obj[0][1] = "admin";
		obj[0][2] = "Test@123";
		
		return obj;
	}
}
