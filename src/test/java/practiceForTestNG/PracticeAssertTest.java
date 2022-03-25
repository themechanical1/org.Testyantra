package practiceForTestNG;

import org.testng.Assert;
import org.testng.annotations.Test;



public class PracticeAssertTest {
	@Test
	
	public void StringAssert() {
		String Name1= "Prince";
		String Name2="Aman";
		
		Assert.assertEquals(Name2, Name1);
		
	}
	@Test
	public void booleanassert() {
		boolean flag=true;
		boolean flag1=true;
		Assert.assertEquals(flag, flag1);
		
	}
	@Test
	public void intassert() {
		int num=10;
		int num1=20;
		Assert.assertEquals(num, num1);
	}
	@Test
	
	public void intassert1() {
		int num2=15;
		int num3=15;
		Assert.assertEquals(num2, num3);
	}
	

}
