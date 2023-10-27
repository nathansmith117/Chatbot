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
		randomChatType = 9;
		
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
			output += "yo " + username + "\n" + encouragingMessage() + "\n";
		}
		else if (randomChatType == 6)
		{
			output += input + "\n";
			output += findSmallestWord(input);
			output += "\n";
		}
		else if (randomChatType == 7)
		{
			output += input + "\n";
			output += reversePronounDirection(input);
			output += "\n";
		}
		else if (randomChatType == 8)
		{
			output += getInsultingJoke() + "\n";
		}
		else if (randomChatType == 9)
		{
			output += talkToKarlMarx(input) + "\n";
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
			
			if (firstVowel > firstSpace)
			{
				firstVowel = 0;
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
		String[] words = source.split(" ");
		String smallest = words[0];
		
		for (String word : words)
		{
			if (word.length() < smallest.length())
			{
				smallest = word;
			}
		}
		
		return smallest;
	}
	
	private String reversePronounDirection(String source)
	{
		String pronoun = "";
		
		if (source.toLowerCase().equals("i") || source.toLowerCase().equals("me"))
		{
			pronoun = "you";
		}
		else if (source.toLowerCase().equals("you"))
		{
			pronoun = "i/me";
		}
		else
		{
			pronoun = "Unknown pronoun";
		}
		
		return pronoun;
	}
	
	private String encouragingMessage()
	{
		String message = "";
		
		String[] messages = {
			"You got this!",
			"Sending major good vibes your way!",
			"Hope you’re doing awesome!"
		};
		
		message = messages[(int)(Math.random() * messages.length)];
		
		return message;
	}
	
	private String getInsultingJoke()
	{
		String joke = "";
		
		String[] jokes = {
			"You are the human equivalent of a participation trophy",
			"Can I have the name of your hair salon? I need to know where not to go",
			"I smell something burning. Are you trying to think again?",
			"You'll go far someday. And I hope you stay there",
			"Your gene pool needs more chlorine",
			"Imagine how many crises would have been averted if your parents bothered to use a condom",
			"If I gave you a penny for your thoughts, I'd get change back",
			"You're why shampoo bottles have instructions",
			"You're so ugly you'd make a Happy Meal cry",
			"Yo mama so fat she uses Google Earth to take a selfie",
			"Yo mama so fat she wears a sock on each toe",
			"Yo mama so stupid she got locked in a mattress store and slept on the floor"
		};
		
		joke = jokes[(int)(Math.random() * jokes.length)];
		
		return joke;
	}
	
	// This should count as the philosophy opinion (:
	private String talkToKarlMarx(String source)
	{
		String message = "";
		String quote = "";
		
		String[] quotes = {
				"We should not say that one man's hour is worth another man's hour, but rather that one man during an hour is worth just as much as another man during an hour. Time is everything, man is nothing: he is at the most time's carcass.",
				"Workers of the world unite; you have nothing to lose but your chains!",
				"Society does not consist of individuals but expresses the sum of interrelations, the relations within which these individuals stand.",
				"Art is always and everywhere the secret confession, and at the same time the immortal movement of its time.",
				"From each according to his abilities, to each according to his needs.",
				"Catch a man a fish, and you can sell it to him. Teach a man to fish, and you ruin a wonderful business opportunity.",
		};
		
		quote = quotes[(int)(Math.random() * quotes.length)];
		
		if (source.toLowerCase().contains("capitalism"))
		{
			message = "Capitalist production, therefore, develops technology, and the combining together of various processes into a social whole, only by sapping the original sources of all wealth - the soil and the labourer.";
		}
		else if (source.toLowerCase().contains("democracy"))
		{
			message = "Democracy is the road to socialism.";
		}
		else if (source.toLowerCase().contains("rich"))
		{
			message = "The rich will do anything for the poor but get off their backs.";
		}
		else if (source.toLowerCase().contains("religion"))
		{
			message = "Religion is the sigh of the oppressed creature, the heart of a heartless world, and the soul of soulless conditions. It is the opium of the people.";
		}
		else if (source.toLowerCase().contains("property"))
		{
			message = "The theory of Communism may be summed up in one sentence: Abolish all private property.";
		}
		else if (source.toLowerCase().contains("reason"))
		{
			message = "Reason has always existed, but not always in a reasonable form.";
		}
		else if (source.toLowerCase().contains("bourgeois"))
		{
			message = "In bourgeois society capital is independent and has individuality, while the living person is dependent and has no individuality.";
		}
		else
		{
			message = quote;
		}
		
		return message;
	}
}
