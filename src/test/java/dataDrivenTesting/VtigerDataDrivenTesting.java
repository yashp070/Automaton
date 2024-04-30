package dataDrivenTesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class VtigerDataDrivenTesting {
	public static WebDriver driver;
public static void main(String[] args) throws IOException, Throwable {
	FileInputStream fis = new FileInputStream("./src/test/resources/VtigerAppCdata.properties");
	Properties probj = new Properties();
	probj.load(fis);
	String browserName = probj.getProperty("browser");
	if (browserName.equals("chrome")) {
		driver = new ChromeDriver();
	}else if (browserName.equals("edge")) {
		driver = new EdgeDriver();
	}else if (browserName.equals("firefox")) {
		driver = new FirefoxDriver();
	}
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	driver.get(probj.getProperty("url"));
	Thread.sleep(2000);
	WebElement username = driver.findElement(By.id("username"));
	username.clear();
	username.sendKeys(probj.getProperty("username"));
	Thread.sleep(2000);
	WebElement password = driver.findElement(By.id("password"));
	password.clear();
	password.sendKeys(probj.getProperty("password"));
	Thread.sleep(2000);
	WebElement signinButton = driver.findElement(By.xpath("//button[normalize-space()='Sign in']"));
	signinButton.submit();
	Thread.sleep(4000);
	driver.manage().window().maximize();
	driver.quit();
}
}
