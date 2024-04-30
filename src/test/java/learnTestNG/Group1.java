package learnTestNG;

import org.testng.annotations.Test;

public class Group1 {
@Test(groups = {"integration","adhoc"})
	public void a() {
		System.out.println("A belongs to integration and adhoc");
	}
@Test(groups = "functional")
	public void b() {
		System.out.println("b belongs to functional");
	}
@Test(groups = "smoke")
	public void c() {
		System.out.println("c belongs to smoke");
	}
}
