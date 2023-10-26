package chat.model;

import java.time.LocalDateTime;
import java.lang.Math;
import java.util.ArrayList;

public class Chatbot
{
	private ArrayList<String> previousResponses;
	private ArrayList<String> userInput;
	private ArrayList<String> basicResponses;
	private String username;
	
	public Chatbot(String username)
	{
		this.previousResponses = new ArrayList<String>();
		this.userInput = new ArrayList<String>();
		this.basicResponses = new ArrayList<String>();
		this.username = username;
	}
	
	// I need to write this lmao
	public String processText(String input)
	{
		int randomChatType = (int)(Math.random() * 10);
		randomChatType = 4;
		
		String output = "";
		
		if (randomChatType == 0)
		{
			output = "you said " + input;
			output += "\n";
		}
		else if (randomChatType == 1)
		{
			if (spookyChecker(input))
			{
				output += spookyResponse();
				output += "\n";
			}
			else
			{
				output += "bleh";
				output += "\n";
			}
		}
		else if (randomChatType == 2)
		{
			if (timeDateChecker(input))
			{
				output += timeDateResponse() + "\n";
			}
			else
			{
				output += "idk";
				output += "\n";
			}
		}
		else if (randomChatType == 3)
		{
			if (isValidHTMLChecker(input))
			{
				output += isValidHTMLResponse() + "\n";
			}
			else
			{
				output += "idc";
				output += "\n";
			}
		}
		else if (randomChatType == 4)
		{
			output += "pig latin of input " + input;
			output += "\n";
			output += translateToPigLatin(input);
			output += "\n";
		}
		else if (randomChatType == 5)
		{
			output += username + " " + encouragingMessage() + "\n";
		}
		else if (randomChatType == 6)
		{
			output += "\n" + input;
			output += findSmallestWord(input);
			output += "\n";
		}
		else if (randomChatType == 7)
		{
			output += "\n" + input;
			output += reversePronounDirection(input);
			output += "\n";
		}
		else if (randomChatType == 8)
		{
		}
		else if (randomChatType == 9)
		{
		}
		else
		{
		}
		
		return output;
	}
	
	public String processText(String input, int start)
	{
		String response = "";
		
		return response;
	}
	
	private boolean spookyChecker(String source)
	{
		boolean isSpooky = false;
		
		ArrayList<String> spookyStuff = new ArrayList<String>();
		spookyStuff.add("skeleton");
		spookyStuff.add("zombie");
		spookyStuff.add("bats");
		spookyStuff.add("costumes");
		spookyStuff.add("pumpkins");
		spookyStuff.add("spiders");
		spookyStuff.add("vampires");
		
		for (String current : spookyStuff)
		{
			if (source.toLowerCase().indexOf(current) >= 0)
			{
				isSpooky = true;
			}
		}
		
		return isSpooky;
	}
	
	private String spookyResponse()
	{
		String response = "that is too spooky!";
		
		return response;
	}
	
	private boolean timeDateChecker(String source)
	{
		boolean isAsking = false;
		
		boolean hasTime = source.toUpperCase().contains("TIME");
		boolean hasDate = source.toLowerCase().contains("date");
		boolean hasHour = source.toUpperCase().contains("HOUR");
		boolean hasYear = source.toLowerCase().indexOf("year") >= 0;
		boolean hasMinute = source.toLowerCase().indexOf("minute") > -1;
		
		if (hasTime || hasDate || hasHour || hasYear || hasMinute)
		{
			isAsking = true;
		}
		
		return isAsking;
	}
	
	private String timeDateResponse()
	{
		String timeAndDate = "";
		
		LocalDateTime current = LocalDateTime.now();
		
		timeAndDate += "the current day is " + current.getDayOfWeek() + " the " + current.getDayOfMonth() + "of " + current.getMonth() + ", " + current.getYear();
		timeAndDate += "\n";
		timeAndDate += "it is " + current.getHour() + ":" + current.getMinute();
		timeAndDate += "\n";
		
		return timeAndDate;
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
			
			int firstVowel = 0;
			int firstSpace = source.indexOf(" ");
			
			if (firstSpace == -1)
			{
				firstSpace = source.length();
			}
			
			if (indexA >= 0
					&& (indexE == -1 || indexA < indexE)
					&& (indexI == -1 || indexA < indexI)
					&& (indexO == -1 || indexA < indexO)
					&& (indexU == -1 || indexA < indexU))
			{
				firstVowel = indexA;
			}
			else if (indexE >= 0
					&& (indexA == -1 || indexE < indexA)
					&& (indexI == -1 || indexE < indexI)
					&& (indexO == -1 || indexE < indexO)
					&& (indexU == -1 || indexE < indexU))
			{
				firstVowel = indexE;
			}
			else if (indexI >= 0
					&& (indexA == -1 || indexI < indexA)
					&& (indexE == -1 || indexI < indexE)
					&& (indexO == -1 || indexI < indexO)
					&& (indexU == -1 || indexI < indexU))
			{
				firstVowel = indexI;
			}
			else if (indexO >= 0
					&& (indexA == -1 || indexO < indexA)
					&& (indexE == -1 || indexO < indexE)
					&& (indexI == -1 || indexO < indexI)
					&& (indexU == -1 || indexO < indexU))
			{
				firstVowel = indexO;
			}
			else if (indexU >= 0
					&& (indexA == -1 || indexU < indexA)
					&& (indexE == -1 || indexU < indexE)
					&& (indexO == -1 || indexU < indexO)
					&& (indexI == -1 || indexU < indexI))
			{
				firstVowel = indexU;
			}
			
			String firstPart = source.substring(0, firstVowel);
			String secondPart = source.substring(firstVowel, firstSpace);
			
			translated += secondPart + "-" + firstPart + "ay ";
			
			if (firstSpace == source.length())
			{
				index = source.length();
			}
			else
			{
				source = source.substring(firstSpace + 1);
				index = -1;
			}
		}
		
		return translated;
	}
	
	private String findSmallestWord(String source)
	{
		String smallest = "";
		
		return smallest;
	}
	
	private String reversePronounDirection(String source)
	{
		String pronoun = "";
		
		return pronoun;
	}
	
	private String encouragingMessage()
	{
		String message = "";
		
		return message;
	}
}
