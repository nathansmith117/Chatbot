package chat.tests;

/**
 * Project imports
 */

import chat.view.Popup;

/**
 * Reflection imports
 */
import java.lang.reflect.*;

/**
 * Testing imports
 */
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PopupTest
{
	private Popup testedPopup;

	@BeforeEach
	void setUp() throws Exception
	{
		testedPopup = new Popup();
	}

	@AfterEach
	void tearDown() throws Exception
	{
		testedPopup = null;
	}

	@Test
	void testPopupStructure()
	{
		Method [] methods = testedPopup.getClass().getDeclaredMethods();
		assertTrue(methods.length == 2, "You need to have two methods");
		
		int expectedPublicCount = 2;
		int totalPublic = 0;
		int requiredMethodCount = 2;
		int actualMethodCount = 0;
		
		for (Method currentMethod : methods)
		{
			if (Modifier.isPublic(currentMethod.getModifiers()))
			{
				totalPublic++;
			}
			if (currentMethod.getName().equals("askQuestion"))
			{
				actualMethodCount++;
				assertTrue(currentMethod.getReturnType().equals(String.class), "This must be a String method");
				assertTrue(currentMethod.getParameterCount() == 1, "This must have a single String parameter");
				assertTrue(currentMethod.getGenericParameterTypes()[0].getTypeName().equals("java.lang.String"), "This must have a single String parameter");
			}
			else if (currentMethod.getName().equals("displayMessage"))
			{
				actualMethodCount++;
				assertTrue(currentMethod.getReturnType().equals(Void.TYPE), "This must be a void method");
				assertTrue(currentMethod.getParameterCount() == 1, "This must have a single String parameter");
				assertTrue(currentMethod.getGenericParameterTypes()[0].getTypeName().equals("java.lang.String"), "This must have a single String parameter");
			}
			
		}
		assertTrue(totalPublic == expectedPublicCount, "You need 2 public methods");
		assertTrue(actualMethodCount == requiredMethodCount, "You need to have askQuestion and displayMessage methods");
	}

}
