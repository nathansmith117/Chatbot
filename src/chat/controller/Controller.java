package chat.controller;

import chat.model.Chatbot;
import chat.view.Popup;

public class Controller
{
	private Chatbot chatbot;
	private Popup popup;
	
	public Controller()
	{
		this.chatbot = new Chatbot("nathan");
		this.popup = new Popup();
	}
	
	public void start()
	{
		while (true)
		{
			if (interactWithChatbot())
			{
				break;
			}
		}
	}
	
	// Return true if should quit
	private boolean interactWithChatbot()
	{
		String input = popup.askQuestion("Enter stuff");
		
		if (input.equals(""))
		{
			return true;
		}
		
		popup.displayMessage(chatbot.processText(input));
		return false;
	}
}
