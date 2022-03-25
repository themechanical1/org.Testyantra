package practiceForTestNG;

import org.testng.annotations.Test;

public class CreateOrganizationTest {
	@Test(groups="regerssionTest")
	
	public void organizationwithMandatoryField() {
		System.out.println("Organization Is Created with Mandatory Field");
	}
	@Test(groups="smokeTest")
	public void organizationwithContact() {
		System.out.println("Organization with contact is Created");
	}

}
