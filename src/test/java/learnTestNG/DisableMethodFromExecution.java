package learnTestNG;

import org.testng.annotations.Test;

public class DisableMethodFromExecution {
@Test(enabled = false)
	public void login() {
		System.out.println("Login Page Has Been Executed");
	}
@Test(enabled = false)
	public void homePage() {
		System.out.println("Home Page Has Been Executed");
	}
@Test()
	public void productPage() {
		System.out.println("Product Page Has Been Executed");
	}
}
