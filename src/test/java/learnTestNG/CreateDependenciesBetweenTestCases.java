package learnTestNG;

import org.testng.annotations.Test;

public class CreateDependenciesBetweenTestCases {
@Test(priority = 1, invocationCount = 2)
	public void loginPage() {
		System.out.println("Login Page Has Been Executed");
	}
@Test(priority = 2, dependsOnMethods = "loginPage")
	public void homePage() {
		System.out.println("Home Page Has Been Executed");
	}
@Test(priority = 3, invocationCount = 3, dependsOnMethods = {"loginPage","homePage"})
	public void productPage() {
		System.out.println("Product Page Has Been Executed");
	}
}
