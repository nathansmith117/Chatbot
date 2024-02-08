package chat.controller;

import chat.model.Chatbot;
import chat.view.Popup;
import java.util.ArrayList;
import chat.view.ChatFrame;

public class Controller
{
	private Chatbot chatbot;
	private Popup view;
	private ChatFrame window;
	
	public Controller()
	{
		this.chatbot = new Chatbot("");
		this.window = new ChatFrame(this);
		this.view = new Popup(this.window);
	}
	
	public void start()
	{
		load();
		String response = view.askQuestion("What is your name?");
		chatbot.setUsername(response);
		
		// Used when the interface was entirely popups.
//		while (!response.equals("quit"))
//		{
//			response = interactWithChatbot(response);
//			response = view.askQuestion(response);
//		}
//		
//		save();
//		quit();
	}
	
	private String interactWithChatbot(String input)
	{
		String response = chatbot.processText(input);
		
		return response;
	}
	
	public String interactWithChatbot(String input, int choice)
	{
		String response = chatbot.processText(input, choice);
		
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
	
	public String loadText()
	{
		String text = "";
		ArrayList<String> userInput = IOController.loadTextToListFromFile("User Input.txt", this);
		ArrayList<String> chatInput = IOController.loadTextToListFromFile("Chatbot responses.txt", this);
		
		for (int index = 0; index < userInput.size(); index++)
		{
			text += userInput.get(index) + "\n";
			text += chatInput.get(index) + "\n";
		}
		
		return text;
	}
	
	public void handleError(Exception error)
	{
		view.displayMessage(error.getMessage());
	}
}
