package practiceForTestNG;

import org.testng.annotations.Test;

public class CampignTest {
	@Test(groups="regerssionTest")
	
	public void createcampignwithMandatoryField() {
		System.out.println("Campign Is Created with Mandatory Fields");
	}
	@Test(groups="smokeTest")
	public void createcampignWithcontact() {
		System.out.println("Campign is created with Contact");
	}

}
