package selenium_practice;

import org.testng.annotations.Test;

public class dependsOnMethodTest {
	@Test
	
	public void createaccount() throws Exception {
		System.out.println("login in");
		System.out.println("Account Created");
		System.out.println("logout susscefully");
		throw new Exception();
		
	}
	@Test(dependsOnMethods="createaccount")
	
	
	
public void modifyaccount() {
	System.out.println("login in");
	System.out.println("Account Modified");
	System.out.println("logout susscefully");
		
	}
	@Test(dependsOnMethods={"modifyaccount","createaccount"})


public void deleteaccount() {
	System.out.println("login in");
	System.out.println("Account Deleted");
	System.out.println("logout susscefully");
	
}

}
