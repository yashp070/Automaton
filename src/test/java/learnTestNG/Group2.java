package learnTestNG;

import org.testng.annotations.Test;

public class Group2 {
@Test(groups = {"functional"})
	public void f() {
		System.out.println("F belongs to functional");
	}
@Test(groups = "smoke")
	public void g() {
		System.out.println("g belongs to smoke");
	}
@Test(groups = "integration")
	public void h() {
		System.out.println("h belongs to integration");
	}
}
