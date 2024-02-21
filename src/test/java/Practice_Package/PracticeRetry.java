package Practice_Package;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PracticeRetry 
{

	@Test(retryAnalyzer = com.SDET43.GenericLibraries.RetryImplementationClass.class)
	public void practiceRetry()
	{
		System.out.println("-- script 1 --");
		System.out.println("-- script 2 --");
		Assert.fail();
		System.out.println("-- script 3 --");
		System.out.println("-- script 4 --");
	}
}
