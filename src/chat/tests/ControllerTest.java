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
		assertTrue(fields.length > 2, "You need at least 3 data members in your Controller");
		boolean hasPopup = false;
		boolean hasChatbot = false;
		boolean hasFrame = false;

		for (Field field : fields)
		{
			assertTrue(Modifier.isPrivate(field.getModifiers()), "All data members must be private!");

			String name = field.getType().getSimpleName();
			if (name.equals("Popup"))
			{
				hasPopup = true;
			}
			else if (name.equals("Chatbot"))
			{
				hasChatbot = true;
			}
			else if (name.equals("ChatFrame"))
			{
				hasFrame = true;
			}
		}
		assertTrue(hasPopup, "You need a Popup as a data member");
		assertTrue(hasFrame, "You need a ChatFrame as a data member");
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
		boolean hasLoadText = false;
		
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
				hasQuit = true;
				assertTrue(types.length == 0, "quit has no parameters!");

			}
			else if (method.getName().equals("interactWithChatbot"))
			{
				hasInteract = true;
				assertTrue(types[0].getTypeName().equals("java.lang.String"), "The first parameter type needs to be: String");
				interactCount++;

				int methodModifiers = method.getModifiers();
				if (types.length == 1)
				{
					assertTrue(Modifier.isPrivate(methodModifiers), "The 1 parameter version must be private");
				}
				else if (types.length == 2)
				{
					assertTrue(Modifier.isPublic(methodModifiers), "The 2 parameter version must be public");
					assertTrue(types[1].getTypeName().equals("int"), "The second parameter type needs to be: int");
				}
			}
			else if (method.getName().equals("loadText"))
			{
				hasLoadText = true;
				assertTrue(method.getReturnType().equals(String.class), "This method should return a String");

			}
		}

		assertTrue(hasHandle, "You need a method named handleError");
		assertTrue(hasInteract, "You need a method named interactWithChatbot");
		assertTrue(interactCount == 2, "You need two methods named interactWithChatbot");
		assertTrue(hasStart, "You need a method named start");
		assertTrue(hasSave, "You need a method named save");
		assertTrue(hasLoad, "You need a method named load");
		assertTrue(hasLoadText, "You need a method named loadText");
		assertTrue(hasQuit, "You need a method named quit");
	}

}
