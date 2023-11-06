package chat.tests;

/**
 * Project imports
 */
import chat.controller.Controller;

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

class ControllerTest
{
	private Controller testedController;

	@BeforeEach
	void setUp() throws Exception
	{
		this.testedController = new Controller();
	}

	@AfterEach
	void tearDown() throws Exception
	{
		this.testedController = null;
	}

	@Test
	void testDataMembers()
	{
		Field [] fields = testedController.getClass().getDeclaredFields();
		assertTrue(fields.length >= 2, "You need at least 2 data members in your Controller");
		boolean hasPopup = false;
		boolean hasChatbot = false;

		for (Field field : fields)
		{

			String name = field.getType().getSimpleName();
			if (name.equals("Popup"))
			{
				hasPopup = true;
			}
			else if (name.equals("Chatbot"))
			{
				hasChatbot = true;
			}	
		}
		assertTrue(hasPopup, "You need a Popup as a data member");
		assertTrue(hasChatbot, "You need a Chatbot as a data member");
	}

	@Test
	void testMethods()
	{
		Method [] methods = testedController.getClass().getDeclaredMethods();
		assertTrue(methods.length >= 6, "You need at least six methods in the controller");
		boolean hasStart = false;
		int interactCount = 0;
		boolean hasInteract = false;
		boolean hasHandle = false;
		boolean hasSave = false;
		boolean hasLoad = false;
		boolean hasQuit = false;
		
		for (Method method : methods)
		{
			Type[] types = method.getGenericParameterTypes();
			if (method.getName().equals("handleError"))
			{
				hasHandle = true;

				assertTrue(types[0].getTypeName().equals("java.lang.Exception"), "The parameter type needs to be: Exception");
			}
			else if (method.getName().equals("start"))
			{
				hasStart = true;
				assertTrue(types.length == 0, "Start has no parameters!");
				
			}
			else if (method.getName().equals("save"))
			{
				hasSave = true;
				assertTrue(types.length == 0, "Save has no parameters!");
				
			}
			else if (method.getName().equals("load"))
			{
				hasLoad = true;
				assertTrue(types.length == 0, "Load has no parameters!");
			
			}
			else if (method.getName().equals("quit"))
			{
				hasLoad = true;
				assertTrue(types.length == 0, "Load has no parameters!");

			}
			else if (method.getName().equals("interactWithChatbot"))
			{
				hasInteract = true;
				assertTrue(types[0].getTypeName().equals("java.lang.String"), "The first parameter type needs to be: String");
				interactCount++;
			}
		}

		assertTrue(hasHandle, "You need a method named handleError");
		assertTrue(hasInteract, "You need a method named interactWithChatbot");
		assertTrue(interactCount == 2, "You need two methods named interactWithChatbot");
		assertTrue(hasStart, "You need a method named start");
		assertTrue(hasSave, "You need a method named save");
		assertTrue(hasLoad, "You need a method named load");
		assertTrue(hasQuit, "You need a method named quit");
	}

}
