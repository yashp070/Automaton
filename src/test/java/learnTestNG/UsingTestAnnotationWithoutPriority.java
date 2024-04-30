package learnTestNG;

import org.testng.annotations.Test;

public class UsingTestAnnotationWithoutPriority {
@Test
	public void loginPage() {
		System.out.println("Login Page Has Been Executed");
	}
@Test
	public void homePage() {
		System.out.println("Home Page Has Been Executed");
	}
@Test
	public void productPage() {
		System.out.println("Product Page Has Been Executed");
	}
}
