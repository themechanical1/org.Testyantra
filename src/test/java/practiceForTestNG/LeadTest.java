package practiceForTestNG;

import org.testng.annotations.Test;

public class LeadTest {
	@Test(groups="regerssionTest")
	public void createLeadwithMandatoryField() {
		System.out.println("Lead is Created with Mandatory Field");
	}
	@Test(groups="smokeTest")
	public void cretaeLeadWithGroup() {
		System.out.println("Lead is Created with Group");
	}

}
