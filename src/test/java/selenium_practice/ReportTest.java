package selenium_practice;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.Autodesk.genericUtility.BaseClass;
@Listeners(com.crm.Autodesk.genericUtility.ListenerImplementationClass.class)
public class ReportTest extends BaseClass {
	@Test
	public void createorg() {
		System.out.println("Passed");
	}
	@Test
	public void createContac() {
		System.out.println("Fail");
		Assert.fail();
	}
	@Test
	public void createLead() {
		throw new SkipException(null);
	}
}
