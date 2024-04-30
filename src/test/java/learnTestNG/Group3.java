package learnTestNG;

import org.testng.annotations.Test;

public class Group3 {
@Test(groups = {"smoke"})
	public void k() {
		System.out.println("F belongs to smoke");
	}
@Test(groups = "functional")
	public void l() {
		System.out.println("l belongs to functional");
	}
@Test(groups = "integration")
	public void m() {
		System.out.println("m belongs to integration");
	}
}
