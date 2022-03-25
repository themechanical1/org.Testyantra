package practiceForTestNG;

import org.testng.annotations.Test;

public class CreateContactTest {
	@Test(groups="regerssionTest")
	
	public void contactName() {
		System.out.println("Contact Name Created");
		
	}
	@Test(groups="smokeTest")
	
	public void contactWithNumber() {
		System.out.println("Contact is Created with Number");
	}

}
