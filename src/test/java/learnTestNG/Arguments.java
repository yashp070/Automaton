package learnTestNG;

import org.testng.annotations.Test;

public class Arguments {
@Test(priority = 1, invocationCount = 3)
	public void loginPage() {
		System.out.println("Login Page Has Been Executed");
	}
@Test(priority = 2, dependsOnMethods = "loginPage")
	public void homePage() {
		System.out.println("Home Page Has Been Executed");
	}
@Test(priority = 3, dependsOnMethods = {"loginPage","homePage"})
	public void productPage() {
		System.out.println("Product Page Has Been Executed");
	}
@Test(priority = 4, invocationCount = 2, dependsOnMethods = {"loginPage","homePage","productPage"})
	public void addToCart() {
		System.out.println("Add To Cart Page Has Been Executed");
	}
@Test(priority = 5, invocationCount = 2, dependsOnMethods = {"loginPage","homePage","productPage","addToCart"})
	public void paymentPage() {
		System.out.println("Payment Page Has Been Executed");
	}
}
