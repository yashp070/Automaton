package Practice;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultiWindowsHandle {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.amazon.com/");
		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.get("https://www.flipkart.com/");
		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.get("https://www.myntra.com/");
		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.get("https://www.ajio.com");
		
		Set<String> AllWid = driver.getWindowHandles();
		
		for (String wid : AllWid) {
			System.out.println(wid);
			String widTitle = driver.switchTo().window(wid).getTitle();
			System.out.println(widTitle);
			if (widTitle.equals("Amazon.com")) {
				//driver.close();
			}else if (widTitle.equals("Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!")) {
				driver.switchTo().activeElement();
				driver.findElement(By.xpath("//span[text()='Appliances']")).click();
				String ActualTitle = driver.getTitle();
				if (ActualTitle.equals("Tvs And Appliances New Clp Store Online - Buy Tvs And Appliances New Clp Online at Best Price in India | Flipkart.com")) {
					System.out.println("Test is passed");
				}else {
					System.out.println("Test is failed");
				}
			}
			else if (widTitle.equals("Online Shopping for Women, Men, Kids Fashion & Lifestyle - Myntra")) {
				//driver.close();
			}
			else if (widTitle.equals("Online Shopping for Women, Men, Kids – Clothing, Footwear | AJIO")) {
				driver.close();
			}
		}
		
	}
}
