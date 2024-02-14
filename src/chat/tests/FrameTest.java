package chat.tests;

/**
 * Project imports
 */
import chat.view.*;
import chat.controller.Controller;
/**
 * Reflection imports
 */
import java.lang.reflect.*;

import javax.swing.JFrame;

/**
 * Testing imports
 */

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FrameTest
{
	private ChatFrame testedFrame;

	@BeforeEach
	void setUp() throws Exception
	{
		this.testedFrame = new ChatFrame(new Controller());
	}

	@AfterEach
	void tearDown() throws Exception
	{
		this.testedFrame = null;
	}

	@Test
	void testChatFrame()
	{
		assertTrue(testedFrame instanceof JFrame, "ChatFrame needs to extend JFrame");
		Method[] methods = testedFrame.getClass().getDeclaredMethods();
		assertTrue(methods.length == 1, "You need exactly 1 method in the ChatFrame");
		assertTrue(testedFrame.getTitle().length() > 5, "Your title needs at least 6 letters");
		assertTrue(!testedFrame.isResizable(), "Your ChatFrame should NOT be resizable!");
		assertTrue(testedFrame.getTitle().toLowerCase().contains("chat"), "Your title needs to have chat in it");
		assertTrue(testedFrame.getContentPane() instanceof ChatPanel, "Your ChatFrame needs to have a ChatPanel inside");
	}
}
