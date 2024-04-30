package Practice;

import java.awt.Desktop.Action;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.chrome.ChromeDriver;

public class AI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    WebDriver driver = new ChromeDriver();
    driver.get("https://platform.openai.com/");
    JavascriptExecutor jse = (JavascriptExecutor)driver;
    jse.executeScript("document.getElementsByClassName(\"ytp-copylink-title\")");
    
    //driver.findElement(by.)
	}

}
