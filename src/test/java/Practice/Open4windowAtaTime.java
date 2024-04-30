package Practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class Open4windowAtaTime {
public static void main(String[] args) {
	WebDriver driver = new ChromeDriver();
	driver.get("https://www.google.com/");
	driver.switchTo().newWindow(WindowType.TAB);
	driver.get("https://www.google.com/");
	driver.switchTo().newWindow(WindowType.TAB);
	driver.get("https://www.google.com/");
	driver.switchTo().newWindow(WindowType.TAB);
	driver.get("https://www.google.com/");
}
}
