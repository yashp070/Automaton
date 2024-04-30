package learnTestNG;

import java.time.Duration;
import java.util.Date;
import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class PlayWithCookies {
@Test
	public void handleCookies() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
		driver.get("https://www.myntra.com/");
		Set<Cookie> cookies = driver.manage().getCookies();
		System.out.println(cookies);
		System.out.println(cookies.size());
//		for (Cookie cookie : cookies) {
//			String cookieName = cookie.getName();
//			System.out.println(cookieName);
//		}
//		driver.manage().deleteAllCookies();
//		Set<Cookie> cookiesAfterDeletation = driver.manage().getCookies();
//		System.out.println(cookiesAfterDeletation.size());
		Date expiryDate = driver.manage().getCookieNamed("_d_id").getExpiry();
		System.out.println(expiryDate);
	}
}
