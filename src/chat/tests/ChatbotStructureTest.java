package chat.tests;

/**
 * Project imports
 */

import chat.model.Chatbot;

/**
 * Reflection imports
 */
import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.HashSet;

/**
 * Testing imports
 */
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ChatbotStructureTest
{
	private Chatbot testedChatbot;

	@BeforeEach
	void setUp() throws Exception
	{
		testedChatbot = new Chatbot("");
	}

	@AfterEach
	void tearDown() throws Exception
	{
		testedChatbot = null;
	}

	@Test
	void testBasicMethods()
	{
		Method [] testedMethods = testedChatbot.getClass().getDeclaredMethods();
		
		int minimumBasicCount = 6;
		int basicCount = 0;
		for (Method currentMethod : testedMethods)
		{
			if (currentMethod.getName().equals("processText"))
			{
				basicCount++;
				assertTrue(currentMethod.getParameterCount() == 1, "The processText method needs exactly 1 parameter");
				assertTrue(Modifier.isPublic(currentMethod.getModifiers()), "The processText method must be public!");
			}
			else
			{
				assertTrue(Modifier.isPrivate(currentMethod.getModifiers()), "The other Chatbot methods must be private!");
				if (currentMethod.getName().equals("spookyChecker"))
				{
					basicCount++;
					assertTrue(currentMethod.getParameterCount() == 1, "The spookyChecker method needs exactly 1 parameter");
					assertTrue(currentMethod.getReturnType().equals(Boolean.TYPE), "The method needs to be a boolean method!");
				}
				else if (currentMethod.getName().equals("spookyResponse"))
				{
					basicCount++;
					assertTrue(currentMethod.getParameterCount() == 0, "The spookyResponse method needs exactly 0 parameters");
					assertTrue(currentMethod.getReturnType().equals(String.class), "The method needs to be a String method!");
				}
				else if (currentMethod.getName().equals("isValidHTMLChecker"))
				{
					basicCount++;
					assertTrue(currentMethod.getParameterCount() == 1, "The isValidHTMLChecker method needs exactly 1 parameter");
					assertTrue(currentMethod.getReturnType().equals(Boolean.TYPE), "The method needs to be a boolean method!");
				}
				else if (currentMethod.getName().equals("isValidHTMLResponse"))
				{
					basicCount++;
					assertTrue(currentMethod.getParameterCount() == 0, "The isValidHTMLResponse method needs exactly 0 parameters");
					assertTrue(currentMethod.getReturnType().equals(String.class), "The method needs to be a String method!");
				}
				else if (currentMethod.getName().equals("reversePronounDirection"))
				{
					basicCount++;
					assertTrue(currentMethod.getParameterCount() == 1, "The reversePronounDirection method needs exactly 1 parameter");
					assertTrue(currentMethod.getReturnType().equals(String.class), "The method needs to be a String method!");
				}
			}
		}
		
		assertTrue(basicCount == minimumBasicCount, "You need all required methods from the yellow sheet");
	}

	@Test
	void testSecondaryMethodsExistence()
	{
		String [] listBased = {"answerRiddle", "tellGroanJoke", "tellRandomFact" };
		String [][] checkerBased = {{"holidayChecker", "holidayResponse"}, {"computerScienceChecker", "computerScienceResponse"}, {"currentEventChecker", "currentEventResponse"}};
		
		int requiredCount = 3;
		int totalCount = 0;
		
		Method [] testedMethods = testedChatbot.getClass().getDeclaredMethods();
		
		for (Method currentMethod : testedMethods)
		{
			for (String listed : listBased)
			{
				if (listed.equals(currentMethod.getName()))
				{
					totalCount++;
				}
			}
		}
		
		for (String [] pair : checkerBased)
		{
			int match = 0;
			for (Method current : testedMethods)
			{
				if (pair[0].equals(current.getName()))
				{
					match++;
				}
				else if (pair[1].equals(current.getName()))
				{
					match++;
				}
			}
			if (match == 2)
			{
				totalCount++;	
			}
			match = 0;
		}
		
		assertTrue(requiredCount <= totalCount, "You need at least 3 of the optional method groups");
	}
	
}
