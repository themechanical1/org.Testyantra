package practiceForTestNG;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class PracticeSoftAssertTest {
	@Test
	
	public void withoutassertAll() {
		int a=6556;
		int b=4566;
		SoftAssert softAssert=new SoftAssert();
		softAssert.assertEquals(a, b);
	}
	@Test
	
	public void intSoftAssert() {
		int a=6556;
		int b=4566;
		SoftAssert softAssert=new SoftAssert();
		softAssert.assertEquals(a, b);
		softAssert.assertAll();
	}
	@Test
	public void intSoftassertwithSameValue() {
		int a=6556;
		int b=6556;
		SoftAssert softAssert=new SoftAssert();
		softAssert.assertEquals(a, b);
		softAssert.assertAll();
	}

}
