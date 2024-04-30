package learnTestNG;

import org.testng.annotations.Test;

public class PriorityArgument {
@Test(priority = 1)
	public void loginPage() {
		System.out.println("Login Page Has Been Executed");
	}
@Test(priority = 2)
	public void homePage() {
		System.out.println("HomePage Page Has Been Executed");
	}
@Test(priority = 3)
	public void productPage() {
		System.out.println("Product Page Has Been Executed");
	}
}
