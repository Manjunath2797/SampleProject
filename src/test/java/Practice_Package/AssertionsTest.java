package Practice_Package;

import static org.testng.Assert.*;

import org.apache.poi.hpsf.Array;
import org.testng.annotations.Test;


public class AssertionsTest {
	
	@Test
	public void create()
	{
		String a = "testyantra";
		String b = "qspiders";
		System.out.println("-----Line 1-----");
		System.out.println("-----Line 2-----");
		assertTrue(a.equals(b));
		System.out.println("-----Line 3-----");
		System.out.println("-----Line 4-----");
	}
	
	@Test
	public void update()
	{
		String x = null;
		assertNull(x);
		System.out.println("-----Line 6-----");
	}
	

}
