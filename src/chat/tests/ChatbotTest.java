package chat.tests;

/**
 * Project imports
 */
import chat.model.Chatbot;
import java.util.ArrayList;
import java.util.Arrays;
import java.time.LocalDateTime;

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

class ChatbotTest
{
	private Chatbot testedBot;

	@BeforeEach
	public void setUp() throws Exception
	{
		this.testedBot = new Chatbot("");
	}

	@AfterEach
	public void tearDown() throws Exception
	{
		this.testedBot = null;
	}

	@Test
	public void testToString()
	{
		String result = testedBot.toString();
		assertTrue(result.indexOf("@") == -1, "The toString method must be overwritten");
	}

	@Test
	public void testConstructor()
	{
		Constructor [] chatbotConstructors = testedBot.getClass().getDeclaredConstructors();
		assertTrue(chatbotConstructors.length >= 1, "You need at least one constructor");
		for (Constructor current : chatbotConstructors)
		{
			int params = current.getParameterCount();
			assertTrue(params > 0, "You need at least one parameter in Chatbot constructor");
		}
	}
	
	@Test
	public void testStructure()
	{
		Method [] methods = testedBot.getClass().getDeclaredMethods();
		assertTrue(methods.length >= 15, "You need at least 15 methods in your chatbot!");
		String [] names = {"spookyChecker","spookyResponse","timeDateChecker","timeDateResponse","isValidHTMLChecker","isValidHTMLResponse","processText","encouragingMessage", "reversePronounDirection", "findSmallestWord", "translateToPigLatin"};
		ArrayList<String> requiredMethods = new ArrayList<String>( Arrays.asList(names));
		for (Method method : methods)
		{
			int index = requiredMethods.indexOf(method.getName()); 
			if (index >= 0)
			{
				requiredMethods.remove(index);
			}
			
		}
		assertTrue(requiredMethods.size() == 0, "You do not have all the required methods." + requiredMethods.size() + " is/are missing");
		names = new String [] {"spookyChecker","spookyResponse","timeDateChecker","timeDateResponse","isValidHTMLChecker","isValidHTMLResponse","encouragingMessage", "reversePronounDirection", "findSmallestWord", "translateToPigLatin"};
		requiredMethods = new ArrayList<String>( Arrays.asList(names));
		for (Method method : methods)
		{
			int index = requiredMethods.indexOf(method.getName());
			if (index >= 0)
			{
				int returnType = method.getModifiers();
				assertTrue(Modifier.isPrivate(returnType), "This method: " + method.getName() + " must be private!");
			}
			
		}
		
	}
	

}
