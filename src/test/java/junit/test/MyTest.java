package junit.test;

import org.junit.Assert;
import org.junit.Test;

public class MyTest {

	@Test
	public void test()
    {
        int a=1,b=2;
        int c=a+b;
        System.out.println("11");
        Assert.assertEquals(c,3);
        Assert.assertEquals(c,3); 
        System.out.println("22");
        Assert.assertEquals("55", "55");
    }
	
	
	public void add(){
		int x1=12;
		int x2=5;
		System.out.println(x1+x2);
	}
}
