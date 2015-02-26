package org.gestion.cr;

import static org.junit.Assert.assertTrue;

import org.aspectj.lang.annotation.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestJPA {
	
	
	@Test
	public void test2() 
	{
		try
		{
		ClassPathXmlApplicationContext app=
				new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
		
	}catch(Exception e){
		assertTrue(e.getMessage(),false);
	}

}
}