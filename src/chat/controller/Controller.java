package chat.controller;

import chat.model.Chatbot;
import chat.view.Popup;
import java.util.ArrayList;

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
		
		save();
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
		ArrayList<String> text = chatbot.getUserInput();
		IOController.saveTextToFile(text, "user", this);
		
		text = chatbot.getChatbotResponses();
		IOController.saveTextToFile(text, "chatbot", this);
	}
	
	public void load()
	{
		ArrayList<String> fileInput = IOController.loadTextToListFromFile("User Input.txt", this);
		chatbot.setUserInput(fileInput);
		
		fileInput = IOController.loadTextToListFromFile("Chatbot responses.txt", this);
		chatbot.setChatbotResponses(fileInput);
		
		if (!fileInput.get(0).equals("No text loaded"))
		{
			view.displayMessage("Previous chats loaded!");
		}
	}
	
	public void handleError(Exception error)
	{
		view.displayMessage(error.getMessage());
	}
}
