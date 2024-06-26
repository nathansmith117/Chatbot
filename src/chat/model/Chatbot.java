package chat.model;

import java.time.LocalDateTime;
import java.lang.Math;
import java.util.ArrayList;

public class Chatbot
{
	private String username;
	
	private ArrayList<String> userInput;
	private ArrayList<String> chatbotResponses;
	
	public Chatbot(String username)
	{
		this.username = username;
		this.userInput = new ArrayList<String>();
		this.chatbotResponses = new ArrayList<String>();
	}
	
	public void setUsername(String username)
	{
		this.username = username;
	}
	
	public String processText(String input)
	{
		int randomChatType = (int)(generateNumberFromString(input) * 11);
		String output = processText(input, randomChatType);
		return output;
	}

	public String processText(String input, int choice)
	{
		userInput.add(input);
		String output = "";
		
		if (choice == 0)
		{
			output += "you said " + input;
			output += "\n";
		}
		else if (choice == 1)
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
		else if (choice == 2)
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
		else if (choice == 3)
		{
			if (isValidHTMLChecker(input))
			{
				output += isValidHTMLResponse() + "\n";
			}
			else
			{
				output += "not html";
				output += "\n";
			}
		}
		else if (choice == 4)
		{
			output += "pig latin of input " + input;
			output += "\n";
			output += translateToPigLatin(input);
			output += "\n";
		}
		else if (choice == 5)
		{
			output += "yo " + username + "\n" + encouragingMessage() + "\n";
		}
		else if (choice == 6)
		{
			output += input + "\n";
			output += findSmallestWord(input);
			output += "\n";
		}
		else if (choice == 7)
		{
			output += input + "\n";
			output += reversePronounDirection(input);
			output += "\n";
		}
		else if (choice == 8)
		{
			output += tellInsultingJoke() + "\n";
		}
		else if (choice == 9)
		{
			output += talkToKarlMarx(input) + "\n";
		}
		else if (choice == 10)
		{
			if (computerScienceChecker(input))
			{
				output += computerScienceResponse() + "\n";
			}
			else
			{
				output += "No computer science found ):\n";
			}
		}
		else if (choice == 11)
		{
			if (holidayChecker(input))
			{
				output += holidayResponse() + "\n";
			}
			else
			{
				output += "No holiday found ): Quite a boring time of the year." + "\n";
			}
		}
		
		chatbotResponses.add(output);
		return output;
	}
	
	// The number ranges from 0.0 to 1.0
	private double generateNumberFromString(String source)
	{
		int hash = 0;
		int maxValue = 1;
		
		for (int index = 0; index < source.length(); index++)
		{
			int currentValue = (int)(source.charAt(index));
			hash ^= currentValue;
			
			if (currentValue > maxValue)
			{
				maxValue = currentValue;
			}
		}
		
		double output = (double)hash / maxValue;
		
		// Stop output from going over one.
		if (output > 1.0)
		{
			output = output % 1.0;
		}
		
		return output;
	}
	
	private boolean spookyChecker(String source)
	{
		boolean isSpooky = false;
		
		String[] spookyStuff = {
			"skeleton",
			"zombie",
			"bats",
			"costumes",
			"pumpkins",
			"spiders",
			"vampires"
		};
		
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
		boolean isValid = false;
		
		if (source.contains("<") && source.contains(">"))
		{
			int startOpenTag = source.indexOf("<");
			int startCloseTag = source.indexOf(">");
			
			if (startOpenTag < startCloseTag)
			{
				int endText = source.indexOf(" ", startOpenTag);
				
				if (endText == -1 || endText > startCloseTag)
				{
					endText = startCloseTag;
				}
				
				String tag = source.substring(startOpenTag + 1, endText);
				
				if (tag.length() > 0)
				{
					int endOpenTag = source.indexOf("</", startCloseTag);
					int endCloseTag = source.indexOf(">", endOpenTag);
					
					if (endOpenTag > -1 && endCloseTag > -1)
					{
						String closeTag = source.substring(endOpenTag + 1, endCloseTag);
						
						if (tag.equalsIgnoreCase(closeTag)) {
							isValid = true;
						}
					}
				}
			}
		}
		
		return isValid;
	}
	
	private String isValidHTMLResponse()
	{
		String response = "HTML indeed";
		
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
		String smallest = "";
		
		int length = Integer.MAX_VALUE;
		
		String [] words = source.trim().split(" ");
		
		for (int index = words.length - 1; index >= 0; index--)
		{ 
			String current = words[index];
			
			if (current.length() < length)
			{
				length = current.length();
				smallest = current;
			}
		}
		
		return smallest;
	}
	
	private String reversePronounDirection(String source)
	{
		String output = "";
		
		output = source.replace("I ", "You ");
		output = output.toUpperCase().replace(" ME ", " YOU ");
		output = output.replace("you", "me");
		output = output.replace(" am ", " are ");
		
		return output;
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
	
	private String tellInsultingJoke()
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
	
	private boolean computerScienceChecker(String source)
	{
		boolean isComputerScience = false;
		
		String[] computerScienceStuff = {
			"computer",
			"programming",
			"debug",
			"linux",
			"app",
			"compile"
		};
		
		for (String current : computerScienceStuff)
		{
			if (source.toLowerCase().contains(current))
			{
				isComputerScience = true;
			}
		}
		
		return isComputerScience;
	}
	
	private String computerScienceResponse()
	{
		String response = "Is computer science stuff (:";
		
		return response;
	}
	
	private boolean holidayChecker(String source)
	{
		boolean isHoliday = false;
		
		String[] holidays = {
			"christmas", // Be a good consumer and buy stuff you don't need with money you don't have
			"new years", // A good time to get frozen in ice for 2000 years
			"easter", // Worship a bunny that lays eggs 
			"independence day", // The day we escaped the smelly tea drinking brits (:
			"halloween", // GIVE ME CANDY!!!
			"thanksgiving", // You better go on a diet afterwards
			"saint joseph's day", // A quite big holiday in my family. LOTS OF YUMMY FOOD!!!
			"presidents day", // Learn about the grandma's on the dollar bills.
			"saint patrick's day", // You better be wearing green that day.
			"labor day" // A holiday I pretty much didn't know even existed entail I read some old books lol
		};
		
		for (String current : holidays)
		{
			if (source.toLowerCase().contains(current))
			{
				isHoliday = true;
			}
		}
		
		return isHoliday;
	}
	
	private String holidayResponse()
	{
		String response = "Fun times indeed (:";
		
		return response;
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
		
		if (source.toLowerCase().contains("hello"))
		{
			message += "Hello comrade, it's time to sieze the MEMES of prodection!\n";
		}
		if (source.toLowerCase().contains("capitalism"))
		{
			message += "Capitalist production, therefore, develops technology, and the combining together of various processes into a social whole, only by sapping the original sources of all wealth - the soil and the labourer.\n";
		}
		if (source.toLowerCase().contains("socialism"))
		{
			message += "The meaning of peace is the absence of opposition to socialism.\n";
		}
		if (source.toLowerCase().contains("communism"))
		{
			message += "Let the ruling classes tremble at a Communistic revolution. The proletarians have nothing to lose but their chains.\n";
		}
		if (source.toLowerCase().contains("democracy"))
		{
			message += "Democracy is the road to socialism.\n";
		}
		if (source.toLowerCase().contains("rich"))
		{
			message += "The rich will do anything for the poor but get off their backs.\n";
		}
		if (source.toLowerCase().contains("religion"))
		{
			message += "Religion is the sigh of the oppressed creature, the heart of a heartless world, and the soul of soulless conditions. It is the opium of the people.\n";
		}
		if (source.toLowerCase().contains("property"))
		{
			message += "The theory of Communism may be summed up in one sentence: Abolish all private property.\n";
		}
		if (source.toLowerCase().contains("reason"))
		{
			message += "Reason has always existed, but not always in a reasonable form.\n";
		}
		if (source.toLowerCase().contains("bourgeois"))
		{
			message += "In bourgeois society capital is independent and has individuality, while the living person is dependent and has no individuality.\n";
		}
		// The funniest one of them all lmao
		if (source.toLowerCase().contains("who is your suger daddy"))
		{
			message += "Comrade Friedrich Engels\n";
		}
		if (source.toLowerCase().contains("lenin"))
		{
			message += "A communists favorite drink is leninmade\n";
		}
		
		if (message.equals(""))
		{
			message = quote;
		}
		
		return message;
	}
	
	public String toString()
	{
		return "A chatbot with the username of " + username;
	}
	
	public ArrayList<String> getUserInput()
	{
		return this.userInput;
	}
	
	public ArrayList<String> getChatbotResponses()
	{
		return this.chatbotResponses;
	}
	
	public void setUserInput(ArrayList<String> userInput)
	{
		this.userInput = userInput;
	}
	
	public void setChatbotResponses(ArrayList<String> chatbotResponses)
	{
		this.chatbotResponses = chatbotResponses;
	}
}
