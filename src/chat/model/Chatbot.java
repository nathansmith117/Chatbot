package chat.model;

import java.util.ArrayList;

public class Chatbot
{
	private ArrayList<String> previousResponses;
	private ArrayList<String> userInput;
	private ArrayList<String> basicResponses;
	private String username;
	
	public Chatbot(String username)
	{
		this.username = username;
	}
	
	public String processText(String input)
	{
		String response = "";
		
		return response;
	}
	
	public String processText(String input, int start)
	{
		String response = "";
		
		return response;
	}
	
	private boolean spookyChecker(String input)
	{
		boolean isSpooky = false;
		
		return isSpooky;
	}
	
	private String spookyResponse()
	{
		String spookyMessage = "";
		
		return spookyMessage;
	}
	
	private boolean timeDataChecker(String source)
	{
		boolean answer = false;
		
		return answer;
	}
	
	private String timeResponse()
	{
		String response = "";
		
		return response;
	}
	
	private boolean isValidHTMLChecker(String source)
	{
		boolean answer = false;
		
		return answer;
	}
	
	private String isValidHTMLResponse()
	{
		String response = "";
		
		return response;
	}
	
	private String translateToPigLatin(String source)
	{
		String translated = "";
		
		for (int index = 0; index < source.length(); index++)
		{
			int indexA = source.toLowerCase().indexOf("a");
			int indexE = source.toLowerCase().indexOf("e");
			int indexI = source.toLowerCase().indexOf("i");
			int indexO = source.toLowerCase().indexOf("o");
			int indexU = source.toLowerCase().indexOf("u");
			
			if (indexA < index || indexE < index || indexI < index || indexO < index || indexU < index)
			{
				
			}
		}
		
		return translated;
	}
}
