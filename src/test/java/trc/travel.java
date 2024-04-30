package trc;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class travel {

	
@Test

public static void run() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.saucedemo.com/");
		
		WebElement username = driver.findElement(By.id("user-name"));
		username.sendKeys("standard_user");
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		
		driver.findElement(By.id("react-burger-menu-btn")).click();
		driver.findElement(By.id("about_sidebar_link")).click();
		String Url = driver.getCurrentUrl();
		
		if (Url.equals("https://saucelabs.com/")) {
			System.out.println("user is taken to https://saucelabs.com/");
		}else {
			System.out.println("user is not taken to https://saucelabs.com/");
		}
		
		driver.navigate().back();
		if (Url.equals("https://www.saucedemo.com/")) {
			System.out.println("user is taken to https://www.saucedemo.com/");
		}else {
			System.out.println("user is not taken to https://www.saucedemo.com/");
		}
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,400)");
		 
		List<WebElement> products = driver.findElements(By.id("inventory_container"));
		
		double highestPrice = 0.0;
		WebElement selectedProduct = null;
		
		for (WebElement product : products) {
			 
			String priceText = product.findElement(By.xpath("//div[@class = 'inventory_item_price']")).getText();
			 double price = Double.parseDouble(priceText.replaceAll("[^\\d.]", ""));
			 System.out.println(price);
			 System.out.println(priceText);
			 
			 if (price > highestPrice) {
				highestPrice = price;
				selectedProduct = product;
			}
		}
		if (selectedProduct != null) {
			selectedProduct.click();
		}
		
		driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
		
		driver.findElement(By.id("shopping_cart_container")).click();
		
		String carturl = driver.getCurrentUrl();
		if (carturl.equals("https://www.saucedemo.com/cart.html")) {
			System.out.println("This is the cart page");
		}
		else {
			System.out.println("This is not the cart page");
		}

		driver.findElement(By.id("checkout")).click();
		
		

	
}

}
