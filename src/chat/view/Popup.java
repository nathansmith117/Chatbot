package chat.view;

import javax.swing.JOptionPane;

public class Popup
{
	public void displayMessage(String message)
	{
		JOptionPane.showMessageDialog(null, message);
	}
	
	public String askQuestion(String message)
	{
		String response = "";
		
		response = JOptionPane.showInputDialog(null, message);
		
		if (response == null)
		{
			response = "";
		}
		
		return response;
	}
}
