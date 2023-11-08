package chat.controller;

import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class IOController
{
	public static void saveTextToFile(ArrayList<String> content, String type, Controller app)
	{
		String path = "";
		
		if (type.equals("user"))
		{
			path = "User Input.txt";
		}
		else if (type.equals("chatbot"))
		{
			path = "Chatbot responses.txt";
		}
		
		try (PrintWriter textWriter = new PrintWriter(path))
		{
			while (content.size() > 0)
			{
				String currentLine = content.remove(0);
				textWriter.println(currentLine);
			}
		}
		catch (IOException error)
		{
			app.handleError(error);
		}
	}
	
	public static ArrayList<String> loadTextToListFromFile(String path, Controller app)
	{
		ArrayList<String> texts = new ArrayList<String>();
		
		String contents = "";
		
		File source = new File(path);
		
		try (Scanner textScanner = new Scanner(source))
		{
			while (textScanner.hasNextLine())
			{
				String line = textScanner.nextLine();
				
				if (line.trim().length() > 0)
				{
					texts.add(line);
				}
			}
		}
		catch (FileNotFoundException error)
		{
			app.handleError(error);
			texts.add("No text loaded");
		}
		
		return texts;
	}
}
