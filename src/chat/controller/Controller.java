package chat.controller;

import chat.model.Chatbot;
import chat.view.Popup;

public class Controller
{
	private Chatbot chatbot;
	private Popup view;
	
	public Controller()
	{
		this.chatbot = new Chatbot("ur mom");
		this.view = new Popup();
	}
	
	public void start()
	{
		String response = view.askQuestion("What is your name?");
		chatbot.setUsername(response);
		
		while (!response.equals("quit"))
		{
			response = interactWithChatbot(response);
			response = view.askQuestion(response);
		}
		
		quit();
	}
	
	private String interactWithChatbot(String input)
	{
		String response = chatbot.processText(input);
		
		return response;
	}
	
	public String interactWithChatbot(String input, int choice)
	{
		String response = "";
		
		return response;
	}
	
	public void quit()
	{
		System.exit(0);
	}
	
	public void save()
	{
		
	}
	
	public void load()
	{
		
	}
	
	public void handleError(Exception error)
	{
		view.displayMessage(error.getMessage());
	}
}
