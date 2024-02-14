package chat.tests;


/**
 * Project imports
 */
import chat.controller.IOController;
import chat.controller.Controller;

/**
 * Reflection imports
 */
import java.lang.reflect.*;
import java.util.ArrayList;

/**
 * Testing imports
 */

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
class IOControllerTest
{

	private IOController tested;
	
	@BeforeEach
	void setUp() throws Exception
	{
		this.tested = new IOController();
	}

	@AfterEach
	void tearDown() throws Exception
	{
		this.tested = null;
	}
	
	@Test
	void testMethods()
	{
		Method[] ioMethods = tested.getClass().getDeclaredMethods();
		assertTrue(ioMethods.length == 2, "There should only be two methods in your IOController class");
		
		for (Method currentMethod : ioMethods)
		{
			int methodModifiers = currentMethod.getModifiers();
			assertTrue(Modifier.isPublic(methodModifiers), "The method must be public");
			assertTrue(Modifier.isStatic(methodModifiers), "The method needs to be static!");
			
			if (currentMethod.getName().contains("load"))
			{
				assertTrue(currentMethod.getReturnType().equals(ArrayList.class), "The method needs to be a ArrayList method!");
				assertTrue(currentMethod.getParameterCount() == 2, "The loadData method must have exactly 2 parameters");
			}
			
			if (currentMethod.getName().contains("save"))
			{
				assertTrue(currentMethod.getReturnType().equals(Void.TYPE), "The method needs to be a void method!");
				assertTrue(currentMethod.getParameterCount() == 3, "The saveData method must have exactly 3 parameters");
			}
			
		}
	}

}
