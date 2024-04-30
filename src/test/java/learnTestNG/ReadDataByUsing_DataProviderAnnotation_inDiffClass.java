package learnTestNG;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class ReadDataByUsing_DataProviderAnnotation_inDiffClass {
	WebDriver driver;
@Test(dataProvider = "dataProviderMethod", dataProviderClass = ReadDataByUsing_DataProviderAnnotation_insameClass.class)
	public void ReadDataFromDataProvider_InDiffClass(String url, String username, String password) throws InterruptedException {
		driver = new FirefoxDriver();
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
}
