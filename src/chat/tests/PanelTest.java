package chat.tests;

/**
 * Project imports
 */
import chat.view.ChatPanel;
import chat.controller.Controller;
/**
 * Reflection imports
 */
import java.lang.reflect.*;
import java.awt.*;
import javax.swing.*;
/**
 * Testing imports
 */
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PanelTest
{
	private ChatPanel testedPanel;

	@BeforeEach
	void setUp() throws Exception
	{
		this.testedPanel = new ChatPanel(new Controller());
	}

	@AfterEach
	void tearDown() throws Exception
	{
		this.testedPanel = null;
	}

	@Test
	void testStructure()
	{
		assertTrue(testedPanel instanceof JPanel, "ChatPanel needs to extend JPanel");

		Field [] dataMembers = testedPanel.getClass().getDeclaredFields();
		
		for (Field field : dataMembers)
		{
			int status = field.getModifiers();
			assertTrue(Modifier.isPrivate(status), "All data members need to be private!");
		}

		assertTrue(testedPanel.getLayout() instanceof SpringLayout, "The ChatPanel layout manager should be SpringLayout");

		Component [] contents = testedPanel.getComponents();
		int fieldCount = 0;
		int panelCount = 0;
		int paneCount = 0;
		int buttonCount = 0;
		
		
		for (Component current : contents)
		{
			
			if (current instanceof JPanel)
			{
				JPanel subPanel = (JPanel) current;
				assertTrue(subPanel.getLayout() instanceof GridLayout, "Subpanels need GridLayout as the layout manager");
				panelCount++;
				for (Component panelItem : subPanel.getComponents())
				{
					if (panelItem instanceof JTextField)
					{
						fieldCount++;
						JTextField tested = (JTextField) panelItem;
						assertTrue(tested.getActionListeners().length == 1, "The Chat textfield needs a listener!");
					}
					else if (panelItem instanceof JPanel)
					{
						panelCount++;
						for (Component subPanelItem : ((JPanel)panelItem).getComponents())
						{
							if (subPanelItem instanceof JButton)
							{
								buttonCount++;
								JButton tested = (JButton) subPanelItem;
								assertTrue(tested.getActionListeners().length == 1, "ALL Buttons need listeners!");
								
							}
						}	
					}

				}
			}
			else if (current instanceof JScrollPane)
			{
				paneCount++;
				JScrollPane tested = (JScrollPane) current;

				assertTrue(tested.getVerticalScrollBarPolicy() == JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, "The vertical Scroll should be as needed");
				assertTrue(tested.getHorizontalScrollBarPolicy() == JScrollPane.HORIZONTAL_SCROLLBAR_NEVER, "The horizontal Scroll should be never");

				assertTrue(tested.getViewport().getView() instanceof JTextArea, "Your Scrollpane needs the JTextArea as a view");
				JTextArea area = (JTextArea)  tested.getViewport().getView();
				assertFalse(area.isEnabled(), "The JTextArea should not be enabled");
			}

		}
		
		assertTrue(paneCount >= 1, "You need a JScrollPane");
		assertTrue(buttonCount >= 6, "You need at least six buttons");
		assertTrue(fieldCount == 1, "You need one JTextField");
		assertTrue(panelCount == 2, "You need 2 JPanels with a grid layout");
		
	}
	
	
	@Test
	void testRequiredMethods()
	{
		Method [] methods = testedPanel.getClass().getDeclaredMethods();
		assertTrue(methods.length >= 6, "You need at least 6 methods in the ChatPanel");
		boolean hasUpdateDisplay = false;
		boolean hasLoadImages = false;
		boolean hasLoadText = false;
		boolean hasSetupPanel = false;
		boolean hasSetupListeners = false;
		boolean hasSetupLayout = false;
		
		for (Method method : methods)
		{
			if (method.getName().equals("updateDisplay"))
			{
				hasUpdateDisplay = true;
				assertTrue(Modifier.isPrivate(method.getModifiers()), "The updateDisplay method must be private");
				assertTrue(method.getParameterCount() == 2, "The updateDisplay method needs two parameters!");
				assertTrue(method.getGenericParameterTypes()[0].getTypeName().equals("java.lang.String"), "The first parameter should be a String");
				assertTrue(method.getGenericParameterTypes()[1].getTypeName().equals("int"), "The second parameter should be an int");
			}
			else if (method.getName().equals("setupPanel"))
			{
				hasSetupPanel = true;
				assertTrue(Modifier.isPrivate(method.getModifiers()), "The setupPanel method must be private");
			}
			else if (method.getName().equals("setupListeners"))
			{
				hasSetupListeners = true;
				assertTrue(Modifier.isPrivate(method.getModifiers()), "The setupListeners method must be private");
			}
			else if (method.getName().equals("setupLayout"))
			{
				hasSetupLayout = true;
				assertTrue(Modifier.isPrivate(method.getModifiers()), "The setupLayout method must be private");
			}
			else if (method.getName().equals("loadImages"))
			{
				hasLoadImages = true;
				assertTrue(Modifier.isPrivate(method.getModifiers()), "The loadImages method must be private");
			}
			else if (method.getName().equals("loadText"))
			{
				hasLoadText = true;
				assertTrue(Modifier.isPrivate(method.getModifiers()), "The loadImages method must be private");
			}
		}
		assertTrue(hasUpdateDisplay, "You need a method named updateDisplay");
		assertTrue(hasSetupPanel, "You need a method named setupPanel");
		assertTrue(hasSetupListeners, "You need a method named setupListeners");
		assertTrue(hasSetupLayout, "You need a method named setupLayout");
		assertTrue(hasLoadImages, "You need a method named loadImages");
		assertTrue(hasLoadText, "You need a method named loadText");
	}

}
