package practiceForTestNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryImplementationClassTest {
	@Test(retryAnalyzer=com.crm.Autodesk.genericUtility.RetryAnalayzerImplementationClass.class)
	
	
	public void create() {
		System.out.println("retry");
		Assert.assertEquals(false, true);
	}

}
