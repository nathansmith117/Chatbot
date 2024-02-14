package chat.view;

import javax.swing.JOptionPane;

public class Popup
{
	private ChatFrame window;
	
	public Popup(ChatFrame window)
	{
		this.window = window;
	}
	
	public void displayMessage(String message)
	{
		JOptionPane.showMessageDialog(window, message);
	}
	
	public String askQuestion(String message)
	{
		String response = "";
		
		response = JOptionPane.showInputDialog(window, message);
		
		if (response == null)
		{
			response = "";
		}
		
		return response;
	}
}
