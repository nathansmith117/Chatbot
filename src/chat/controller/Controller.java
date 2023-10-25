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
		String input = popup.getInput("Enter stuff");
		
		popup.displayMessage(chatbot.processText(input));
	}
}
