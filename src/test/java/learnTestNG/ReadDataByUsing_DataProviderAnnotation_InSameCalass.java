package learnTestNG;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ReadDataByUsing_DataProviderAnnotation_InSameCalass {
	WebDriver driver;
@Test(dataProvider = "dataProviderMethod")
	public void dataReadingFromDataProvider(String url, String username, String password) throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get(url);
		WebElement userNameTextField = driver.findElement(By.id("username"));
		Thread.sleep(2000);
		userNameTextField.sendKeys(username);
		WebElement passwordTextField = driver.findElement(By.name("pwd"));
		Thread.sleep(2000);
		passwordTextField.sendKeys(password);
		Thread.sleep(2000);
		driver.findElement(By.id("loginButton")).click();
		driver.manage().window().minimize();
		driver.quit();
	}
@DataProvider
	public Object[][] dataProviderMethod() {
		Object[][] obj = new Object[1][3];
		obj[0][0] = "https://demo.actitime.com/login.do";
		obj[0][1] = "admin";
		obj[0][2] = "manager";
				
		return obj;
	}
}
