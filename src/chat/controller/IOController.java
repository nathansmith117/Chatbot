package chat.controller;

import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

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
}
