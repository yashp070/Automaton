package learnTestNG;

import org.testng.annotations.Test;

public class ExecuteWithInvocationCountArgument {
@Test(invocationCount = 3)
	public void login() {
		System.out.println("Login Page Has Been Executed");
	}
@Test(invocationCount = 2)
	public void homePage() {
		System.out.println("Home Page Has Been Executed");
	}
@Test(invocationCount = 2)
	public void productPage() {
		System.out.println("Product Page Has Been Executed");
	}
}
